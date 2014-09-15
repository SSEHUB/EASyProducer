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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'defer'", "'requires'", "'instantiate'", "'rule'", "'map'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'@advice'", "'version'", "'=='", "'>'", "'<'", "'>='", "'<='", "'import'", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'"
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

                if ( (LA1_0==44) ) {
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

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||(LA5_0>=67 && LA5_0<=69)) ) {
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
                alt7=1;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:563:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )? ( (lv_postcondition_7_0= ruleLogicalExpression ) )? otherlv_8= ':' ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )? ( (lv_block_12_0= ruleRuleElementBlock ) ) (otherlv_13= ';' )? ) ;
    public final EObject ruleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_modifier_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_paramList_4_0 = null;

        EObject lv_postcondition_7_0 = null;

        EObject lv_preconditions_9_0 = null;

        EObject lv_preconditions_11_0 = null;

        EObject lv_block_12_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:566:28: ( ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )? ( (lv_postcondition_7_0= ruleLogicalExpression ) )? otherlv_8= ':' ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )? ( (lv_block_12_0= ruleRuleElementBlock ) ) (otherlv_13= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )? ( (lv_postcondition_7_0= ruleLogicalExpression ) )? otherlv_8= ':' ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )? ( (lv_block_12_0= ruleRuleElementBlock ) ) (otherlv_13= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )? ( (lv_postcondition_7_0= ruleLogicalExpression ) )? otherlv_8= ':' ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )? ( (lv_block_12_0= ruleRuleElementBlock ) ) (otherlv_13= ';' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:567:2: () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )? ( (lv_postcondition_7_0= ruleLogicalExpression ) )? otherlv_8= ':' ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )? ( (lv_block_12_0= ruleRuleElementBlock ) ) (otherlv_13= ';' )?
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:576:3: ( (lv_modifier_1_0= ruleRuleModifier ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==26) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_modifier_1_0= ruleRuleModifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:577:1: (lv_modifier_1_0= ruleRuleModifier )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:578:3: lv_modifier_1_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1102);
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
                                      		"RuleModifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:594:3: ( (lv_name_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_name_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:1: (lv_name_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:3: lv_name_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1124);
                    lv_name_2_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
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

                    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRuleDeclaration1136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_2());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:616:1: ( (lv_paramList_4_0= ruleParameterList ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_VERSION||(LA12_0>=RULE_ID && LA12_0<=RULE_EXPONENT)||(LA12_0>=67 && LA12_0<=69)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:617:1: (lv_paramList_4_0= ruleParameterList )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:617:1: (lv_paramList_4_0= ruleParameterList )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:618:3: lv_paramList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_3_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParameterList_in_ruleRuleDeclaration1157);
                            lv_paramList_4_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"paramList",
                                      		lv_paramList_4_0, 
                                      		"ParameterList");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleRuleDeclaration1170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_4());
                          
                    }
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleRuleDeclaration1182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_5());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:642:3: ( (lv_postcondition_7_0= ruleLogicalExpression ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_EXPONENT)||LA14_0==16||LA14_0==29||(LA14_0>=31 && LA14_0<=32)||LA14_0==35||LA14_0==51||(LA14_0>=54 && LA14_0<=56)||LA14_0==58||(LA14_0>=64 && LA14_0<=66)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:643:1: (lv_postcondition_7_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:643:1: (lv_postcondition_7_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:644:3: lv_postcondition_7_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getPostconditionLogicalExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1205);
                    lv_postcondition_7_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      	        }
                             		add(
                             			current, 
                             			"postcondition",
                              		lv_postcondition_7_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleRuleDeclaration1218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRuleDeclarationAccess().getColonKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:664:1: ( ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_EXPONENT)||LA16_0==16||LA16_0==29||(LA16_0>=31 && LA16_0<=32)||LA16_0==35||LA16_0==51||(LA16_0>=54 && LA16_0<=56)||LA16_0==58||(LA16_0>=64 && LA16_0<=66)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:664:2: ( (lv_preconditions_9_0= ruleLogicalExpression ) ) (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:664:2: ( (lv_preconditions_9_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:665:1: (lv_preconditions_9_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:665:1: (lv_preconditions_9_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:666:3: lv_preconditions_9_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getPreconditionsLogicalExpressionParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1240);
                    lv_preconditions_9_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      	        }
                             		add(
                             			current, 
                             			"preconditions",
                              		lv_preconditions_9_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:682:2: (otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==25) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:682:4: otherlv_10= ',' ( (lv_preconditions_11_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleRuleDeclaration1253); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getRuleDeclarationAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:686:1: ( (lv_preconditions_11_0= ruleLogicalExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:687:1: (lv_preconditions_11_0= ruleLogicalExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:687:1: (lv_preconditions_11_0= ruleLogicalExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:688:3: lv_preconditions_11_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getPreconditionsLogicalExpressionParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1274);
                    	    lv_preconditions_11_0=ruleLogicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"preconditions",
                    	              		lv_preconditions_11_0, 
                    	              		"LogicalExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:704:6: ( (lv_block_12_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:705:1: (lv_block_12_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:705:1: (lv_block_12_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:706:3: lv_block_12_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1299);
            lv_block_12_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_12_0, 
                      		"RuleElementBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:722:2: (otherlv_13= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:722:4: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleRuleDeclaration1312); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getRuleDeclarationAccess().getSemicolonKeyword_6());
                          
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


    // $ANTLR start "entryRuleRuleElementBlock"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:734:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:735:2: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:736:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementBlockRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1350);
            iv_ruleRuleElementBlock=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElementBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElementBlock1360); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:743:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:746:28: ( ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:747:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:747:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:747:2: () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:747:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:748:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRuleElementBlock1409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:760:1: ( (lv_elements_2_0= ruleRuleElement ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_EXPONENT)||LA18_0==16||LA18_0==18||LA18_0==27||LA18_0==29||(LA18_0>=31 && LA18_0<=32)||(LA18_0>=35 && LA18_0<=36)||LA18_0==51||(LA18_0>=54 && LA18_0<=56)||LA18_0==58||(LA18_0>=64 && LA18_0<=69)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:761:1: (lv_elements_2_0= ruleRuleElement )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:761:1: (lv_elements_2_0= ruleRuleElement )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:762:3: lv_elements_2_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1430);
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
            	    break loop18;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleRuleElementBlock1443); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:790:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:791:2: (iv_ruleRuleElement= ruleRuleElement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:792:2: iv_ruleRuleElement= ruleRuleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElement_in_entryRuleRuleElement1479);
            iv_ruleRuleElement=ruleRuleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElement1489); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:799:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_deferDecl_2_0= ruleDeferDeclaration ) ) ) ;
    public final EObject ruleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;

        EObject lv_deferDecl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:802:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_deferDecl_2_0= ruleDeferDeclaration ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:803:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_deferDecl_2_0= ruleDeferDeclaration ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:803:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_deferDecl_2_0= ruleDeferDeclaration ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:803:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:803:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:804:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:804:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:805:3: lv_varDecl_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1535);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:822:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:822:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:823:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:823:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:824:3: lv_exprStmt_1_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleRuleElement1562);
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
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:841:6: ( (lv_deferDecl_2_0= ruleDeferDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:841:6: ( (lv_deferDecl_2_0= ruleDeferDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:842:1: (lv_deferDecl_2_0= ruleDeferDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:842:1: (lv_deferDecl_2_0= ruleDeferDeclaration )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:843:3: lv_deferDecl_2_0= ruleDeferDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getDeferDeclDeferDeclarationParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeferDeclaration_in_ruleRuleElement1589);
                    lv_deferDecl_2_0=ruleDeferDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      	        }
                             		set(
                             			current, 
                             			"deferDecl",
                              		lv_deferDecl_2_0, 
                              		"DeferDeclaration");
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:867:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:868:2: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:869:2: iv_ruleRuleModifier= ruleRuleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleModifierRule()); 
            }
            pushFollow(FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1625);
            iv_ruleRuleModifier=ruleRuleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleModifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleModifier1635); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:876:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:879:28: ( ( (lv_protected_0_0= 'protected' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:880:1: ( (lv_protected_0_0= 'protected' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:880:1: ( (lv_protected_0_0= 'protected' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:881:1: (lv_protected_0_0= 'protected' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:881:1: (lv_protected_0_0= 'protected' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:882:3: lv_protected_0_0= 'protected'
            {
            lv_protected_0_0=(Token)match(input,26,FOLLOW_26_in_ruleRuleModifier1677); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDeferDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:903:1: entryRuleDeferDeclaration returns [EObject current=null] : iv_ruleDeferDeclaration= ruleDeferDeclaration EOF ;
    public final EObject entryRuleDeferDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeferDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:904:2: (iv_ruleDeferDeclaration= ruleDeferDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:905:2: iv_ruleDeferDeclaration= ruleDeferDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeferDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeferDeclaration_in_entryRuleDeferDeclaration1725);
            iv_ruleDeferDeclaration=ruleDeferDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeferDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeferDeclaration1735); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeferDeclaration"


    // $ANTLR start "ruleDeferDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:912:1: ruleDeferDeclaration returns [EObject current=null] : (otherlv_0= 'defer' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )? otherlv_6= ';' ) ;
    public final EObject ruleDeferDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_depends_3_0 = null;

        AntlrDatatypeRuleToken lv_depends_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:915:28: ( (otherlv_0= 'defer' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )? otherlv_6= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:916:1: (otherlv_0= 'defer' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )? otherlv_6= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:916:1: (otherlv_0= 'defer' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )? otherlv_6= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:916:3: otherlv_0= 'defer' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleDeferDeclaration1772); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeferDeclarationAccess().getDeferKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:920:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:921:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:921:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:922:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeferDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1793);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeferDeclarationRule());
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:938:2: (otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:938:4: otherlv_2= 'requires' ( (lv_depends_3_0= ruleIdentifier ) ) (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )*
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleDeferDeclaration1806); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDeferDeclarationAccess().getRequiresKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:942:1: ( (lv_depends_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:943:1: (lv_depends_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:943:1: (lv_depends_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:944:3: lv_depends_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeferDeclarationAccess().getDependsIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1827);
                    lv_depends_3_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeferDeclarationRule());
                      	        }
                             		add(
                             			current, 
                             			"depends",
                              		lv_depends_3_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:960:2: (otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==25) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:960:4: otherlv_4= ',' ( (lv_depends_5_0= ruleIdentifier ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleDeferDeclaration1840); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDeferDeclarationAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:964:1: ( (lv_depends_5_0= ruleIdentifier ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:965:1: (lv_depends_5_0= ruleIdentifier )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:965:1: (lv_depends_5_0= ruleIdentifier )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:966:3: lv_depends_5_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeferDeclarationAccess().getDependsIdentifierParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1861);
                    	    lv_depends_5_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeferDeclarationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"depends",
                    	              		lv_depends_5_0, 
                    	              		"Identifier");
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleDeferDeclaration1877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getDeferDeclarationAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeferDeclaration"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:994:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:995:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:996:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1913);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1923); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1003:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1006:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1007:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1007:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1007:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1007:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1008:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1009:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression1969);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1027:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1027:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1028:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression1996);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1045:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1045:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1046:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1046:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1047:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2023);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1064:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1064:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1065:1: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1065:1: (lv_sysEx_3_0= ruleSystemExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1066:3: lv_sysEx_3_0= ruleSystemExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSysExSystemExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2050);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1083:6: ( (lv_map_4_0= ruleMap ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1083:6: ( (lv_map_4_0= ruleMap ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1084:1: (lv_map_4_0= ruleMap )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1084:1: (lv_map_4_0= ruleMap )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1085:3: lv_map_4_0= ruleMap
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMapMapParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMap_in_rulePrimaryExpression2077);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1102:6: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1102:6: ( (lv_join_5_0= ruleJoin ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1103:1: (lv_join_5_0= ruleJoin )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1103:1: (lv_join_5_0= ruleJoin )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1104:3: lv_join_5_0= ruleJoin
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getJoinJoinParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJoin_in_rulePrimaryExpression2104);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1121:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1121:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1122:1: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1122:1: (lv_instantiate_6_0= ruleInstantiate )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1123:3: lv_instantiate_6_0= ruleInstantiate
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInstantiateInstantiateParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInstantiate_in_rulePrimaryExpression2131);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1140:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1140:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1141:1: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1141:1: (lv_newEx_7_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1142:3: lv_newEx_7_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2158);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1166:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1167:2: (iv_ruleInstantiate= ruleInstantiate EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1168:2: iv_ruleInstantiate= ruleInstantiate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstantiateRule()); 
            }
            pushFollow(FOLLOW_ruleInstantiate_in_entryRuleInstantiate2194);
            iv_ruleInstantiate=ruleInstantiate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstantiate; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantiate2204); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1175:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1178:28: ( (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1179:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1179:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1179:3: otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleInstantiate2241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1183:1: ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_VERSION||(LA24_0>=RULE_ID && LA24_0<=RULE_EXPONENT)) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_STRING) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1183:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1183:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1183:3: ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1183:3: ( (lv_project_1_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1184:1: (lv_project_1_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1184:1: (lv_project_1_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1185:3: lv_project_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getProjectIdentifierParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleInstantiate2264);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1201:2: (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==30) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1201:4: otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleInstantiate2277); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getInstantiateAccess().getRuleKeyword_1_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1205:1: ( (lv_rule_3_0= RULE_STRING ) )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1206:1: (lv_rule_3_0= RULE_STRING )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1206:1: (lv_rule_3_0= RULE_STRING )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1207:3: lv_rule_3_0= RULE_STRING
                            {
                            lv_rule_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2294); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1224:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1224:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1225:1: (lv_ruleName_4_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1225:1: (lv_ruleName_4_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1226:3: lv_ruleName_4_0= RULE_STRING
                    {
                    lv_ruleName_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2325); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleInstantiate2343); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1246:1: ( (lv_param_6_0= ruleArgumentList ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_EXPONENT)||LA25_0==16||LA25_0==18||LA25_0==29||(LA25_0>=31 && LA25_0<=32)||LA25_0==35||LA25_0==51||(LA25_0>=54 && LA25_0<=56)||LA25_0==58||(LA25_0>=64 && LA25_0<=66)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1247:1: (lv_param_6_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1247:1: (lv_param_6_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1248:3: lv_param_6_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleInstantiate2364);
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

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleInstantiate2377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:1: ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1270:3: lv_versionSpec_8_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getVersionSpecVersionSpecParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleInstantiate2398);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1294:1: entryRuleMapVariable returns [EObject current=null] : iv_ruleMapVariable= ruleMapVariable EOF ;
    public final EObject entryRuleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1295:2: (iv_ruleMapVariable= ruleMapVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1296:2: iv_ruleMapVariable= ruleMapVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapVariableRule()); 
            }
            pushFollow(FOLLOW_ruleMapVariable_in_entryRuleMapVariable2435);
            iv_ruleMapVariable=ruleMapVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapVariable2445); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1303:1: ruleMapVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1306:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:2: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:2: ( (lv_type_0_0= ruleType ) )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==RULE_VERSION||(LA27_1>=RULE_ID && LA27_1<=RULE_EXPONENT)||LA27_1==63) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==RULE_VERSION||(LA27_2>=RULE_ID && LA27_2<=RULE_EXPONENT)||LA27_2==63) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (LA27_3==RULE_VERSION||(LA27_3>=RULE_ID && LA27_3<=RULE_EXPONENT)||LA27_3==63) ) {
                        alt27=1;
                    }
                    }
                    break;
                case 67:
                case 68:
                case 69:
                    {
                    alt27=1;
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1308:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1308:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1309:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapVariableAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleMapVariable2491);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1325:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1326:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1326:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1327:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleMapVariable2513);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1351:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1352:2: (iv_ruleMap= ruleMap EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1353:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_ruleMap_in_entryRuleMap2549);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMap2559); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1360:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1363:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1364:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1364:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1364:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleMap2596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleMap2608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1372:1: ( (lv_var_2_0= ruleMapVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1373:1: (lv_var_2_0= ruleMapVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1373:1: (lv_var_2_0= ruleMapVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1374:3: lv_var_2_0= ruleMapVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2629);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1390:2: (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==25) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1390:4: otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleMap2642); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1394:1: ( (lv_var_4_0= ruleMapVariable ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1395:1: (lv_var_4_0= ruleMapVariable )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1395:1: (lv_var_4_0= ruleMapVariable )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1396:3: lv_var_4_0= ruleMapVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2663);
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
            	    break loop28;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1412:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1413:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1413:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1414:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1414:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==23) ) {
                alt29=1;
            }
            else if ( (LA29_0==24) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1415:3: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_23_in_ruleMap2685); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1427:8: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_24_in_ruleMap2714); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1442:2: ( (lv_expr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1443:1: (lv_expr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1443:1: (lv_expr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1444:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMap2751);
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

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMap2763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1464:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1465:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1465:1: (lv_block_8_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1466:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleMap2784);
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


    // $ANTLR start "entryRuleJoin"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1490:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1491:2: (iv_ruleJoin= ruleJoin EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1492:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_ruleJoin_in_entryRuleJoin2820);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoin2830); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1499:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1502:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1503:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1503:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1503:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleJoin2867); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJoin2879); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1511:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1512:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1512:1: (lv_var1_2_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1513:3: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin2900);
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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleJoin2912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1533:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1534:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1534:1: (lv_var2_4_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1535:3: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin2933);
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

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJoin2945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1555:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==33) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1555:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleJoin2958); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleJoin2970); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1563:1: ( (lv_condition_8_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1564:1: (lv_condition_8_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1564:1: (lv_condition_8_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1565:3: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleJoin2991);
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

                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleJoin3003); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1593:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1594:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:2: iv_ruleJoinVariable= ruleJoinVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinVariableRule()); 
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3041);
            iv_ruleJoinVariable=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoinVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoinVariable3051); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1602:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1605:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1606:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1606:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1606:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1606:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1607:1: (lv_excl_0_0= 'exclude' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1607:1: (lv_excl_0_0= 'exclude' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1608:3: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,34,FOLLOW_34_in_ruleJoinVariable3094); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1621:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1622:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1622:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1623:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJoinVariable3129);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleJoinVariable3141); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1643:1: ( (lv_expr_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1644:1: (lv_expr_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1644:1: (lv_expr_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1645:3: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getExprExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleJoinVariable3162);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1669:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1670:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1671:2: iv_ruleSystemExecution= ruleSystemExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3198);
            iv_ruleSystemExecution=ruleSystemExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemExecution3208); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1678:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1681:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1682:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1682:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1682:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleSystemExecution3245); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1686:1: ( (lv_call_1_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1687:1: (lv_call_1_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1687:1: (lv_call_1_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1688:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSystemExecution3266);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1704:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==57||(LA32_0>=59 && LA32_0<=60)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1705:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1705:1: (lv_calls_2_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1706:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSystemExecution3287);
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1730:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1731:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1732:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3324);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3334); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1739:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1742:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1743:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1743:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1743:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1743:2: ( (lv_const_0_0= 'const' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==36) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1744:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1744:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1745:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,36,FOLLOW_36_in_ruleVariableDeclaration3377); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1759:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1759:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1760:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3412);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1776:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1777:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1777:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1778:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3433);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1794:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1794:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1798:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1799:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1799:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3467);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVariableDeclaration3481); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1828:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1829:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1830:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3517);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3527); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1837:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1840:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleAdvice3564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAdvice3576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1849:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1850:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1850:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1851:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice3597);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAdvice3609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1871:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1872:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1872:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1873:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice3630);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1897:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1898:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1899:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3667);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec3677); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1906:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1909:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1910:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1910:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1910:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleVersionSpec3714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleVersionSpec3726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1918:1: ( (lv_conflicts_2_0= ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1919:1: (lv_conflicts_2_0= ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1919:1: (lv_conflicts_2_0= ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1920:3: lv_conflicts_2_0= ruleVersionedId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3747);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1936:2: (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1936:4: otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleVersionSpec3760); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1940:1: ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1941:1: (lv_conflicts_4_0= ruleVersionedId )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1941:1: (lv_conflicts_4_0= ruleVersionedId )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1942:3: lv_conflicts_4_0= ruleVersionedId
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3781);
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
            	    break loop36;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleVersionSpec3795); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1970:1: entryRuleVersionedId returns [EObject current=null] : iv_ruleVersionedId= ruleVersionedId EOF ;
    public final EObject entryRuleVersionedId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionedId = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1971:2: (iv_ruleVersionedId= ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1972:2: iv_ruleVersionedId= ruleVersionedId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionedIdRule()); 
            }
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId3831);
            iv_ruleVersionedId=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionedId; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId3841); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1979:1: ruleVersionedId returns [EObject current=null] : (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) ;
    public final EObject ruleVersionedId() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_2_0=null;
        AntlrDatatypeRuleToken lv_op_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1982:28: ( (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1983:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1983:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1983:3: otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleVersionedId3878); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionedIdAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1987:1: ( (lv_op_1_0= ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1988:1: (lv_op_1_0= ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1988:1: (lv_op_1_0= ruleVersionOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1989:3: lv_op_1_0= ruleVersionOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_ruleVersionedId3899);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2005:2: ( (lv_version_2_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2006:1: (lv_version_2_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2006:1: (lv_version_2_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2007:3: lv_version_2_0= RULE_VERSION
            {
            lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionedId3916); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2031:1: entryRuleVersionOperator returns [String current=null] : iv_ruleVersionOperator= ruleVersionOperator EOF ;
    public final String entryRuleVersionOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2032:2: (iv_ruleVersionOperator= ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2033:2: iv_ruleVersionOperator= ruleVersionOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3958);
            iv_ruleVersionOperator=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator3969); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2040:1: ruleVersionOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleVersionOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2043:28: ( (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2044:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2044:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt37=5;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt37=1;
                }
                break;
            case 40:
                {
                alt37=2;
                }
                break;
            case 41:
                {
                alt37=3;
                }
                break;
            case 42:
                {
                alt37=4;
                }
                break;
            case 43:
                {
                alt37=5;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2045:2: kw= '=='
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleVersionOperator4007); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2052:2: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleVersionOperator4026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2059:2: kw= '<'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleVersionOperator4045); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2066:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleVersionOperator4064); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2073:2: kw= '<='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleVersionOperator4083); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2086:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2087:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2088:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList4123);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList4133); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2095:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2098:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2100:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2100:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2101:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4179);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2117:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==25) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2117:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleParameterList4192); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2121:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2122:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2122:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2123:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4213);
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2147:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2148:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2149:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4251);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4261); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2156:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2159:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2160:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2160:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2160:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2160:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2161:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2161:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2162:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4307);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2178:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2179:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2179:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2180:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4328);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2204:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2205:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2206:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4364);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4374); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2213:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2216:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2217:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2217:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2217:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleVersionStmt4411); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2221:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2222:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2222:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2223:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4428); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleVersionStmt4445); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2251:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2252:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4481);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4491); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2260:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2263:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2264:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2264:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2264:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleImport4528); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2268:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2269:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2269:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2270:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4549);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2286:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==33) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2287:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2287:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2288:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4570);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImport4583); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2316:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2317:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2318:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4619);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement4629); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2325:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2328:28: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt40=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==23) ) {
                        alt40=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (LA40_2==23) ) {
                        alt40=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (LA40_3==23) ) {
                        alt40=1;
                    }
                    }
                    break;
            }

            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:3: ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2329:3: ( (lv_var_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2330:1: (lv_var_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2330:1: (lv_var_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2331:3: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4676);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement4688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2351:3: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2352:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2352:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2353:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement4711);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement4723); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2381:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2382:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2383:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4759);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4769); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2390:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2393:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2394:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2394:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_EXPONENT)||LA41_0==16||LA41_0==29||(LA41_0>=31 && LA41_0<=32)||LA41_0==35||LA41_0==51||(LA41_0>=54 && LA41_0<=56)||LA41_0==58||(LA41_0>=64 && LA41_0<=66)) ) {
                alt41=1;
            }
            else if ( (LA41_0==18) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2394:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2394:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2395:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2395:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2396:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4815);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2413:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2413:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2414:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2414:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2415:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4842);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2439:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2440:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2441:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4878);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4888); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2448:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2451:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2452:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2452:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2452:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2452:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2453:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2453:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2454:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4934);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2470:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=45 && LA42_0<=47)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2471:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2471:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2472:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4955);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2496:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2497:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2498:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4992);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart5002); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2505:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2508:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2509:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2509:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2509:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2509:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2510:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2510:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2511:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart5048);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2527:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2528:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2528:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2529:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart5069);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2553:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2554:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2555:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5106);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator5117); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2562:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2565:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2566:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2566:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt43=1;
                }
                break;
            case 46:
                {
                alt43=2;
                }
                break;
            case 47:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2567:2: kw= 'and'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleLogicalOperator5155); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2574:2: kw= 'or'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleLogicalOperator5174); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2581:2: kw= 'xor'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleLogicalOperator5193); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2594:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2595:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2596:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5233);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5243); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2603:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2606:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2607:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2607:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2607:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2607:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2608:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2608:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2609:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5289);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2625:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==39||(LA44_0>=48 && LA44_0<=49)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2626:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2626:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2627:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5310);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2651:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2652:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2653:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5347);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5357); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2660:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2663:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2664:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2664:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2664:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2664:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2665:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2665:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2666:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5403);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2682:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2683:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2683:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2684:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5424);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2708:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2709:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2710:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5461);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5472); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2717:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2720:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2721:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2721:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt45=1;
                }
                break;
            case 48:
                {
                alt45=2;
                }
                break;
            case 49:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2722:2: kw= '=='
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleEqualityOperator5510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2729:2: kw= '<>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleEqualityOperator5529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2736:2: kw= '!='
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleEqualityOperator5548); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2749:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2750:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2751:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5588);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5598); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2758:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2761:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2762:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2762:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2762:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2762:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2763:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2763:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2764:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5644);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2780:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=40 && LA46_0<=43)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2781:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2781:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2782:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5665);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2806:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2807:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2808:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5702);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5712); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2815:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2818:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2819:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2819:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2819:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2819:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2820:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2820:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2821:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5758);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2837:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2838:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2838:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2839:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5779);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2863:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2864:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2865:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5816);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5827); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2872:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2875:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2876:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2876:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt47=1;
                }
                break;
            case 41:
                {
                alt47=2;
                }
                break;
            case 42:
                {
                alt47=3;
                }
                break;
            case 43:
                {
                alt47=4;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2877:2: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleRelationalOperator5865); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2884:2: kw= '<'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleRelationalOperator5884); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2891:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleRelationalOperator5903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2898:2: kw= '<='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleRelationalOperator5922); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2911:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2912:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2913:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5962);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5972); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2920:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2923:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2924:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2924:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2924:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2924:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2925:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2925:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6018);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2942:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=50 && LA48_0<=51)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2943:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2943:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2944:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6039);
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
            	    break loop48;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2968:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2969:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2970:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6076);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6086); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2977:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2980:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2981:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2981:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2981:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2981:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2982:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2982:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2983:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6132);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2999:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3000:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3000:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3001:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6153);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3025:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3026:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3027:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6190);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6201); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3034:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3037:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3038:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3038:1: (kw= '+' | kw= '-' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==50) ) {
                alt49=1;
            }
            else if ( (LA49_0==51) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3039:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleAdditiveOperator6239); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3046:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleAdditiveOperator6258); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3059:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3060:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3061:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6298);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6308); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3068:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3071:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3072:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3072:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3072:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3072:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3073:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3073:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3074:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6354);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3090:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=52 && LA50_0<=53)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3091:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3091:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3092:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6375);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3116:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3117:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3118:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6412);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6422); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3125:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3128:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3129:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3129:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3129:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3129:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3130:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3130:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3131:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6468);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3147:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3148:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3148:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3149:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6489);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3173:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3174:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3175:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6526);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6537); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3182:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3185:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3186:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3186:1: (kw= '*' | kw= '/' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            else if ( (LA51_0==53) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3187:2: kw= '*'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleMultiplicativeOperator6575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3194:2: kw= '/'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleMultiplicativeOperator6594); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3207:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3208:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3209:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6634);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6644); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3216:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3219:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3220:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3220:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3220:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3220:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==51||(LA52_0>=54 && LA52_0<=55)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3221:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3221:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3222:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6690);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3238:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3239:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3239:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3240:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6712);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3264:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3265:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3266:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6749);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6760); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3273:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3276:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3277:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3277:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt53=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt53=1;
                }
                break;
            case 55:
                {
                alt53=2;
                }
                break;
            case 51:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3278:2: kw= 'not'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleUnaryOperator6798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3285:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleUnaryOperator6817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3292:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleUnaryOperator6836); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3305:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3306:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3307:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6876);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6886); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3314:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3317:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3318:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3318:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3319:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3319:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3320:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6931);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3344:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3345:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3346:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6966);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6976); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3353:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3356:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_STRING && LA54_0<=RULE_EXPONENT)||(LA54_0>=64 && LA54_0<=66)) ) {
                alt54=1;
            }
            else if ( (LA54_0==16) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7023);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3376:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3376:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3376:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionOrQualifiedExecution7042); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3380:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3381:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3381:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3382:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7063);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleExpressionOrQualifiedExecution7075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3402:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==57||(LA55_0>=59 && LA55_0<=60)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3403:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3403:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3404:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7098);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3428:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3429:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3430:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7135);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7145); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3437:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3440:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3441:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3441:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3441:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3441:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3443:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7191);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3459:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57||(LA56_0>=59 && LA56_0<=60)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3460:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3460:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3461:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7212);
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
            	    break loop56;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3485:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3486:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3487:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7249);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7259); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3494:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3497:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3498:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3498:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3498:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleSuperExecution7296); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleSuperExecution7308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3506:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3507:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3507:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3508:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7329);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3524:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==57||(LA57_0>=59 && LA57_0<=60)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3525:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3525:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3526:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7350);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3550:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3551:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3552:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7387);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7397); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3559:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3562:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3563:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3563:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3563:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleConstructorExecution7434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3568:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3568:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3569:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7455);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConstructorExecution7467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3589:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_EXPONENT)||LA58_0==16||LA58_0==18||LA58_0==29||(LA58_0>=31 && LA58_0<=32)||LA58_0==35||LA58_0==51||(LA58_0>=54 && LA58_0<=56)||LA58_0==58||(LA58_0>=64 && LA58_0<=66)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3590:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3590:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3591:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7488);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleConstructorExecution7501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3611:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==57||(LA59_0>=59 && LA59_0<=60)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3612:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3612:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3613:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7522);
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
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3637:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3638:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3639:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7559);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7569); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3646:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3649:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==57||LA61_0==59) ) {
                alt61=1;
            }
            else if ( (LA61_0==60) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3650:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3651:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3651:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3652:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3652:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==57) ) {
                        alt60=1;
                    }
                    else if ( (LA60_0==59) ) {
                        alt60=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3653:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,57,FOLLOW_57_in_ruleSubCall7615); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3665:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,59,FOLLOW_59_in_ruleSubCall7644); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3680:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3681:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3681:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3682:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7681);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3699:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3699:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3699:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleSubCall7701); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3703:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3704:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3704:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3705:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7722);
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

                    otherlv_4=(Token)match(input,61,FOLLOW_61_in_ruleSubCall7734); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3733:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3734:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3735:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7771);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7781); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3742:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3745:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3746:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3746:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3746:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3746:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3747:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3747:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3748:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7827);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3764:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==14) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3764:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleDeclarator7840); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3768:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3769:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3769:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3770:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7861);
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
            	    break loop62;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleDeclarator7875); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3798:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3799:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3800:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration7911);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration7921); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3807:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3810:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3811:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3811:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3811:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3811:2: ( (lv_type_0_0= ruleType ) )?
            int alt63=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA63_1 = input.LA(2);

                    if ( (LA63_1==RULE_VERSION||(LA63_1>=RULE_ID && LA63_1<=RULE_EXPONENT)||LA63_1==63) ) {
                        alt63=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==RULE_VERSION||(LA63_2>=RULE_ID && LA63_2<=RULE_EXPONENT)||LA63_2==63) ) {
                        alt63=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA63_3 = input.LA(2);

                    if ( (LA63_3==RULE_VERSION||(LA63_3>=RULE_ID && LA63_3<=RULE_EXPONENT)||LA63_3==63) ) {
                        alt63=1;
                    }
                    }
                    break;
                case 67:
                case 68:
                case 69:
                    {
                    alt63=1;
                    }
                    break;
            }

            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3812:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3812:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3813:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration7967);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3829:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3830:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3830:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3831:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration7989);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3847:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==25) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3847:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleDeclaration8002); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3851:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3852:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3852:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3853:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration8023);
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3877:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3878:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3879:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall8061);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall8071); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3886:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3889:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3890:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3890:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3890:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3890:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3891:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3891:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3892:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8117);
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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleCall8129); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3912:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3913:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3913:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8150);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3930:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_EXPONENT)||LA66_0==16||LA66_0==18||LA66_0==29||(LA66_0>=31 && LA66_0<=32)||LA66_0==35||LA66_0==51||(LA66_0>=54 && LA66_0<=56)||LA66_0==58||(LA66_0>=64 && LA66_0<=66)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3931:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3931:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3932:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8172);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleCall8185); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3960:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3961:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3962:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8221);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8231); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3969:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3972:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3973:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3973:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3973:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3973:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3974:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3974:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3975:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8277);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3991:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==25) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3991:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleArgumentList8290); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3995:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3996:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3996:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3997:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8311);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4021:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4022:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4023:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8349);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8359); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4030:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4033:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt68=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA68_1 = input.LA(2);

                    if ( (LA68_1==23) ) {
                        alt68=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA68_2 = input.LA(2);

                    if ( (LA68_2==23) ) {
                        alt68=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA68_3 = input.LA(2);

                    if ( (LA68_3==23) ) {
                        alt68=1;
                    }
                    }
                    break;
            }

            switch (alt68) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4034:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4035:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4035:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4036:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8406);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNamedArgument8418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4056:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4057:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4057:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4058:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8441);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4082:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4083:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4084:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8477);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8487); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4091:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4094:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4095:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4095:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4095:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4095:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4096:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4096:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4097:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8533);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4113:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==63) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4113:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4113:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4114:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4114:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4115:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,63,FOLLOW_63_in_ruleQualifiedPrefix8552); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4128:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4129:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4129:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4130:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8586);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4154:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4155:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4156:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8624);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8634); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4163:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4166:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4167:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4167:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4167:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4167:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4168:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4168:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4169:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8680);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==57) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA70_3 = input.LA(3);

                        if ( (LA70_3==EOF||LA70_3==14||(LA70_3>=17 && LA70_3<=19)||(LA70_3>=24 && LA70_3<=25)||(LA70_3>=39 && LA70_3<=43)||(LA70_3>=45 && LA70_3<=53)||LA70_3==57||(LA70_3>=59 && LA70_3<=61)) ) {
                            alt70=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA70_4 = input.LA(3);

                        if ( (LA70_4==EOF||LA70_4==14||(LA70_4>=17 && LA70_4<=19)||(LA70_4>=24 && LA70_4<=25)||(LA70_4>=39 && LA70_4<=43)||(LA70_4>=45 && LA70_4<=53)||LA70_4==57||(LA70_4>=59 && LA70_4<=61)) ) {
                            alt70=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA70_5 = input.LA(3);

                        if ( (LA70_5==EOF||LA70_5==14||(LA70_5>=17 && LA70_5<=19)||(LA70_5>=24 && LA70_5<=25)||(LA70_5>=39 && LA70_5<=43)||(LA70_5>=45 && LA70_5<=53)||LA70_5==57||(LA70_5>=59 && LA70_5<=61)) ) {
                            alt70=1;
                        }
                        }
                        break;
                }

            }
            switch (alt70) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4186:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4186:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4187:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,57,FOLLOW_57_in_ruleQualifiedName8699); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4200:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4201:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4201:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4202:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8733);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4226:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4227:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4228:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8771);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8781); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4235:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4238:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4239:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4239:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            int alt72=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt72=1;
                }
                break;
            case RULE_STRING:
                {
                alt72=2;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt72=3;
                }
                break;
            case 64:
            case 65:
                {
                alt72=4;
                }
                break;
            case 66:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4239:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4239:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4240:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4240:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4241:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8827);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4258:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4258:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4259:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4259:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4260:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8850); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4277:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4277:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4278:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4278:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4279:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8882);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4296:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4296:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4297:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4297:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4298:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4298:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==64) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==65) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4299:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,64,FOLLOW_64_in_ruleConstant8908); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4311:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,65,FOLLOW_65_in_ruleConstant8937); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4329:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,66,FOLLOW_66_in_ruleConstant8977); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4350:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4351:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4352:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue9026);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue9036); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4359:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4362:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4363:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4363:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4364:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4364:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4365:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9077); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4389:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4390:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4391:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9118);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9129); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4398:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4401:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4402:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4402:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            int alt73=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt73=1;
                }
                break;
            case RULE_VERSION:
                {
                alt73=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt73=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4402:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9169); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4410:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9195); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4418:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9221); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4433:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4434:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4435:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9266);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9276); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4442:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4445:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4446:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4446:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt74=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt74=1;
                }
                break;
            case 67:
                {
                alt74=2;
                }
                break;
            case 68:
                {
                alt74=3;
                }
                break;
            case 69:
                {
                alt74=4;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4446:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4446:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4448:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9322);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4465:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4465:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4465:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4465:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4466:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4466:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4467:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,67,FOLLOW_67_in_ruleType9347); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4480:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4481:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4481:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4482:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9381);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4499:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4499:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4499:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4499:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4500:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4500:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4501:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,68,FOLLOW_68_in_ruleType9407); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4514:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4516:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9441);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4533:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4533:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4533:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4533:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4534:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4534:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4535:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,69,FOLLOW_69_in_ruleType9467); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4548:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4549:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4549:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4550:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9501);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4574:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4575:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4576:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9538);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9548); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4583:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_param_1_0 = null;

        AntlrDatatypeRuleToken lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4586:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4587:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4587:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4587:3: otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTypeParameters9585); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4591:1: ( (lv_param_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4592:1: (lv_param_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4592:1: (lv_param_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4593:3: lv_param_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9606);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4609:2: (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==25) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4609:4: otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleTypeParameters9619); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4613:1: ( (lv_param_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4614:1: (lv_param_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4614:1: (lv_param_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4615:3: lv_param_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9640);
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
            	    break loop75;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTypeParameters9654); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4643:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4644:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4645:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9690);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9700); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4652:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4655:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4656:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4656:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4656:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4656:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4657:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer9749); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_STRING && LA77_0<=RULE_EXPONENT)||LA77_0==16||LA77_0==18||LA77_0==29||(LA77_0>=31 && LA77_0<=32)||LA77_0==35||LA77_0==51||(LA77_0>=54 && LA77_0<=56)||LA77_0==58||(LA77_0>=64 && LA77_0<=66)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4671:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9771);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==25) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleContainerInitializer9784); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4691:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4692:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4692:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4693:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9805);
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
                    	    break loop76;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleContainerInitializer9821); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4721:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4722:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4723:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9857);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression9867); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4730:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4733:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4734:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4734:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_EXPONENT)||LA78_0==16||LA78_0==29||(LA78_0>=31 && LA78_0<=32)||LA78_0==35||LA78_0==51||(LA78_0>=54 && LA78_0<=56)||LA78_0==58||(LA78_0>=64 && LA78_0<=66)) ) {
                alt78=1;
            }
            else if ( (LA78_0==18) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4734:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4734:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4735:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4735:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4736:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9913);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4753:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4753:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4754:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4754:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4755:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9940);
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


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA65 dfa65 = new DFA65(this);
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\1\1\12\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\3\5\1\uffff\4\5";
    static final String DFA10_maxS =
        "\1\105\2\uffff\3\77\1\uffff\1\10\3\77";
    static final String DFA10_acceptS =
        "\1\uffff\1\3\1\1\3\uffff\1\2\4\uffff";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\6\1\4\1\6\1\3\1\5\7\uffff\1\6\2\uffff\1\1\4\uffff\1\6\1"+
            "\uffff\1\6\2\uffff\1\6\1\uffff\2\6\2\uffff\1\6\1\2\16\uffff"+
            "\1\6\2\uffff\3\6\1\uffff\1\6\5\uffff\3\6\3\2",
            "",
            "",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "",
            "\1\11\1\uffff\1\10\1\12",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7",
            "\1\2\1\uffff\2\2\7\uffff\1\6\7\uffff\1\6\16\uffff\5\6\1\uffff"+
            "\11\6\3\uffff\1\6\1\uffff\2\6\2\uffff\1\7"
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
    }
    static final String DFA13_eotS =
        "\64\uffff";
    static final String DFA13_eofS =
        "\64\uffff";
    static final String DFA13_minS =
        "\1\4\1\uffff\3\20\1\uffff\1\4\3\5\3\20\1\27\1\5\3\16\7\5\11\21"+
        "\11\5\11\21";
    static final String DFA13_maxS =
        "\1\102\1\uffff\3\77\1\uffff\1\105\3\77\3\20\1\74\1\10\3\76\3\10"+
        "\3\77\1\105\11\31\3\77\6\10\11\31";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\56\uffff";
    static final String DFA13_specialS =
        "\64\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\5\1\3\1\5\1\2\1\4\7\uffff\1\5\7\uffff\1\5\1\uffff\1\1\2"+
            "\uffff\1\5\1\uffff\2\5\2\uffff\1\5\17\uffff\1\5\2\uffff\3\5"+
            "\1\uffff\1\5\5\uffff\3\5",
            "",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\2\uffff\1\5",
            "",
            "\1\5\1\10\1\5\1\7\1\11\7\uffff\1\5\1\15\1\5\12\uffff\1\5\1"+
            "\uffff\2\5\2\uffff\1\5\17\uffff\1\5\2\uffff\3\5\1\uffff\1\5"+
            "\5\uffff\3\5\1\12\1\13\1\14",
            "\1\20\1\uffff\1\17\1\21\5\uffff\1\5\1\uffff\2\5\5\uffff\1"+
            "\5\1\uffff\1\5\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\1\uffff\1\5\1\16",
            "\1\20\1\uffff\1\17\1\21\5\uffff\1\5\1\uffff\2\5\5\uffff\1"+
            "\5\1\uffff\1\5\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\1\uffff\1\5\1\16",
            "\1\20\1\uffff\1\17\1\21\5\uffff\1\5\1\uffff\2\5\5\uffff\1"+
            "\5\1\uffff\1\5\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\2\5\1\uffff\1\5\1\16",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\1\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5",
            "\1\26\1\uffff\1\25\1\27",
            "\1\5\2\uffff\1\1\7\uffff\1\30\44\uffff\1\5",
            "\1\5\2\uffff\1\1\7\uffff\1\30\44\uffff\1\5",
            "\1\5\2\uffff\1\1\7\uffff\1\30\44\uffff\1\5",
            "\1\32\1\uffff\1\31\1\33",
            "\1\35\1\uffff\1\34\1\36",
            "\1\40\1\uffff\1\37\1\41",
            "\1\20\1\uffff\1\17\1\21\7\uffff\2\5\7\uffff\1\5\15\uffff\5"+
            "\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\16",
            "\1\20\1\uffff\1\17\1\21\7\uffff\2\5\7\uffff\1\5\15\uffff\5"+
            "\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\16",
            "\1\20\1\uffff\1\17\1\21\7\uffff\2\5\7\uffff\1\5\15\uffff\5"+
            "\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\16",
            "\1\43\1\uffff\1\42\1\44\72\uffff\3\1",
            "\1\46\7\uffff\1\45",
            "\1\46\7\uffff\1\45",
            "\1\46\7\uffff\1\45",
            "\1\50\7\uffff\1\47",
            "\1\50\7\uffff\1\47",
            "\1\50\7\uffff\1\47",
            "\1\52\7\uffff\1\51",
            "\1\52\7\uffff\1\51",
            "\1\52\7\uffff\1\51",
            "\1\1\1\uffff\2\1\5\uffff\1\5\12\uffff\1\5\44\uffff\1\5\1\1",
            "\1\1\1\uffff\2\1\5\uffff\1\5\12\uffff\1\5\44\uffff\1\5\1\1",
            "\1\1\1\uffff\2\1\5\uffff\1\5\12\uffff\1\5\44\uffff\1\5\1\1",
            "\1\54\1\uffff\1\53\1\55",
            "\1\20\1\uffff\1\17\1\21",
            "\1\57\1\uffff\1\56\1\60",
            "\1\20\1\uffff\1\17\1\21",
            "\1\62\1\uffff\1\61\1\63",
            "\1\20\1\uffff\1\17\1\21",
            "\1\46\7\uffff\1\45",
            "\1\46\7\uffff\1\45",
            "\1\46\7\uffff\1\45",
            "\1\50\7\uffff\1\47",
            "\1\50\7\uffff\1\47",
            "\1\50\7\uffff\1\47",
            "\1\52\7\uffff\1\51",
            "\1\52\7\uffff\1\51",
            "\1\52\7\uffff\1\51"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "576:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' )?";
        }
    }
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\13\uffff";
    static final String DFA19_minS =
        "\1\4\1\uffff\3\5\2\uffff\4\5";
    static final String DFA19_maxS =
        "\1\105\1\uffff\3\77\2\uffff\1\10\3\77";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\1\3\4\uffff";
    static final String DFA19_specialS =
        "\13\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\5\1\3\1\5\1\2\1\4\7\uffff\1\5\1\uffff\1\5\10\uffff\1\6\1"+
            "\uffff\1\5\1\uffff\2\5\2\uffff\1\5\1\1\16\uffff\1\5\2\uffff"+
            "\3\5\1\uffff\1\5\5\uffff\3\5\3\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\6\uffff\1\5\17\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\6\uffff\1\5\17\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\6\uffff\1\5\17\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7",
            "",
            "",
            "\1\11\1\uffff\1\10\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\26\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\26\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\5\1\uffff\1\5\26\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\7"
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
            return "803:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_deferDecl_2_0= ruleDeferDeclaration ) ) )";
        }
    }
    static final String DFA22_eotS =
        "\20\uffff";
    static final String DFA22_eofS =
        "\2\uffff\3\1\10\uffff\3\1";
    static final String DFA22_minS =
        "\1\4\1\uffff\3\16\6\uffff\1\5\1\uffff\3\16";
    static final String DFA22_maxS =
        "\1\102\1\uffff\3\77\6\uffff\1\10\1\uffff\3\77";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\3\uffff";
    static final String DFA22_specialS =
        "\20\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\14\uffff\1\11\1\uffff\1\7"+
            "\1\10\2\uffff\1\6\24\uffff\1\5\1\uffff\1\12\5\uffff\3\1",
            "",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\15\1\17",
            "",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\13"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1007:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA65_eotS =
        "\16\uffff";
    static final String DFA65_eofS =
        "\16\uffff";
    static final String DFA65_minS =
        "\1\4\3\5\2\uffff\1\5\1\4\3\5\3\16";
    static final String DFA65_maxS =
        "\1\105\3\77\2\uffff\1\10\1\102\6\77";
    static final String DFA65_acceptS =
        "\4\uffff\1\1\1\2\10\uffff";
    static final String DFA65_specialS =
        "\16\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\5\1\2\1\5\1\1\1\3\7\uffff\3\5\12\uffff\1\5\1\uffff\2\5\2"+
            "\uffff\1\5\17\uffff\1\5\2\uffff\3\5\1\uffff\1\5\5\uffff\3\5"+
            "\3\4",
            "\1\4\1\uffff\2\4\5\uffff\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff"+
            "\1\7\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff"+
            "\1\4\1\6",
            "\1\4\1\uffff\2\4\5\uffff\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff"+
            "\1\7\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff"+
            "\1\4\1\6",
            "\1\4\1\uffff\2\4\5\uffff\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff"+
            "\1\7\15\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff"+
            "\1\4\1\6",
            "",
            "",
            "\1\11\1\uffff\1\10\1\12",
            "\1\5\1\14\1\5\1\13\1\15\7\uffff\1\5\1\uffff\1\5\12\uffff\1"+
            "\5\1\uffff\2\5\2\uffff\1\5\17\uffff\1\5\2\uffff\3\5\1\uffff"+
            "\1\5\5\uffff\3\5",
            "\1\4\1\uffff\2\4\7\uffff\2\5\7\uffff\1\5\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\6",
            "\1\4\1\uffff\2\4\7\uffff\2\5\7\uffff\1\5\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\6",
            "\1\4\1\uffff\2\4\7\uffff\2\5\7\uffff\1\5\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\2\uffff\1\6",
            "\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff\1\7\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5",
            "\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff\1\7\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5",
            "\1\4\1\uffff\2\5\5\uffff\1\5\1\uffff\1\7\15\uffff\5\5\1\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5"
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3912:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleImplementationUnit_in_entryRuleImplementationUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplementationUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleImplementationUnit149 = new BitSet(new long[]{0x000010200000A002L});
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
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit437 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit458 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit470 = new BitSet(new long[]{0x00000000000201A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit491 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit504 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_ruleLanguageUnit525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit538 = new BitSet(new long[]{0x05C80059A52901F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit559 = new BitSet(new long[]{0x05C80019A52901F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleLoadProperties_in_ruleLanguageUnit581 = new BitSet(new long[]{0x05C80019A52901F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleScriptContents_in_ruleLanguageUnit603 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLanguageUnit615 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_entryRuleScriptParentDecl666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptParentDecl676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleScriptParentDecl713 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleScriptParentDecl734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoadProperties_in_entryRuleLoadProperties770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoadProperties780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLoadProperties817 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLoadProperties829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLoadProperties846 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoadProperties863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptContents_in_entryRuleScriptContents899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptContents909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleScriptContents968 = new BitSet(new long[]{0x05C80019A50101F2L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_ruleScriptContents995 = new BitSet(new long[]{0x05C80019A50101F2L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDeclaration1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1102 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1124 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRuleDeclaration1136 = new BitSet(new long[]{0x00000000000201A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleRuleDeclaration1157 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleDeclaration1170 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleRuleDeclaration1182 = new BitSet(new long[]{0x05C80009A10101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1205 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleRuleDeclaration1218 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1240 = new BitSet(new long[]{0x05C80009A20501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_25_in_ruleRuleDeclaration1253 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1274 = new BitSet(new long[]{0x05C80009A20501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1299 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRuleDeclaration1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElementBlock1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRuleElementBlock1409 = new BitSet(new long[]{0x05C80019A80D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1430 = new BitSet(new long[]{0x05C80019A80D01F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_19_in_ruleRuleElementBlock1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElement_in_entryRuleRuleElement1479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElement1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleRuleElement1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeferDeclaration_in_ruleRuleElement1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleModifier1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRuleModifier1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeferDeclaration_in_entryRuleDeferDeclaration1725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeferDeclaration1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeferDeclaration1772 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1793 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_28_in_ruleDeferDeclaration1806 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1827 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleDeferDeclaration1840 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeferDeclaration1861 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_14_in_ruleDeferDeclaration1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_rulePrimaryExpression2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_rulePrimaryExpression2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_rulePrimaryExpression2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_entryRuleInstantiate2194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantiate2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleInstantiate2241 = new BitSet(new long[]{0x00000000000001B0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInstantiate2264 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleInstantiate2277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2294 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2325 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInstantiate2343 = new BitSet(new long[]{0x05C80009A00701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleInstantiate2364 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInstantiate2377 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleInstantiate2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapVariable_in_entryRuleMapVariable2435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapVariable2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleMapVariable2491 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleMapVariable2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_entryRuleMap2549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMap2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMap2596 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMap2608 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2629 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_25_in_ruleMap2642 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2663 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_ruleMap2685 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_24_in_ruleMap2714 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMap2751 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMap2763 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleMap2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_entryRuleJoin2820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoin2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleJoin2867 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin2879 = new BitSet(new long[]{0x00000004000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin2900 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleJoin2912 = new BitSet(new long[]{0x00000004000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin2933 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin2945 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleJoin2958 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin2970 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoin2991 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoinVariable3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleJoinVariable3094 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJoinVariable3129 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleJoinVariable3141 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoinVariable3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemExecution3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleSystemExecution3245 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSystemExecution3266 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSystemExecution3287 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleVariableDeclaration3377 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3412 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3433 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3446 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3467 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVariableDeclaration3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAdvice3564 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAdvice3576 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice3597 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAdvice3609 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVersionSpec3714 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVersionSpec3726 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3747 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleVersionSpec3760 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3781 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleVersionSpec3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId3831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVersionedId3878 = new BitSet(new long[]{0x00000F8000000000L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_ruleVersionedId3899 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionedId3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleVersionOperator4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleVersionOperator4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleVersionOperator4045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVersionOperator4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVersionOperator4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList4123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4179 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleParameterList4192 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4213 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4307 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVersionStmt4411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4428 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionStmt4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleImport4528 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4549 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4570 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleImport4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement4629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4676 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement4688 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement4711 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4934 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4955 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart5048 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator5117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLogicalOperator5155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLogicalOperator5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleLogicalOperator5193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5289 = new BitSet(new long[]{0x0003008000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5403 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleEqualityOperator5510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEqualityOperator5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEqualityOperator5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5644 = new BitSet(new long[]{0x00000F0000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5758 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleRelationalOperator5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRelationalOperator5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleRelationalOperator5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRelationalOperator5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6018 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6039 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6132 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAdditiveOperator6239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAdditiveOperator6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6354 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6468 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleMultiplicativeOperator6575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMultiplicativeOperator6594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6690 = new BitSet(new long[]{0x05C80009A00101F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryOperator6798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator6817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator6836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7023 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionOrQualifiedExecution7042 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7063 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExpressionOrQualifiedExecution7075 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7098 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7191 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7212 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSuperExecution7296 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleSuperExecution7308 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7329 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7350 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConstructorExecution7434 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7455 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstructorExecution7467 = new BitSet(new long[]{0x05C80009A00701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7488 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConstructorExecution7501 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7522 = new BitSet(new long[]{0x1A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSubCall7615 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_59_in_ruleSubCall7644 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSubCall7701 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7722 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleSubCall7734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7827 = new BitSet(new long[]{0x4000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDeclarator7840 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7861 = new BitSet(new long[]{0x4000000000004000L});
    public static final BitSet FOLLOW_62_in_ruleDeclarator7875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration7911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration7921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration7967 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration7989 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleDeclaration8002 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration8023 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall8061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall8071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8117 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCall8129 = new BitSet(new long[]{0x05C80009A00701F0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8150 = new BitSet(new long[]{0x05C80009A00701F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8172 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCall8185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8277 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleArgumentList8290 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8311 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8406 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedArgument8418 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8533 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleQualifiedPrefix8552 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8586 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8680 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQualifiedName8699 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleConstant8908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConstant8937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConstant8977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue9026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue9036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleType9347 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleType9407 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleType9467 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeParameters9585 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9606 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleTypeParameters9619 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9640 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeParameters9654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer9749 = new BitSet(new long[]{0x05C80009A00D01F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9771 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleContainerInitializer9784 = new BitSet(new long[]{0x05C80009A00501F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9805 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleContainerInitializer9821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression9867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9940 = new BitSet(new long[]{0x0000000000000002L});

}