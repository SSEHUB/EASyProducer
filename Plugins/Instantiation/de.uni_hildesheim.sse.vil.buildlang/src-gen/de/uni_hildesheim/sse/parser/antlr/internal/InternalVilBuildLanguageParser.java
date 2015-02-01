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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'instantiate'", "'rule'", "'map'", "'if'", "'else'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'@advice'", "'version'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'"
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

                if ( (LA1_0==39) ) {
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

                if ( (LA3_0==15||LA3_0==37) ) {
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

                if ( (LA4_0==37) ) {
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

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||LA5_0==38||(LA5_0>=67 && LA5_0<=69)) ) {
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

            if ( (LA7_0==38) ) {
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:496:1: ruleScriptContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )* ) ;
    public final EObject ruleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:499:28: ( ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:2: () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )*
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )*
            loop10:
            do {
                int alt10=3;
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
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleRuleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleRuleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:530:3: lv_elements_2_0= ruleRuleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRuleDeclaration_in_ruleScriptContents995);
            	    lv_elements_2_0=ruleRuleDeclaration();

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:554:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:555:2: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:556:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1033);
            iv_ruleRuleDeclaration=ruleRuleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDeclaration1043); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:563:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:566:28: ( ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:1: ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:1: ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:2: () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:568:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:2: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_type_1_0= ruleType ) )?
                    int alt11=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==RULE_VERSION||(LA11_1>=RULE_ID && LA11_1<=RULE_EXPONENT)||LA11_1==26||LA11_1==38||LA11_1==63) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA11_2 = input.LA(2);

                            if ( (LA11_2==RULE_VERSION||(LA11_2>=RULE_ID && LA11_2<=RULE_EXPONENT)||LA11_2==26||LA11_2==38||LA11_2==63) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA11_3 = input.LA(2);

                            if ( (LA11_3==RULE_VERSION||(LA11_3>=RULE_ID && LA11_3<=RULE_EXPONENT)||LA11_3==26||LA11_3==38||LA11_3==63) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case 38:
                            {
                            int LA11_4 = input.LA(2);

                            if ( (LA11_4==RULE_VERSION||(LA11_4>=RULE_ID && LA11_4<=RULE_EXPONENT)||LA11_4==26||LA11_4==38||LA11_4==63) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case 67:
                        case 68:
                        case 69:
                            {
                            alt11=1;
                            }
                            break;
                    }

                    switch (alt11) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_type_1_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_type_1_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:578:3: lv_type_1_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleRuleDeclaration1102);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:594:3: ( (lv_modifier_2_0= ruleRuleModifier ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==26) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_modifier_2_0= ruleRuleModifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_modifier_2_0= ruleRuleModifier )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:3: lv_modifier_2_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1124);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:612:3: ( (lv_name_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:1: (lv_name_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:1: (lv_name_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:3: lv_name_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1146);
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

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleRuleDeclaration1158); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_3());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:634:1: ( (lv_paramList_5_0= ruleParameterList ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_VERSION||(LA13_0>=RULE_ID && LA13_0<=RULE_EXPONENT)||LA13_0==38||(LA13_0>=67 && LA13_0<=69)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:635:1: (lv_paramList_5_0= ruleParameterList )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:635:1: (lv_paramList_5_0= ruleParameterList )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:636:3: lv_paramList_5_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParameterList_in_ruleRuleDeclaration1179);
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

                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleRuleDeclaration1192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_5());
                          
                    }
                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleRuleDeclaration1204); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_6());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:660:3: ( (lv_conditions_8_0= ruleRuleConditions ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_EXPONENT)||LA15_0==16||LA15_0==24||LA15_0==27||LA15_0==29||LA15_0==32||LA15_0==35||LA15_0==38||LA15_0==51||(LA15_0>=54 && LA15_0<=56)||LA15_0==58||(LA15_0>=64 && LA15_0<=66)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:661:1: (lv_conditions_8_0= ruleRuleConditions )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:661:1: (lv_conditions_8_0= ruleRuleConditions )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:662:3: lv_conditions_8_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRuleConditions_in_ruleRuleDeclaration1227);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:678:3: ( (lv_block_9_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:679:1: (lv_block_9_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:679:1: (lv_block_9_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:680:3: lv_block_9_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1249);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:696:2: (otherlv_10= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:696:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleRuleDeclaration1262); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:708:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:709:2: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:710:2: iv_ruleRuleConditions= ruleRuleConditions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleConditionsRule()); 
            }
            pushFollow(FOLLOW_ruleRuleConditions_in_entryRuleRuleConditions1300);
            iv_ruleRuleConditions=ruleRuleConditions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleConditions; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleConditions1310); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:717:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:720:28: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:721:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:721:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:721:2: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:721:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:722:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:730:2: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_EXPONENT)||LA17_0==16||LA17_0==27||LA17_0==29||LA17_0==32||LA17_0==35||LA17_0==38||LA17_0==51||(LA17_0>=54 && LA17_0<=56)||LA17_0==58||(LA17_0>=64 && LA17_0<=66)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:731:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:731:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:732:3: lv_postcondition_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPostconditionLogicalExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1368);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleRuleConditions1381); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:752:1: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_EXPONENT)||LA19_0==16||LA19_0==27||LA19_0==29||LA19_0==32||LA19_0==35||LA19_0==38||LA19_0==51||(LA19_0>=54 && LA19_0<=56)||LA19_0==58||(LA19_0>=64 && LA19_0<=66)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:752:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:752:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:753:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:753:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:754:3: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1403);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:770:2: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:770:4: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleRuleConditions1416); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:774:1: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:775:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:775:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:776:3: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1437);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:800:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:801:2: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:802:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementBlockRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1477);
            iv_ruleRuleElementBlock=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElementBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElementBlock1487); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:809:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:812:28: ( ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:813:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:813:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:813:2: () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:813:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:814:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRuleElementBlock1536); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:826:1: ( (lv_elements_2_0= ruleRuleElement ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_EXPONENT)||LA20_0==16||LA20_0==18||LA20_0==27||(LA20_0>=29 && LA20_0<=30)||LA20_0==32||(LA20_0>=35 && LA20_0<=36)||LA20_0==38||LA20_0==51||(LA20_0>=54 && LA20_0<=56)||LA20_0==58||(LA20_0>=64 && LA20_0<=69)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:827:1: (lv_elements_2_0= ruleRuleElement )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:827:1: (lv_elements_2_0= ruleRuleElement )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:828:3: lv_elements_2_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1557);
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleRuleElementBlock1570); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:856:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:857:2: (iv_ruleRuleElement= ruleRuleElement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:858:2: iv_ruleRuleElement= ruleRuleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElement_in_entryRuleRuleElement1606);
            iv_ruleRuleElement=ruleRuleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElement1616); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:865:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) ;
    public final EObject ruleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:868:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:869:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:869:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:869:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:869:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:870:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:870:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:871:3: lv_varDecl_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1662);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:889:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:889:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:890:3: lv_exprStmt_1_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleRuleElement1689);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:914:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:915:2: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:916:2: iv_ruleRuleModifier= ruleRuleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleModifierRule()); 
            }
            pushFollow(FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1725);
            iv_ruleRuleModifier=ruleRuleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleModifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleModifier1735); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:923:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:926:28: ( ( (lv_protected_0_0= 'protected' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:927:1: ( (lv_protected_0_0= 'protected' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:927:1: ( (lv_protected_0_0= 'protected' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:928:1: (lv_protected_0_0= 'protected' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:928:1: (lv_protected_0_0= 'protected' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:929:3: lv_protected_0_0= 'protected'
            {
            lv_protected_0_0=(Token)match(input,26,FOLLOW_26_in_ruleRuleModifier1777); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:950:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:951:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:952:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement1825);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement1835); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:959:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) | ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? ) ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_expr_2_0 = null;

        EObject lv_alt_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:962:28: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) | ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) | ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) | ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_EXPONENT)||LA24_0==16||LA24_0==18||LA24_0==27||LA24_0==29||LA24_0==32||LA24_0==35||LA24_0==38||LA24_0==51||(LA24_0>=54 && LA24_0<=56)||LA24_0==58||(LA24_0>=64 && LA24_0<=66)) ) {
                alt24=1;
            }
            else if ( (LA24_0==30) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:3: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';'
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:3: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
                    int alt22=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1==23) ) {
                                alt22=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA22_2 = input.LA(2);

                            if ( (LA22_2==23) ) {
                                alt22=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA22_3 = input.LA(2);

                            if ( (LA22_3==23) ) {
                                alt22=1;
                            }
                            }
                            break;
                        case 38:
                            {
                            int LA22_4 = input.LA(2);

                            if ( (LA22_4==23) ) {
                                alt22=1;
                            }
                            }
                            break;
                    }

                    switch (alt22) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:4: ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '='
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:963:4: ( (lv_var_0_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:964:1: (lv_var_0_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:964:1: (lv_var_0_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:965:3: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement1883);
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

                            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement1895); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:985:3: ( (lv_expr_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:986:1: (lv_expr_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:986:1: (lv_expr_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:987:3: lv_expr_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement1918);
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

                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement1930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:6: ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:6: ( ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )? )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:7: ( (lv_alt_4_0= ruleAlternative ) ) (otherlv_5= ';' )?
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:7: ( (lv_alt_4_0= ruleAlternative ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1009:1: (lv_alt_4_0= ruleAlternative )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1009:1: (lv_alt_4_0= ruleAlternative )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1010:3: lv_alt_4_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getAltAlternativeParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAlternative_in_ruleExpressionStatement1959);
                    lv_alt_4_0=ruleAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"alt",
                              		lv_alt_4_0, 
                              		"Alternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:2: (otherlv_5= ';' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==14) ) {
                        int LA23_1 = input.LA(2);

                        if ( (synpred25_InternalVilBuildLanguage()) ) {
                            alt23=1;
                        }
                    }
                    switch (alt23) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:4: otherlv_5= ';'
                            {
                            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement1972); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1_1());
                                  
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1038:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1039:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1040:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2011);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2021); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1047:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1050:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1051:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1051:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt25=8;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1051:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1051:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1052:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1052:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1053:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression2067);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1070:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1070:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1071:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1071:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1072:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression2094);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1089:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1089:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1090:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1090:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1091:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2121);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1108:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1108:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1109:1: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1109:1: (lv_sysEx_3_0= ruleSystemExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1110:3: lv_sysEx_3_0= ruleSystemExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSysExSystemExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2148);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1127:6: ( (lv_map_4_0= ruleMap ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1127:6: ( (lv_map_4_0= ruleMap ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1128:1: (lv_map_4_0= ruleMap )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1128:1: (lv_map_4_0= ruleMap )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1129:3: lv_map_4_0= ruleMap
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMapMapParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMap_in_rulePrimaryExpression2175);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1146:6: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1146:6: ( (lv_join_5_0= ruleJoin ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1147:1: (lv_join_5_0= ruleJoin )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1147:1: (lv_join_5_0= ruleJoin )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1148:3: lv_join_5_0= ruleJoin
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getJoinJoinParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJoin_in_rulePrimaryExpression2202);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1165:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1165:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1166:1: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1166:1: (lv_instantiate_6_0= ruleInstantiate )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1167:3: lv_instantiate_6_0= ruleInstantiate
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInstantiateInstantiateParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInstantiate_in_rulePrimaryExpression2229);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1184:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1184:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1185:1: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1185:1: (lv_newEx_7_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1186:3: lv_newEx_7_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2256);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1210:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1211:2: (iv_ruleInstantiate= ruleInstantiate EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1212:2: iv_ruleInstantiate= ruleInstantiate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstantiateRule()); 
            }
            pushFollow(FOLLOW_ruleInstantiate_in_entryRuleInstantiate2292);
            iv_ruleInstantiate=ruleInstantiate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstantiate; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantiate2302); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1219:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1222:28: ( (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1223:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1223:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1223:3: otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleInstantiate2339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:1: ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_VERSION||(LA27_0>=RULE_ID && LA27_0<=RULE_EXPONENT)||LA27_0==38) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_STRING) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:3: ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:3: ( (lv_project_1_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1228:1: (lv_project_1_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1228:1: (lv_project_1_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1229:3: lv_project_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getProjectIdentifierParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleInstantiate2362);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1245:2: (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==28) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1245:4: otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleInstantiate2375); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getInstantiateAccess().getRuleKeyword_1_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1249:1: ( (lv_rule_3_0= RULE_STRING ) )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1250:1: (lv_rule_3_0= RULE_STRING )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1250:1: (lv_rule_3_0= RULE_STRING )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1251:3: lv_rule_3_0= RULE_STRING
                            {
                            lv_rule_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2392); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_ruleName_4_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_ruleName_4_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1270:3: lv_ruleName_4_0= RULE_STRING
                    {
                    lv_ruleName_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2423); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleInstantiate2441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1290:1: ( (lv_param_6_0= ruleArgumentList ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_EXPONENT)||LA28_0==16||LA28_0==18||LA28_0==27||LA28_0==29||LA28_0==32||LA28_0==35||LA28_0==38||LA28_0==51||(LA28_0>=54 && LA28_0<=56)||LA28_0==58||(LA28_0>=64 && LA28_0<=66)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1291:1: (lv_param_6_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1291:1: (lv_param_6_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1292:3: lv_param_6_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleInstantiate2462);
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

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleInstantiate2475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1312:1: ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1313:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1313:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1314:3: lv_versionSpec_8_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getVersionSpecVersionSpecParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleInstantiate2496);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1338:1: entryRuleMapVariable returns [EObject current=null] : iv_ruleMapVariable= ruleMapVariable EOF ;
    public final EObject entryRuleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1339:2: (iv_ruleMapVariable= ruleMapVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1340:2: iv_ruleMapVariable= ruleMapVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapVariableRule()); 
            }
            pushFollow(FOLLOW_ruleMapVariable_in_entryRuleMapVariable2533);
            iv_ruleMapVariable=ruleMapVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapVariable2543); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1347:1: ruleMapVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1350:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1351:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1351:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1351:2: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1351:2: ( (lv_type_0_0= ruleType ) )?
            int alt30=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==RULE_VERSION||(LA30_1>=RULE_ID && LA30_1<=RULE_EXPONENT)||LA30_1==38||LA30_1==63) ) {
                        alt30=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==RULE_VERSION||(LA30_2>=RULE_ID && LA30_2<=RULE_EXPONENT)||LA30_2==38||LA30_2==63) ) {
                        alt30=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA30_3 = input.LA(2);

                    if ( (LA30_3==RULE_VERSION||(LA30_3>=RULE_ID && LA30_3<=RULE_EXPONENT)||LA30_3==38||LA30_3==63) ) {
                        alt30=1;
                    }
                    }
                    break;
                case 38:
                    {
                    int LA30_4 = input.LA(2);

                    if ( (LA30_4==RULE_VERSION||(LA30_4>=RULE_ID && LA30_4<=RULE_EXPONENT)||LA30_4==38||LA30_4==63) ) {
                        alt30=1;
                    }
                    }
                    break;
                case 67:
                case 68:
                case 69:
                    {
                    alt30=1;
                    }
                    break;
            }

            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1352:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1352:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1353:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapVariableAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleMapVariable2589);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1369:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1370:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1370:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1371:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleMapVariable2611);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1395:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1396:2: (iv_ruleMap= ruleMap EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1397:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_ruleMap_in_entryRuleMap2647);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMap2657); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1404:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1407:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1408:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1408:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1408:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleMap2694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleMap2706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1416:1: ( (lv_var_2_0= ruleMapVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1417:1: (lv_var_2_0= ruleMapVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1417:1: (lv_var_2_0= ruleMapVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1418:3: lv_var_2_0= ruleMapVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2727);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1434:2: (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==25) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1434:4: otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleMap2740); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1438:1: ( (lv_var_4_0= ruleMapVariable ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1439:1: (lv_var_4_0= ruleMapVariable )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1439:1: (lv_var_4_0= ruleMapVariable )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1440:3: lv_var_4_0= ruleMapVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2761);
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
            	    break loop31;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1456:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1457:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1457:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1458:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1458:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==23) ) {
                alt32=1;
            }
            else if ( (LA32_0==24) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1459:3: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_23_in_ruleMap2783); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1471:8: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_24_in_ruleMap2812); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1486:2: ( (lv_expr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1487:1: (lv_expr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1487:1: (lv_expr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1488:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMap2849);
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

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMap2861); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1508:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1509:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1509:1: (lv_block_8_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1510:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleMap2882);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1534:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1535:2: (iv_ruleAlternative= ruleAlternative EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1536:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_ruleAlternative_in_entryRuleAlternative2918);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternative2928); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1543:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1546:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1547:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1547:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1547:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleAlternative2965); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAlternative2977); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1555:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1556:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1556:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1557:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlternative2998);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAlternative3010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1577:1: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1578:1: (lv_if_4_0= ruleStatementOrBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1578:1: (lv_if_4_0= ruleStatementOrBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1579:3: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStatementOrBlock_in_ruleAlternative3031);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==31) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred41_InternalVilBuildLanguage()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleAlternative3052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1600:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1601:1: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1601:1: (lv_else_6_0= ruleStatementOrBlock )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1602:3: lv_else_6_0= ruleStatementOrBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStatementOrBlock_in_ruleAlternative3074);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1626:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1627:2: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1628:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementOrBlockRule()); 
            }
            pushFollow(FOLLOW_ruleStatementOrBlock_in_entryRuleStatementOrBlock3112);
            iv_ruleStatementOrBlock=ruleStatementOrBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementOrBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatementOrBlock3122); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1635:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1638:28: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1640:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1640:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1641:3: lv_exStmt_0_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleStatementOrBlock3168);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1658:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1658:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1659:1: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1659:1: (lv_block_1_0= ruleRuleElementBlock )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1660:3: lv_block_1_0= ruleRuleElementBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getBlockRuleElementBlockParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleStatementOrBlock3195);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1684:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1685:2: (iv_ruleJoin= ruleJoin EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1686:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_ruleJoin_in_entryRuleJoin3231);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoin3241); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1693:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1696:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1697:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1697:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1697:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleJoin3278); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJoin3290); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1705:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1706:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1706:1: (lv_var1_2_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1707:3: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin3311);
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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleJoin3323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1727:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1728:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1728:1: (lv_var2_4_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1729:3: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin3344);
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

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJoin3356); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1749:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1749:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleJoin3369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleJoin3381); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1757:1: ( (lv_condition_8_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:1: (lv_condition_8_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:1: (lv_condition_8_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1759:3: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleJoin3402);
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

                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleJoin3414); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1787:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1788:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1789:2: iv_ruleJoinVariable= ruleJoinVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinVariableRule()); 
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3452);
            iv_ruleJoinVariable=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoinVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoinVariable3462); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1796:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1799:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==34) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1801:1: (lv_excl_0_0= 'exclude' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1801:1: (lv_excl_0_0= 'exclude' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1802:3: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,34,FOLLOW_34_in_ruleJoinVariable3505); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1815:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1816:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1816:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1817:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJoinVariable3540);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleJoinVariable3552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1837:1: ( (lv_expr_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1838:1: (lv_expr_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1838:1: (lv_expr_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1839:3: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getExprExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleJoinVariable3573);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1863:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1864:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1865:2: iv_ruleSystemExecution= ruleSystemExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3609);
            iv_ruleSystemExecution=ruleSystemExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemExecution3619); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1872:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1875:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1876:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1876:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1876:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleSystemExecution3656); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1880:1: ( (lv_call_1_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1881:1: (lv_call_1_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1881:1: (lv_call_1_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1882:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSystemExecution3677);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1898:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==57||(LA37_0>=59 && LA37_0<=60)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1899:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1899:1: (lv_calls_2_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1900:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSystemExecution3698);
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1924:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1925:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1926:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3735);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3745); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1933:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1936:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1937:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1937:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1937:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1937:2: ( (lv_const_0_0= 'const' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==36) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1938:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1938:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1939:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,36,FOLLOW_36_in_ruleVariableDeclaration3788); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1952:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1953:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1953:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1954:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3823);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1970:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1971:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1971:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1972:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3844);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1988:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==23) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1988:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3857); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1992:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1993:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1993:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1994:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3878);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVariableDeclaration3892); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2022:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2023:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2024:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3928);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3938); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2031:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2034:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2035:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2035:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2035:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleAdvice3975); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAdvice3987); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2043:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2044:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2044:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2045:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice4008);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAdvice4020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2065:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==33) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2066:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2066:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2067:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice4041);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2091:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2092:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2093:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec4078);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec4088); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2100:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2103:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2104:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2104:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2104:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleVersionSpec4125); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2108:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2109:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2109:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2110:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec4146);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2134:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2135:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2136:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList4182);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList4192); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2143:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2146:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2147:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2147:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2147:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2147:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2148:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2148:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2149:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4238);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2165:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==25) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2165:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleParameterList4251); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2169:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2170:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2170:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2171:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4272);
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
            	    break loop41;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2195:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2196:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2197:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4310);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4320); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2204:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2207:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2208:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2208:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2208:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2208:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2209:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2209:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2210:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4366);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2226:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2227:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2227:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2228:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4387);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2252:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2254:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4423);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4433); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2261:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2264:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2265:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2265:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2265:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleVersionStmt4470); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2269:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2270:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2270:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2271:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4487); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleVersionStmt4504); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2299:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2300:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2301:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4540);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4550); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2308:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2311:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2312:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2312:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2312:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleImport4587); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2316:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2317:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2317:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2318:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4608);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2334:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==33) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2335:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2335:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2336:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4629);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImport4642); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2364:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2365:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2366:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4678);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4688); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2373:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2376:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2377:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2377:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_EXPONENT)||LA43_0==16||LA43_0==27||LA43_0==29||LA43_0==32||LA43_0==35||LA43_0==38||LA43_0==51||(LA43_0>=54 && LA43_0<=56)||LA43_0==58||(LA43_0>=64 && LA43_0<=66)) ) {
                alt43=1;
            }
            else if ( (LA43_0==18) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2377:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2377:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2378:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2378:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2379:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4734);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2396:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2396:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2397:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2397:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2398:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4761);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2422:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2423:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2424:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4797);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4807); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2431:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2434:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2435:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2435:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2435:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2435:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2436:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2436:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2437:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4853);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2453:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop44:
            do {
                int alt44=2;
                switch ( input.LA(1) ) {
                case 40:
                    {
                    int LA44_2 = input.LA(2);

                    if ( (synpred52_InternalVilBuildLanguage()) ) {
                        alt44=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA44_3 = input.LA(2);

                    if ( (synpred52_InternalVilBuildLanguage()) ) {
                        alt44=1;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA44_4 = input.LA(2);

                    if ( (synpred52_InternalVilBuildLanguage()) ) {
                        alt44=1;
                    }


                    }
                    break;

                }

                switch (alt44) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2455:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4874);
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
            	    break loop44;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2479:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2480:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2481:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4911);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart4921); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2488:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2491:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2492:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2492:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2492:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2492:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2493:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2493:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2494:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4967);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2510:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2511:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2511:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2512:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4988);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2536:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2537:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2538:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5025);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator5036); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2545:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2548:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2549:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2549:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt45=1;
                }
                break;
            case 41:
                {
                alt45=2;
                }
                break;
            case 42:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2550:2: kw= 'and'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleLogicalOperator5074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2557:2: kw= 'or'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleLogicalOperator5093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2564:2: kw= 'xor'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleLogicalOperator5112); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2577:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2578:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2579:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5152);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5162); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2586:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2589:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2590:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2590:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2590:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2590:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2591:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2591:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2592:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5208);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2608:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt46=2;
            switch ( input.LA(1) ) {
                case 43:
                    {
                    int LA46_1 = input.LA(2);

                    if ( (synpred55_InternalVilBuildLanguage()) ) {
                        alt46=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA46_2 = input.LA(2);

                    if ( (synpred55_InternalVilBuildLanguage()) ) {
                        alt46=1;
                    }
                    }
                    break;
                case 45:
                    {
                    int LA46_3 = input.LA(2);

                    if ( (synpred55_InternalVilBuildLanguage()) ) {
                        alt46=1;
                    }
                    }
                    break;
            }

            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2610:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5229);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2634:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2635:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2636:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5266);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5276); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2643:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2646:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2647:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2647:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2647:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2647:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2648:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2648:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2649:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5322);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2665:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2666:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2666:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2667:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5343);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2691:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2692:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2693:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5380);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5391); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2700:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2703:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2704:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2704:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt47=1;
                }
                break;
            case 44:
                {
                alt47=2;
                }
                break;
            case 45:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2705:2: kw= '=='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleEqualityOperator5429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2712:2: kw= '<>'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleEqualityOperator5448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2719:2: kw= '!='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleEqualityOperator5467); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2732:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2733:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2734:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5507);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5517); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2741:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2744:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2745:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2745:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2745:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2745:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2746:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2746:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2747:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5563);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2763:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt48=2;
            switch ( input.LA(1) ) {
                case 46:
                    {
                    int LA48_1 = input.LA(2);

                    if ( (synpred58_InternalVilBuildLanguage()) ) {
                        alt48=1;
                    }
                    }
                    break;
                case 47:
                    {
                    int LA48_2 = input.LA(2);

                    if ( (synpred58_InternalVilBuildLanguage()) ) {
                        alt48=1;
                    }
                    }
                    break;
                case 48:
                    {
                    int LA48_3 = input.LA(2);

                    if ( (synpred58_InternalVilBuildLanguage()) ) {
                        alt48=1;
                    }
                    }
                    break;
                case 49:
                    {
                    int LA48_4 = input.LA(2);

                    if ( (synpred58_InternalVilBuildLanguage()) ) {
                        alt48=1;
                    }
                    }
                    break;
            }

            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2765:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5584);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2789:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2790:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2791:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5621);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5631); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2798:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2801:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2802:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2802:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2802:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2802:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2803:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2803:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2804:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5677);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2820:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2821:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2821:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2822:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5698);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2846:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2847:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2848:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5735);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5746); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2855:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2858:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2859:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2859:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt49=1;
                }
                break;
            case 47:
                {
                alt49=2;
                }
                break;
            case 48:
                {
                alt49=3;
                }
                break;
            case 49:
                {
                alt49=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2860:2: kw= '>'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleRelationalOperator5784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2867:2: kw= '<'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleRelationalOperator5803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2874:2: kw= '>='
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleRelationalOperator5822); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2881:2: kw= '<='
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleRelationalOperator5841); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2894:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2895:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2896:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5881);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5891); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2903:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2906:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2907:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2907:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2907:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2907:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2909:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5937);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2925:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==50) ) {
                    int LA50_2 = input.LA(2);

                    if ( (synpred62_InternalVilBuildLanguage()) ) {
                        alt50=1;
                    }


                }
                else if ( (LA50_0==51) ) {
                    int LA50_3 = input.LA(2);

                    if ( (synpred62_InternalVilBuildLanguage()) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2927:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5958);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2951:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2952:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2953:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5995);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6005); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2960:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2963:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2964:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2964:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2964:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2964:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2965:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2965:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2966:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6051);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2982:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2983:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2983:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2984:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6072);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3008:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3009:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3010:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6109);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6120); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3017:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3020:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3021:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3021:1: (kw= '+' | kw= '-' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==50) ) {
                alt51=1;
            }
            else if ( (LA51_0==51) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3022:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleAdditiveOperator6158); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3029:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleAdditiveOperator6177); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3042:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3043:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3044:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6217);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6227); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3051:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3054:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3055:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3055:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3055:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3055:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3056:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3056:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3057:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6273);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3073:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                int LA52_1 = input.LA(2);

                if ( (synpred64_InternalVilBuildLanguage()) ) {
                    alt52=1;
                }
            }
            else if ( (LA52_0==53) ) {
                int LA52_2 = input.LA(2);

                if ( (synpred64_InternalVilBuildLanguage()) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3075:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6294);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3099:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3100:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3101:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6331);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6341); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3108:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3111:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3112:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3112:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3112:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3112:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3113:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3113:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3114:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6387);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3130:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3131:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3131:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3132:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6408);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3156:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3157:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3158:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6445);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6456); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3165:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3168:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3169:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3169:1: (kw= '*' | kw= '/' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==52) ) {
                alt53=1;
            }
            else if ( (LA53_0==53) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3170:2: kw= '*'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleMultiplicativeOperator6494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3177:2: kw= '/'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleMultiplicativeOperator6513); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3190:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3191:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3192:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6553);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6563); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3199:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3202:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3203:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3203:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3203:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3203:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==51||(LA54_0>=54 && LA54_0<=55)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3204:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3204:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3205:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6609);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3221:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3222:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3222:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3223:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6631);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3247:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3248:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3249:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6668);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6679); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3256:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3259:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3260:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3260:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt55=1;
                }
                break;
            case 55:
                {
                alt55=2;
                }
                break;
            case 51:
                {
                alt55=3;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3261:2: kw= 'not'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleUnaryOperator6717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3268:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleUnaryOperator6736); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3275:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleUnaryOperator6755); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3288:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3289:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3290:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6795);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6805); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3297:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3300:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3301:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3301:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3302:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3302:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3303:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6850);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3327:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3328:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3329:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6885);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6895); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3336:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3339:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_STRING && LA56_0<=RULE_EXPONENT)||LA56_0==38||(LA56_0>=64 && LA56_0<=66)) ) {
                alt56=1;
            }
            else if ( (LA56_0==16) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3340:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3341:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3341:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3342:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6942);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionOrQualifiedExecution6961); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3363:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3364:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3364:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3365:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6982);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleExpressionOrQualifiedExecution6994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3385:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==57||(LA57_0>=59 && LA57_0<=60)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3386:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3386:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3387:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7017);
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
            	    break loop57;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3411:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3412:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3413:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7054);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7064); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3420:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3423:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3425:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3425:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3426:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7110);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==57||(LA58_0>=59 && LA58_0<=60)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3443:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3443:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3444:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7131);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3468:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3469:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3470:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7168);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7178); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3477:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3480:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3481:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3481:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3481:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleSuperExecution7215); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleSuperExecution7227); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3489:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3490:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3490:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3491:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7248);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3507:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==57||(LA59_0>=59 && LA59_0<=60)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3508:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3508:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3509:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7269);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3533:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3534:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3535:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7306);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7316); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3542:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3545:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3546:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3546:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3546:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleConstructorExecution7353); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3550:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3551:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3551:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3552:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7374);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConstructorExecution7386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3572:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_EXPONENT)||LA60_0==16||LA60_0==18||LA60_0==27||LA60_0==29||LA60_0==32||LA60_0==35||LA60_0==38||LA60_0==51||(LA60_0>=54 && LA60_0<=56)||LA60_0==58||(LA60_0>=64 && LA60_0<=66)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3573:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3573:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3574:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7407);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleConstructorExecution7420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3594:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==57||(LA61_0>=59 && LA61_0<=60)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3595:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3595:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3596:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7441);
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
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3620:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3621:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3622:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7478);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7488); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3629:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3632:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==57||LA63_0==59) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3634:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3634:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3635:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3635:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==57) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==59) ) {
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3636:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,57,FOLLOW_57_in_ruleSubCall7534); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3648:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,59,FOLLOW_59_in_ruleSubCall7563); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3663:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3664:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3664:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3665:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7600);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3682:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3682:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3682:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleSubCall7620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3686:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3687:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3687:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3688:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7641);
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

                    otherlv_4=(Token)match(input,61,FOLLOW_61_in_ruleSubCall7653); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3716:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3717:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3718:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7690);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7700); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3725:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3728:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3729:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3729:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3729:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3729:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3730:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3730:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3731:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7746);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3747:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==14) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3747:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleDeclarator7759); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3751:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3752:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3752:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3753:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7780);
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
            	    break loop64;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleDeclarator7794); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3781:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3782:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3783:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration7830);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration7840); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3790:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3793:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3794:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3794:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3794:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3794:2: ( (lv_type_0_0= ruleType ) )?
            int alt65=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA65_1 = input.LA(2);

                    if ( (LA65_1==RULE_VERSION||(LA65_1>=RULE_ID && LA65_1<=RULE_EXPONENT)||LA65_1==38||LA65_1==63) ) {
                        alt65=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==RULE_VERSION||(LA65_2>=RULE_ID && LA65_2<=RULE_EXPONENT)||LA65_2==38||LA65_2==63) ) {
                        alt65=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA65_3 = input.LA(2);

                    if ( (LA65_3==RULE_VERSION||(LA65_3>=RULE_ID && LA65_3<=RULE_EXPONENT)||LA65_3==38||LA65_3==63) ) {
                        alt65=1;
                    }
                    }
                    break;
                case 38:
                    {
                    int LA65_4 = input.LA(2);

                    if ( (LA65_4==RULE_VERSION||(LA65_4>=RULE_ID && LA65_4<=RULE_EXPONENT)||LA65_4==38||LA65_4==63) ) {
                        alt65=1;
                    }
                    }
                    break;
                case 67:
                case 68:
                case 69:
                    {
                    alt65=1;
                    }
                    break;
            }

            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3795:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3795:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3796:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration7886);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3812:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3813:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3813:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3814:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration7908);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3830:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==25) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3830:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleDeclaration7921); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3834:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3836:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration7942);
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3860:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3861:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3862:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall7980);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall7990); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3869:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3872:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3873:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3873:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3873:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3873:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3874:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3874:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3875:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8036);
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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleCall8048); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3895:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3897:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8069);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3913:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_STRING && LA68_0<=RULE_EXPONENT)||LA68_0==16||LA68_0==18||LA68_0==27||LA68_0==29||LA68_0==32||LA68_0==35||LA68_0==38||LA68_0==51||(LA68_0>=54 && LA68_0<=56)||LA68_0==58||(LA68_0>=64 && LA68_0<=66)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3915:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8091);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleCall8104); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3943:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3944:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3945:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8140);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8150); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3952:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3955:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3956:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3956:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3956:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3956:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3957:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3957:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3958:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8196);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3974:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==25) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3974:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleArgumentList8209); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3978:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3980:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8230);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4004:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4005:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4006:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8268);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8278); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4013:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4016:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt70=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA70_1 = input.LA(2);

                    if ( (LA70_1==23) ) {
                        alt70=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA70_2 = input.LA(2);

                    if ( (LA70_2==23) ) {
                        alt70=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA70_3 = input.LA(2);

                    if ( (LA70_3==23) ) {
                        alt70=1;
                    }
                    }
                    break;
                case 38:
                    {
                    int LA70_4 = input.LA(2);

                    if ( (LA70_4==23) ) {
                        alt70=1;
                    }
                    }
                    break;
            }

            switch (alt70) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4017:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4018:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4018:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4019:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8325);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNamedArgument8337); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4039:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4040:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4040:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4041:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8360);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4065:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4066:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4067:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8396);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8406); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4074:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4077:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4078:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4078:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4078:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4078:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4079:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4079:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4080:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8452);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4096:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==63) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4096:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4096:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4097:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4097:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4098:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,63,FOLLOW_63_in_ruleQualifiedPrefix8471); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4111:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4112:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4112:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4113:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8505);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4137:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4138:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4139:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8543);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8553); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4146:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4149:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4150:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4150:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4150:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4150:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4151:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4151:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4152:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8599);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4168:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==57) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA72_3 = input.LA(3);

                        if ( (LA72_3==EOF||(LA72_3>=14 && LA72_3<=15)||(LA72_3>=17 && LA72_3<=19)||(LA72_3>=24 && LA72_3<=25)||LA72_3==37||(LA72_3>=40 && LA72_3<=53)||LA72_3==57||(LA72_3>=59 && LA72_3<=61)) ) {
                            alt72=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA72_4 = input.LA(3);

                        if ( (LA72_4==EOF||(LA72_4>=14 && LA72_4<=15)||(LA72_4>=17 && LA72_4<=19)||(LA72_4>=24 && LA72_4<=25)||LA72_4==37||(LA72_4>=40 && LA72_4<=53)||LA72_4==57||(LA72_4>=59 && LA72_4<=61)) ) {
                            alt72=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA72_5 = input.LA(3);

                        if ( (LA72_5==EOF||(LA72_5>=14 && LA72_5<=15)||(LA72_5>=17 && LA72_5<=19)||(LA72_5>=24 && LA72_5<=25)||LA72_5==37||(LA72_5>=40 && LA72_5<=53)||LA72_5==57||(LA72_5>=59 && LA72_5<=61)) ) {
                            alt72=1;
                        }
                        }
                        break;
                    case 38:
                        {
                        int LA72_6 = input.LA(3);

                        if ( (LA72_6==EOF||(LA72_6>=14 && LA72_6<=15)||(LA72_6>=17 && LA72_6<=19)||(LA72_6>=24 && LA72_6<=25)||LA72_6==37||(LA72_6>=40 && LA72_6<=53)||LA72_6==57||(LA72_6>=59 && LA72_6<=61)) ) {
                            alt72=1;
                        }
                        }
                        break;
                }

            }
            switch (alt72) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4168:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4168:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4169:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4169:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4170:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,57,FOLLOW_57_in_ruleQualifiedName8618); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4183:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8652);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4209:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4210:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4211:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8690);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8700); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4218:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4221:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4222:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4222:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt74=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt74=1;
                }
                break;
            case RULE_STRING:
                {
                alt74=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 38:
                {
                alt74=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA74_4 = input.LA(2);

                if ( (synpred88_InternalVilBuildLanguage()) ) {
                    alt74=3;
                }
                else if ( (synpred92_InternalVilBuildLanguage()) ) {
                    alt74=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 4, input);

                    throw nvae;
                }
                }
                break;
            case 64:
            case 65:
                {
                alt74=4;
                }
                break;
            case 66:
                {
                alt74=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4222:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4222:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4223:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4223:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4224:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8746);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4241:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4241:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4242:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4242:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4243:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8769); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4261:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4261:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4262:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8801);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4279:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4279:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4280:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4280:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4281:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4281:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==64) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==65) ) {
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4282:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,64,FOLLOW_64_in_ruleConstant8827); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4294:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,65,FOLLOW_65_in_ruleConstant8856); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4310:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4310:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4311:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4311:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4312:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,66,FOLLOW_66_in_ruleConstant8896); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4326:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4326:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4326:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4332:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4333:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant8943); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4357:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4358:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4359:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue8984);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue8994); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4369:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4370:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4370:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4371:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4371:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4372:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9035); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4396:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4397:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4398:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9076);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9087); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4405:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4408:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4409:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4409:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt75=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt75=1;
                }
                break;
            case RULE_VERSION:
                {
                alt75=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt75=3;
                }
                break;
            case 38:
                {
                alt75=4;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4409:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9127); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4417:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9153); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4425:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4434:2: kw= 'version'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleIdentifier9203); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4448:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4449:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9243);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9253); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4456:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4459:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4460:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4460:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt76=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 38:
                {
                alt76=1;
                }
                break;
            case 67:
                {
                alt76=2;
                }
                break;
            case 68:
                {
                alt76=3;
                }
                break;
            case 69:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4460:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4460:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4461:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4461:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4462:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9299);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4479:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4479:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4479:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4479:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4480:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4480:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4481:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,67,FOLLOW_67_in_ruleType9324); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4494:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4495:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4495:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4496:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9358);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4513:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4513:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4513:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4513:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4514:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4514:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,68,FOLLOW_68_in_ruleType9384); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4528:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4529:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4529:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4530:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9418);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4547:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4547:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4547:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4547:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4548:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4548:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4549:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,69,FOLLOW_69_in_ruleType9444); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4562:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4563:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4563:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4564:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9478);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4588:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4589:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4590:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9515);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9525); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4597:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4600:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4601:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4601:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4601:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTypeParameters9562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4605:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4606:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4606:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4607:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9583);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4623:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==25) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4623:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleTypeParameters9596); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4627:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4628:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4628:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4629:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9617);
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
            	    break loop77;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTypeParameters9631); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4657:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4658:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4659:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9667);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9677); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4666:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4671:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer9726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4683:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_STRING && LA79_0<=RULE_EXPONENT)||LA79_0==16||LA79_0==18||LA79_0==27||LA79_0==29||LA79_0==32||LA79_0==35||LA79_0==38||LA79_0==51||(LA79_0>=54 && LA79_0<=56)||LA79_0==58||(LA79_0>=64 && LA79_0<=66)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4683:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4683:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4684:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4684:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4685:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9748);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4701:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==25) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4701:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleContainerInitializer9761); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4705:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4706:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4706:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4707:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9782);
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
                    	    break loop78;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleContainerInitializer9798); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4735:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4736:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4737:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9834);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression9844); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4744:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4747:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4748:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4748:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_EXPONENT)||LA80_0==16||LA80_0==27||LA80_0==29||LA80_0==32||LA80_0==35||LA80_0==38||LA80_0==51||(LA80_0>=54 && LA80_0<=56)||LA80_0==58||(LA80_0>=64 && LA80_0<=66)) ) {
                alt80=1;
            }
            else if ( (LA80_0==18) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4748:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4748:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4749:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4749:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4750:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9890);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4767:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4767:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4768:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4768:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4769:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9917);
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

    // $ANTLR start synpred11_InternalVilBuildLanguage
    public final void synpred11_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_elements_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( ( (lv_elements_2_0= ruleRuleDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleRuleDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleRuleDeclaration )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:530:3: lv_elements_2_0= ruleRuleDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleRuleDeclaration_in_synpred11_InternalVilBuildLanguage995);
        lv_elements_2_0=ruleRuleDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred11_InternalVilBuildLanguage

    // $ANTLR start synpred15_InternalVilBuildLanguage
    public final void synpred15_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_type_1_0 = null;

        EObject lv_modifier_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_type_1_0= ruleType ) )?
        int alt81=2;
        switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA81_1 = input.LA(2);

                if ( (LA81_1==RULE_VERSION||(LA81_1>=RULE_ID && LA81_1<=RULE_EXPONENT)||LA81_1==26||LA81_1==38||LA81_1==63) ) {
                    alt81=1;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA81_2 = input.LA(2);

                if ( (LA81_2==RULE_VERSION||(LA81_2>=RULE_ID && LA81_2<=RULE_EXPONENT)||LA81_2==26||LA81_2==38||LA81_2==63) ) {
                    alt81=1;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA81_3 = input.LA(2);

                if ( (LA81_3==RULE_VERSION||(LA81_3>=RULE_ID && LA81_3<=RULE_EXPONENT)||LA81_3==26||LA81_3==38||LA81_3==63) ) {
                    alt81=1;
                }
                }
                break;
            case 38:
                {
                int LA81_4 = input.LA(2);

                if ( (LA81_4==RULE_VERSION||(LA81_4>=RULE_ID && LA81_4<=RULE_EXPONENT)||LA81_4==26||LA81_4==38||LA81_4==63) ) {
                    alt81=1;
                }
                }
                break;
            case 67:
            case 68:
            case 69:
                {
                alt81=1;
                }
                break;
        }

        switch (alt81) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_type_1_0= ruleType )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_type_1_0= ruleType )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:578:3: lv_type_1_0= ruleType
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_0_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleType_in_synpred15_InternalVilBuildLanguage1102);
                lv_type_1_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:594:3: ( (lv_modifier_2_0= ruleRuleModifier ) )?
        int alt82=2;
        int LA82_0 = input.LA(1);

        if ( (LA82_0==26) ) {
            alt82=1;
        }
        switch (alt82) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_modifier_2_0= ruleRuleModifier )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_modifier_2_0= ruleRuleModifier )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:3: lv_modifier_2_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleRuleModifier_in_synpred15_InternalVilBuildLanguage1124);
                lv_modifier_2_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:612:3: ( (lv_name_3_0= ruleIdentifier ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:1: (lv_name_3_0= ruleIdentifier )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:1: (lv_name_3_0= ruleIdentifier )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:3: lv_name_3_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleIdentifier_in_synpred15_InternalVilBuildLanguage1146);
        lv_name_3_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,16,FOLLOW_16_in_synpred15_InternalVilBuildLanguage1158); if (state.failed) return ;
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:634:1: ( (lv_paramList_5_0= ruleParameterList ) )?
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==RULE_VERSION||(LA83_0>=RULE_ID && LA83_0<=RULE_EXPONENT)||LA83_0==38||(LA83_0>=67 && LA83_0<=69)) ) {
            alt83=1;
        }
        switch (alt83) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:635:1: (lv_paramList_5_0= ruleParameterList )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:635:1: (lv_paramList_5_0= ruleParameterList )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:636:3: lv_paramList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleParameterList_in_synpred15_InternalVilBuildLanguage1179);
                lv_paramList_5_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,17,FOLLOW_17_in_synpred15_InternalVilBuildLanguage1192); if (state.failed) return ;
        otherlv_7=(Token)match(input,23,FOLLOW_23_in_synpred15_InternalVilBuildLanguage1204); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalVilBuildLanguage

    // $ANTLR start synpred25_InternalVilBuildLanguage
    public final void synpred25_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:4: (otherlv_5= ';' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:4: otherlv_5= ';'
        {
        otherlv_5=(Token)match(input,14,FOLLOW_14_in_synpred25_InternalVilBuildLanguage1972); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalVilBuildLanguage

    // $ANTLR start synpred41_InternalVilBuildLanguage
    public final void synpred41_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:3: ( ( 'else' )=>otherlv_5= 'else' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,31,FOLLOW_31_in_synpred41_InternalVilBuildLanguage3052); if (state.failed) return ;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1600:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1601:1: (lv_else_6_0= ruleStatementOrBlock )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1601:1: (lv_else_6_0= ruleStatementOrBlock )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1602:3: lv_else_6_0= ruleStatementOrBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStatementOrBlock_in_synpred41_InternalVilBuildLanguage3074);
        lv_else_6_0=ruleStatementOrBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred41_InternalVilBuildLanguage

    // $ANTLR start synpred42_InternalVilBuildLanguage
    public final void synpred42_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1639:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1640:1: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1640:1: (lv_exStmt_0_0= ruleExpressionStatement )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1641:3: lv_exStmt_0_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionStatement_in_synpred42_InternalVilBuildLanguage3168);
        lv_exStmt_0_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred42_InternalVilBuildLanguage

    // $ANTLR start synpred52_InternalVilBuildLanguage
    public final void synpred52_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:1: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:1: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:1: (lv_right_1_0= ruleLogicalExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2455:3: lv_right_1_0= ruleLogicalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleLogicalExpressionPart_in_synpred52_InternalVilBuildLanguage4874);
        lv_right_1_0=ruleLogicalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred52_InternalVilBuildLanguage

    // $ANTLR start synpred55_InternalVilBuildLanguage
    public final void synpred55_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:1: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:1: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:1: (lv_right_1_0= ruleEqualityExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2610:3: lv_right_1_0= ruleEqualityExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleEqualityExpressionPart_in_synpred55_InternalVilBuildLanguage5229);
        lv_right_1_0=ruleEqualityExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred55_InternalVilBuildLanguage

    // $ANTLR start synpred58_InternalVilBuildLanguage
    public final void synpred58_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:1: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:1: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:1: (lv_right_1_0= ruleRelationalExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2765:3: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleRelationalExpressionPart_in_synpred58_InternalVilBuildLanguage5584);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred58_InternalVilBuildLanguage

    // $ANTLR start synpred62_InternalVilBuildLanguage
    public final void synpred62_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:1: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2927:3: lv_right_1_0= ruleAdditiveExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_synpred62_InternalVilBuildLanguage5958);
        lv_right_1_0=ruleAdditiveExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred62_InternalVilBuildLanguage

    // $ANTLR start synpred64_InternalVilBuildLanguage
    public final void synpred64_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:1: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3075:3: lv_right_1_0= ruleMultiplicativeExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_synpred64_InternalVilBuildLanguage6294);
        lv_right_1_0=ruleMultiplicativeExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred64_InternalVilBuildLanguage

    // $ANTLR start synpred88_InternalVilBuildLanguage
    public final void synpred88_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4261:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4261:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4262:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred88_InternalVilBuildLanguage8801);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred88_InternalVilBuildLanguage

    // $ANTLR start synpred92_InternalVilBuildLanguage
    public final void synpred92_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4326:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred92_InternalVilBuildLanguage8929); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred92_InternalVilBuildLanguage

    // Delegated rules

    public final boolean synpred88_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred15_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred52_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred42_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String DFA10_eotS =
        "\35\uffff";
    static final String DFA10_eofS =
        "\1\1\34\uffff";
    static final String DFA10_minS =
        "\1\4\3\uffff\7\0\22\uffff";
    static final String DFA10_maxS =
        "\1\105\3\uffff\7\0\22\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\7\uffff\1\2\21\uffff";
    static final String DFA10_specialS =
        "\4\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\13\1\5\1\13\1\4\1\6\7\uffff\1\13\1\uffff\1\13\1\1\4\uffff"+
            "\1\13\1\uffff\2\13\1\uffff\1\13\2\uffff\1\13\2\uffff\1\13\1"+
            "\3\1\uffff\1\7\14\uffff\1\13\2\uffff\3\13\1\uffff\1\13\5\uffff"+
            "\3\13\1\10\1\11\1\12",
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
            return "()* loopback of 509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) )*";
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

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred11_InternalVilBuildLanguage()) ) {s = 11;}

                         
                        input.seek(index10_10);
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
        "\32\uffff";
    static final String DFA14_eofS =
        "\32\uffff";
    static final String DFA14_minS =
        "\1\4\4\0\25\uffff";
    static final String DFA14_maxS =
        "\1\105\4\0\25\uffff";
    static final String DFA14_acceptS =
        "\5\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String DFA14_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\11\1\2\1\11\1\1\1\3\7\uffff\1\11\1\uffff\1\11\5\uffff\1"+
            "\11\1\uffff\1\5\1\11\1\uffff\1\11\2\uffff\1\11\2\uffff\1\11"+
            "\2\uffff\1\4\14\uffff\1\11\2\uffff\3\11\1\uffff\1\11\5\uffff"+
            "\3\11\3\5",
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
            return "576:2: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?";
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
                        if ( (synpred15_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index14_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
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
        "\1\105\1\uffff\4\77\1\uffff\1\46\4\77";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\5\uffff";
    static final String DFA21_specialS =
        "\14\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\6\1\3\1\6\1\2\1\4\7\uffff\1\6\1\uffff\1\6\10\uffff\1\6\1"+
            "\uffff\2\6\1\uffff\1\6\2\uffff\1\6\1\1\1\uffff\1\5\14\uffff"+
            "\1\6\2\uffff\3\6\1\uffff\1\6\5\uffff\3\6\3\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\16\uffff"+
            "\1\1\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\16\uffff"+
            "\1\1\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\16\uffff"+
            "\1\1\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\16\uffff"+
            "\1\1\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "",
            "\1\11\1\uffff\1\10\1\12\35\uffff\1\13",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\25\uffff\1\1\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\25\uffff\1\1\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\25\uffff\1\1\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\25\uffff\1\1\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7"
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
            return "869:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )";
        }
    }
    static final String DFA25_eotS =
        "\22\uffff";
    static final String DFA25_eofS =
        "\2\uffff\4\1\10\uffff\4\1";
    static final String DFA25_minS =
        "\1\4\1\uffff\4\16\6\uffff\1\5\1\uffff\4\16";
    static final String DFA25_maxS =
        "\1\102\1\uffff\4\77\6\uffff\1\46\1\uffff\4\77";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\4\uffff";
    static final String DFA25_specialS =
        "\22\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\12\uffff\1\12\1\uffff\1\10"+
            "\2\uffff\1\11\2\uffff\1\7\2\uffff\1\5\21\uffff\1\6\1\uffff\1"+
            "\13\5\uffff\3\1",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16\1\20\35\uffff\1\21",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\13\uffff\1\1\2\uffff\16\1\3\uffff"+
            "\1\1\1\uffff\3\1\1\uffff\1\14"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1051:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA34_eotS =
        "\27\uffff";
    static final String DFA34_eofS =
        "\27\uffff";
    static final String DFA34_minS =
        "\1\4\23\uffff\1\0\2\uffff";
    static final String DFA34_maxS =
        "\1\102\23\uffff\1\0\2\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\24\uffff\1\2";
    static final String DFA34_specialS =
        "\24\uffff\1\0\2\uffff}>";
    static final String[] DFA34_transitionS = {
            "\5\1\7\uffff\1\1\1\uffff\1\24\10\uffff\1\1\1\uffff\2\1\1\uffff"+
            "\1\1\2\uffff\1\1\2\uffff\1\1\14\uffff\1\1\2\uffff\3\1\1\uffff"+
            "\1\1\5\uffff\3\1",
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
            return "1639:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_20 = input.LA(1);

                         
                        int index34_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index34_20);
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
    static final String DFA67_eotS =
        "\21\uffff";
    static final String DFA67_eofS =
        "\21\uffff";
    static final String DFA67_minS =
        "\1\4\4\5\2\uffff\1\5\1\4\4\5\4\16";
    static final String DFA67_maxS =
        "\1\105\4\77\2\uffff\1\46\1\102\10\77";
    static final String DFA67_acceptS =
        "\5\uffff\1\1\1\2\12\uffff";
    static final String DFA67_specialS =
        "\21\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\6\1\2\1\6\1\1\1\3\7\uffff\3\6\10\uffff\1\6\1\uffff\1\6\2"+
            "\uffff\1\6\2\uffff\1\6\2\uffff\1\4\14\uffff\1\6\2\uffff\3\6"+
            "\1\uffff\1\6\5\uffff\3\6\3\5",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\14\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\14\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\14\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\14\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "",
            "",
            "\1\12\1\uffff\1\11\1\13\35\uffff\1\14",
            "\1\6\1\16\1\6\1\15\1\17\7\uffff\1\6\1\uffff\1\6\10\uffff\1"+
            "\6\1\uffff\1\6\2\uffff\1\6\2\uffff\1\6\2\uffff\1\20\14\uffff"+
            "\1\6\2\uffff\3\6\1\uffff\1\6\5\uffff\3\6",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\14\uffff\1\5\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\14\uffff\1\5\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\14\uffff\1\5\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\14\uffff\1\5\1\uffff"+
            "\16\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\16\uffff\16\6\3"+
            "\uffff\1\6\1\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\16\uffff\16\6\3"+
            "\uffff\1\6\1\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\16\uffff\16\6\3"+
            "\uffff\1\6\1\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\16\uffff\16\6\3"+
            "\uffff\1\6\1\uffff\2\6\1\uffff\1\5\1\6"
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "3895:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleImplementationUnit_in_entryRuleImplementationUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplementationUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleImplementationUnit149 = new BitSet(new long[]{0x000000A00000A002L});
    public static final BitSet FOLLOW_ruleRequire_in_ruleImplementationUnit171 = new BitSet(new long[]{0x000000200000A002L});
    public static final BitSet FOLLOW_ruleLanguageUnit_in_ruleImplementationUnit193 = new BitSet(new long[]{0x0000002000008002L});
    public static final BitSet FOLLOW_ruleRequire_in_entryRuleRequire230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequire240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRequire277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequire294 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleRequire320 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRequire332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit424 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit437 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit458 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit470 = new BitSet(new long[]{0x00000040000201A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit491 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit504 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_ruleLanguageUnit525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit538 = new BitSet(new long[]{0x05C800592D2D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit559 = new BitSet(new long[]{0x05C800592D2D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleLoadProperties_in_ruleLanguageUnit581 = new BitSet(new long[]{0x05C800592D2D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleScriptContents_in_ruleLanguageUnit603 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLanguageUnit615 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_entryRuleScriptParentDecl666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptParentDecl676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleScriptParentDecl713 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleScriptParentDecl734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoadProperties_in_entryRuleLoadProperties770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoadProperties780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLoadProperties817 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLoadProperties829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLoadProperties846 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoadProperties863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptContents_in_entryRuleScriptContents899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptContents909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleScriptContents968 = new BitSet(new long[]{0x05C800592D0501F2L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_ruleScriptContents995 = new BitSet(new long[]{0x05C800592D0501F2L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDeclaration1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleRuleDeclaration1102 = new BitSet(new long[]{0x00000040040001A0L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1124 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1146 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRuleDeclaration1158 = new BitSet(new long[]{0x00000040000201A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleRuleDeclaration1179 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleDeclaration1192 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleRuleDeclaration1204 = new BitSet(new long[]{0x05C800592D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleConditions_in_ruleRuleDeclaration1227 = new BitSet(new long[]{0x05C800592D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1249 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRuleDeclaration1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleConditions_in_entryRuleRuleConditions1300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleConditions1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1368 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleRuleConditions1381 = new BitSet(new long[]{0x05C80049280101F2L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1403 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleRuleConditions1416 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1437 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElementBlock1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRuleElementBlock1536 = new BitSet(new long[]{0x05C80059680D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1557 = new BitSet(new long[]{0x05C80059680D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_19_in_ruleRuleElementBlock1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElement_in_entryRuleRuleElement1606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElement1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleRuleElement1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleModifier1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRuleModifier1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement1825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement1883 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement1895 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement1918 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_ruleExpressionStatement1959 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_rulePrimaryExpression2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_rulePrimaryExpression2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_rulePrimaryExpression2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_entryRuleInstantiate2292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantiate2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleInstantiate2339 = new BitSet(new long[]{0x00000040000001B0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInstantiate2362 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_28_in_ruleInstantiate2375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2392 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2423 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInstantiate2441 = new BitSet(new long[]{0x05C80049280701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleInstantiate2462 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInstantiate2475 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleInstantiate2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapVariable_in_entryRuleMapVariable2533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapVariable2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleMapVariable2589 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleMapVariable2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_entryRuleMap2647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMap2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleMap2694 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMap2706 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2727 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_25_in_ruleMap2740 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2761 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_ruleMap2783 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_24_in_ruleMap2812 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMap2849 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMap2861 = new BitSet(new long[]{0x05C800592D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleMap2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative2918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternative2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAlternative2965 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAlternative2977 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlternative2998 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAlternative3010 = new BitSet(new long[]{0x05C800596D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_ruleAlternative3031 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleAlternative3052 = new BitSet(new long[]{0x05C800596D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_ruleAlternative3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_entryRuleStatementOrBlock3112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatementOrBlock3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleStatementOrBlock3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleStatementOrBlock3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_entryRuleJoin3231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoin3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleJoin3278 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin3290 = new BitSet(new long[]{0x00000044000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin3311 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleJoin3323 = new BitSet(new long[]{0x00000044000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin3344 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin3356 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleJoin3369 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin3381 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoin3402 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoinVariable3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleJoinVariable3505 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJoinVariable3540 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleJoinVariable3552 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoinVariable3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemExecution3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleSystemExecution3656 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSystemExecution3677 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSystemExecution3698 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleVariableDeclaration3788 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3823 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3844 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3857 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3878 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVariableDeclaration3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAdvice3975 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAdvice3987 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice4008 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAdvice4020 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec4078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVersionSpec4125 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList4182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4238 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleParameterList4251 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4272 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4366 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVersionStmt4470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4487 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionStmt4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleImport4587 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4608 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4629 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleImport4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4853 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4874 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4967 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleLogicalOperator5074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleLogicalOperator5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLogicalOperator5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5208 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5322 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleEqualityOperator5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleEqualityOperator5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleEqualityOperator5467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5563 = new BitSet(new long[]{0x0003C00000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5677 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator5784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator5803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator5822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelationalOperator5841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5937 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5958 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6051 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAdditiveOperator6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAdditiveOperator6177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6273 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6387 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleMultiplicativeOperator6494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMultiplicativeOperator6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6609 = new BitSet(new long[]{0x05C80049280101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryOperator6717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator6736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator6755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6942 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionOrQualifiedExecution6961 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6982 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExpressionOrQualifiedExecution6994 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7017 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7110 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7131 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSuperExecution7215 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleSuperExecution7227 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7248 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7269 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConstructorExecution7353 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7374 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstructorExecution7386 = new BitSet(new long[]{0x05C80049280701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7407 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConstructorExecution7420 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7441 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSubCall7534 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_59_in_ruleSubCall7563 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSubCall7620 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7641 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleSubCall7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7746 = new BitSet(new long[]{0x4000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDeclarator7759 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7780 = new BitSet(new long[]{0x4000000000004000L});
    public static final BitSet FOLLOW_62_in_ruleDeclarator7794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration7830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration7840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration7886 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration7908 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleDeclaration7921 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration7942 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall7980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8036 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCall8048 = new BitSet(new long[]{0x05C80049280701F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8069 = new BitSet(new long[]{0x05C80049280701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8091 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCall8104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8196 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleArgumentList8209 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8230 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8325 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedArgument8337 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8452 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleQualifiedPrefix8471 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8505 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8599 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQualifiedName8618 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleConstant8827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConstant8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConstant8896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant8943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue8984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue8994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleIdentifier9203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleType9324 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleType9384 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleType9444 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeParameters9562 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9583 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleTypeParameters9596 = new BitSet(new long[]{0x00000040000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9617 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeParameters9631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer9726 = new BitSet(new long[]{0x05C80049280D01F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9748 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleContainerInitializer9761 = new BitSet(new long[]{0x05C80049280501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9782 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleContainerInitializer9798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression9844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred7_InternalVilBuildLanguage559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred10_InternalVilBuildLanguage968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_synpred11_InternalVilBuildLanguage995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_synpred15_InternalVilBuildLanguage1102 = new BitSet(new long[]{0x00000040040001A0L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_synpred15_InternalVilBuildLanguage1124 = new BitSet(new long[]{0x00000040000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_synpred15_InternalVilBuildLanguage1146 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred15_InternalVilBuildLanguage1158 = new BitSet(new long[]{0x00000040000201A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameterList_in_synpred15_InternalVilBuildLanguage1179 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred15_InternalVilBuildLanguage1192 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_synpred15_InternalVilBuildLanguage1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred25_InternalVilBuildLanguage1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred41_InternalVilBuildLanguage3052 = new BitSet(new long[]{0x05C800596D0501F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_synpred41_InternalVilBuildLanguage3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_synpred42_InternalVilBuildLanguage3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_synpred52_InternalVilBuildLanguage4874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_synpred55_InternalVilBuildLanguage5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_synpred58_InternalVilBuildLanguage5584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_synpred62_InternalVilBuildLanguage5958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_synpred64_InternalVilBuildLanguage6294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred88_InternalVilBuildLanguage8801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred92_InternalVilBuildLanguage8929 = new BitSet(new long[]{0x0000000000000002L});

}