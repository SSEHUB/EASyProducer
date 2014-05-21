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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'defer'", "'requires'", "'instantiate'", "'rule'", "'map'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'@advice'", "'version'", "'=='", "'>'", "'<'", "'>='", "'<='", "'import'", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'['", "']'", "'::'", "'true'", "'false'", "'setOf'", "'sequenceOf'", "'mapOf'"
    };
    public static final int RULE_ID=7;
    public static final int T__66=66;
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

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||(LA5_0>=64 && LA5_0<=66)) ) {
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
                switch ( input.LA(1) ) {
                case 36:
                case 64:
                case 65:
                case 66:
                    {
                    alt10=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==16||LA10_3==24||(LA10_3>=39 && LA10_3<=43)||(LA10_3>=45 && LA10_3<=53)||LA10_3==57||LA10_3==59||LA10_3==61) ) {
                        alt10=2;
                    }
                    else if ( (LA10_3==RULE_VERSION||(LA10_3>=RULE_ID && LA10_3<=RULE_EXPONENT)) ) {
                        alt10=1;
                    }


                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA10_4 = input.LA(2);

                    if ( (LA10_4==16||LA10_4==24||(LA10_4>=39 && LA10_4<=43)||(LA10_4>=45 && LA10_4<=53)||LA10_4==57||LA10_4==59||LA10_4==61) ) {
                        alt10=2;
                    }
                    else if ( (LA10_4==RULE_VERSION||(LA10_4>=RULE_ID && LA10_4<=RULE_EXPONENT)) ) {
                        alt10=1;
                    }


                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA10_5 = input.LA(2);

                    if ( (LA10_5==16||LA10_5==24||(LA10_5>=39 && LA10_5<=43)||(LA10_5>=45 && LA10_5<=53)||LA10_5==57||LA10_5==59||LA10_5==61) ) {
                        alt10=2;
                    }
                    else if ( (LA10_5==RULE_VERSION||(LA10_5>=RULE_ID && LA10_5<=RULE_EXPONENT)) ) {
                        alt10=1;
                    }


                    }
                    break;
                case RULE_STRING:
                case RULE_NUMBER:
                case 16:
                case 24:
                case 26:
                case 29:
                case 31:
                case 32:
                case 35:
                case 51:
                case 54:
                case 55:
                case 56:
                case 58:
                case 62:
                case 63:
                    {
                    alt10=2;
                    }
                    break;

                }

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

                    if ( (LA12_0==RULE_VERSION||(LA12_0>=RULE_ID && LA12_0<=RULE_EXPONENT)||(LA12_0>=64 && LA12_0<=66)) ) {
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

            if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_EXPONENT)||LA14_0==16||LA14_0==29||(LA14_0>=31 && LA14_0<=32)||LA14_0==35||LA14_0==51||(LA14_0>=54 && LA14_0<=56)||LA14_0==58||(LA14_0>=62 && LA14_0<=63)) ) {
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

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_EXPONENT)||LA16_0==16||LA16_0==29||(LA16_0>=31 && LA16_0<=32)||LA16_0==35||LA16_0==51||(LA16_0>=54 && LA16_0<=56)||LA16_0==58||(LA16_0>=62 && LA16_0<=63)) ) {
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

                if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_EXPONENT)||LA18_0==16||LA18_0==18||LA18_0==27||LA18_0==29||(LA18_0>=31 && LA18_0<=32)||(LA18_0>=35 && LA18_0<=36)||LA18_0==51||(LA18_0>=54 && LA18_0<=56)||LA18_0==58||(LA18_0>=62 && LA18_0<=66)) ) {
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
            switch ( input.LA(1) ) {
            case 36:
            case 64:
            case 65:
            case 66:
                {
                alt19=1;
                }
                break;
            case RULE_ID:
                {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==RULE_VERSION||(LA19_2>=RULE_ID && LA19_2<=RULE_EXPONENT)) ) {
                    alt19=1;
                }
                else if ( (LA19_2==14||LA19_2==16||LA19_2==23||(LA19_2>=39 && LA19_2<=43)||(LA19_2>=45 && LA19_2<=53)||LA19_2==57||LA19_2==59||LA19_2==61) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA19_3 = input.LA(2);

                if ( (LA19_3==14||LA19_3==16||LA19_3==23||(LA19_3>=39 && LA19_3<=43)||(LA19_3>=45 && LA19_3<=53)||LA19_3==57||LA19_3==59||LA19_3==61) ) {
                    alt19=2;
                }
                else if ( (LA19_3==RULE_VERSION||(LA19_3>=RULE_ID && LA19_3<=RULE_EXPONENT)) ) {
                    alt19=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA19_4 = input.LA(2);

                if ( (LA19_4==14||LA19_4==16||LA19_4==23||(LA19_4>=39 && LA19_4<=43)||(LA19_4>=45 && LA19_4<=53)||LA19_4==57||LA19_4==59||LA19_4==61) ) {
                    alt19=2;
                }
                else if ( (LA19_4==RULE_VERSION||(LA19_4>=RULE_ID && LA19_4<=RULE_EXPONENT)) ) {
                    alt19=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_NUMBER:
            case 16:
            case 18:
            case 29:
            case 31:
            case 32:
            case 35:
            case 51:
            case 54:
            case 55:
            case 56:
            case 58:
            case 62:
            case 63:
                {
                alt19=2;
                }
                break;
            case 27:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

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

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_EXPONENT)||LA25_0==16||LA25_0==18||LA25_0==29||(LA25_0>=31 && LA25_0<=32)||LA25_0==35||LA25_0==51||(LA25_0>=54 && LA25_0<=56)||LA25_0==58||(LA25_0>=62 && LA25_0<=63)) ) {
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


    // $ANTLR start "entryRuleMap"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1294:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1295:2: (iv_ruleMap= ruleMap EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1296:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_ruleMap_in_entryRuleMap2435);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMap2445); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1303:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleIdentifier ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )* otherlv_5= '=' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_var_2_0 = null;

        AntlrDatatypeRuleToken lv_var_4_0 = null;

        EObject lv_expr_6_0 = null;

        EObject lv_block_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1306:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleIdentifier ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )* otherlv_5= '=' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleIdentifier ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )* otherlv_5= '=' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleIdentifier ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )* otherlv_5= '=' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1307:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleIdentifier ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )* otherlv_5= '=' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleMap2482); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleMap2494); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1315:1: ( (lv_var_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1316:1: (lv_var_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1316:1: (lv_var_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1317:3: lv_var_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleMap2515);
            lv_var_2_0=ruleIdentifier();

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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1333:2: (otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==25) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1333:4: otherlv_3= ',' ( (lv_var_4_0= ruleIdentifier ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleMap2528); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1337:1: ( (lv_var_4_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1338:1: (lv_var_4_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1338:1: (lv_var_4_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1339:3: lv_var_4_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarIdentifierParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleMap2549);
            	    lv_var_4_0=ruleIdentifier();

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

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleMap2563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMapAccess().getEqualsSignKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1359:1: ( (lv_expr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1360:1: (lv_expr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1360:1: (lv_expr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1361:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMap2584);
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

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMap2596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1381:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1382:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1382:1: (lv_block_8_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1383:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleMap2617);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1407:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1408:2: (iv_ruleJoin= ruleJoin EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1409:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_ruleJoin_in_entryRuleJoin2653);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoin2663); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1416:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1419:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1420:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1420:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1420:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleJoin2700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJoin2712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1428:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1429:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1429:1: (lv_var1_2_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1430:3: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin2733);
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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleJoin2745); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1450:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1451:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1451:1: (lv_var2_4_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1452:3: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin2766);
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

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJoin2778); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1472:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1472:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleJoin2791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleJoin2803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1480:1: ( (lv_condition_8_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1481:1: (lv_condition_8_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1481:1: (lv_condition_8_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1482:3: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleJoin2824);
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

                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleJoin2836); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1510:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1511:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1512:2: iv_ruleJoinVariable= ruleJoinVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinVariableRule()); 
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable2874);
            iv_ruleJoinVariable=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoinVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoinVariable2884); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1519:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1522:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1523:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1523:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1523:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1523:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1524:1: (lv_excl_0_0= 'exclude' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1524:1: (lv_excl_0_0= 'exclude' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1525:3: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,34,FOLLOW_34_in_ruleJoinVariable2927); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1538:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1539:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1539:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1540:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJoinVariable2962);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleJoinVariable2974); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1560:1: ( (lv_expr_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1561:1: (lv_expr_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1561:1: (lv_expr_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1562:3: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getExprExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleJoinVariable2995);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1586:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1587:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1588:2: iv_ruleSystemExecution= ruleSystemExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3031);
            iv_ruleSystemExecution=ruleSystemExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemExecution3041); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1595:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1598:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1599:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1599:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1599:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleSystemExecution3078); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1603:1: ( (lv_call_1_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1604:1: (lv_call_1_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1604:1: (lv_call_1_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1605:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSystemExecution3099);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1621:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==57||LA30_0==59) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1622:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1622:1: (lv_calls_2_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1623:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSystemExecution3120);
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1647:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1648:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1649:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3157);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3167); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1656:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1659:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1660:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1660:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1660:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1660:2: ( (lv_const_0_0= 'const' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1661:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1661:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1662:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,36,FOLLOW_36_in_ruleVariableDeclaration3210); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1675:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1676:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1676:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1677:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3245);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1693:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1694:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1694:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1695:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3266);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1711:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==23) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1711:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1715:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1716:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1716:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1717:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3300);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVariableDeclaration3314); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1745:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1746:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1747:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3350);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3360); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1754:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1757:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1758:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleAdvice3397); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAdvice3409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1766:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1767:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1767:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1768:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice3430);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAdvice3442); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1788:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1789:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1789:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1790:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice3463);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1814:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1815:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1816:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3500);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec3510); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1823:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1826:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1827:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1827:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1827:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleVersionSpec3547); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleVersionSpec3559); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1835:1: ( (lv_conflicts_2_0= ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1836:1: (lv_conflicts_2_0= ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1836:1: (lv_conflicts_2_0= ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1837:3: lv_conflicts_2_0= ruleVersionedId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3580);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1853:2: (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==25) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1853:4: otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleVersionSpec3593); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1857:1: ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1858:1: (lv_conflicts_4_0= ruleVersionedId )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1858:1: (lv_conflicts_4_0= ruleVersionedId )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1859:3: lv_conflicts_4_0= ruleVersionedId
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3614);
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
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleVersionSpec3628); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1887:1: entryRuleVersionedId returns [EObject current=null] : iv_ruleVersionedId= ruleVersionedId EOF ;
    public final EObject entryRuleVersionedId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionedId = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1888:2: (iv_ruleVersionedId= ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1889:2: iv_ruleVersionedId= ruleVersionedId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionedIdRule()); 
            }
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId3664);
            iv_ruleVersionedId=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionedId; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId3674); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1896:1: ruleVersionedId returns [EObject current=null] : (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) ;
    public final EObject ruleVersionedId() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_2_0=null;
        AntlrDatatypeRuleToken lv_op_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1899:28: ( (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1900:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1900:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1900:3: otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleVersionedId3711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionedIdAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1904:1: ( (lv_op_1_0= ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1905:1: (lv_op_1_0= ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1905:1: (lv_op_1_0= ruleVersionOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1906:3: lv_op_1_0= ruleVersionOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_ruleVersionedId3732);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1922:2: ( (lv_version_2_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1923:1: (lv_version_2_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1923:1: (lv_version_2_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1924:3: lv_version_2_0= RULE_VERSION
            {
            lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionedId3749); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1948:1: entryRuleVersionOperator returns [String current=null] : iv_ruleVersionOperator= ruleVersionOperator EOF ;
    public final String entryRuleVersionOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1949:2: (iv_ruleVersionOperator= ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1950:2: iv_ruleVersionOperator= ruleVersionOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3791);
            iv_ruleVersionOperator=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator3802); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1957:1: ruleVersionOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleVersionOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1960:28: ( (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1961:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1961:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt35=5;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt35=1;
                }
                break;
            case 40:
                {
                alt35=2;
                }
                break;
            case 41:
                {
                alt35=3;
                }
                break;
            case 42:
                {
                alt35=4;
                }
                break;
            case 43:
                {
                alt35=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1962:2: kw= '=='
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleVersionOperator3840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1969:2: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleVersionOperator3859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1976:2: kw= '<'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleVersionOperator3878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1983:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleVersionOperator3897); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1990:2: kw= '<='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleVersionOperator3916); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2003:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2004:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2005:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList3956);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList3966); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2012:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2015:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2016:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2016:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2016:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2016:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2017:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2017:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2018:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4012);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2034:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2034:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleParameterList4025); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2038:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2039:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2039:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2040:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4046);
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2064:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2065:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2066:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4084);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4094); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2073:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2076:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2077:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2077:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2077:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2077:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2078:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2078:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2079:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4140);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2095:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2096:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2096:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2097:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4161);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2121:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2122:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2123:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4197);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4207); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2130:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2133:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2134:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2134:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2134:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleVersionStmt4244); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2138:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2139:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2139:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2140:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4261); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleVersionStmt4278); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2168:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2169:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2170:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4314);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4324); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2177:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2180:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2181:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2181:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2181:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleImport4361); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2185:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2186:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2186:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2187:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4382);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2203:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2204:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2204:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2205:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4403);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImport4416); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2233:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2234:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2235:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4452);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement4462); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2242:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2245:28: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt38=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA38_1 = input.LA(2);

                    if ( (LA38_1==23) ) {
                        alt38=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA38_2 = input.LA(2);

                    if ( (LA38_2==23) ) {
                        alt38=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA38_3 = input.LA(2);

                    if ( (LA38_3==23) ) {
                        alt38=1;
                    }
                    }
                    break;
            }

            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:3: ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2246:3: ( (lv_var_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2247:1: (lv_var_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2247:1: (lv_var_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2248:3: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4509);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement4521); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2268:3: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2269:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2269:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2270:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement4544);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement4556); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2298:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2299:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2300:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4592);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4602); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2307:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2310:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2311:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2311:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_EXPONENT)||LA39_0==16||LA39_0==29||(LA39_0>=31 && LA39_0<=32)||LA39_0==35||LA39_0==51||(LA39_0>=54 && LA39_0<=56)||LA39_0==58||(LA39_0>=62 && LA39_0<=63)) ) {
                alt39=1;
            }
            else if ( (LA39_0==18) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2311:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2311:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2312:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2312:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2313:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4648);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2330:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2330:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2331:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2331:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2332:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4675);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2356:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2357:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2358:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4711);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4721); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2365:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2368:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2369:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2369:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2369:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2369:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2370:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2370:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2371:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4767);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2387:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=45 && LA40_0<=47)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2388:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2388:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2389:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4788);
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
            	    break loop40;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2413:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2414:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2415:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4825);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart4835); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2422:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2425:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2426:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2426:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2426:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2426:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2427:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2427:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2428:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4881);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2444:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2445:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2445:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2446:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4902);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2470:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2471:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2472:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4939);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator4950); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2479:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2482:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt41=1;
                }
                break;
            case 46:
                {
                alt41=2;
                }
                break;
            case 47:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2484:2: kw= 'and'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleLogicalOperator4988); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2491:2: kw= 'or'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleLogicalOperator5007); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2498:2: kw= 'xor'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleLogicalOperator5026); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2511:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2512:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2513:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5066);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5076); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2520:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2523:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2524:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2524:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2524:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2524:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2525:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2525:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2526:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5122);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2542:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39||(LA42_0>=48 && LA42_0<=49)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2543:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2543:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2544:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5143);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2568:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2569:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2570:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5180);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5190); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2577:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2580:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2581:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2581:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2581:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2581:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2582:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2582:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2583:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5236);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2599:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2600:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2600:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2601:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5257);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2625:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2626:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2627:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5294);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5305); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2634:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2637:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2638:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2638:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt43=1;
                }
                break;
            case 48:
                {
                alt43=2;
                }
                break;
            case 49:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2639:2: kw= '=='
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleEqualityOperator5343); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2646:2: kw= '<>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleEqualityOperator5362); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2653:2: kw= '!='
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleEqualityOperator5381); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2666:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2667:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2668:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5421);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5431); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2675:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2678:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2679:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2679:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2679:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2679:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2680:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2680:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2681:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5477);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2697:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=40 && LA44_0<=43)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2698:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2698:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2699:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5498);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2723:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2724:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2725:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5535);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5545); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2732:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2735:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2736:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2736:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2736:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2736:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2737:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2737:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2738:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5591);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2754:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2755:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2755:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2756:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5612);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2780:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2781:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2782:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5649);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5660); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2789:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2792:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2793:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2793:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt45=4;
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
            case 43:
                {
                alt45=4;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2794:2: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleRelationalOperator5698); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2801:2: kw= '<'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleRelationalOperator5717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2808:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleRelationalOperator5736); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2815:2: kw= '<='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleRelationalOperator5755); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2828:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2829:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2830:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5795);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5805); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2837:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2840:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2841:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2841:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2841:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2841:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2842:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2842:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2843:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5851);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2859:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=50 && LA46_0<=51)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2860:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2860:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2861:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5872);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2885:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2886:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2887:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5909);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5919); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2894:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2897:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2898:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2898:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2898:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2898:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2899:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2899:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2900:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5965);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2916:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2917:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2917:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2918:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5986);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2942:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2943:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2944:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6023);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6034); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2951:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2954:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2955:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2955:1: (kw= '+' | kw= '-' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                alt47=1;
            }
            else if ( (LA47_0==51) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2956:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleAdditiveOperator6072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2963:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleAdditiveOperator6091); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2976:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2977:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2978:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6131);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6141); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2985:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2988:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2989:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2989:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2989:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2989:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2990:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2990:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2991:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6187);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3007:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=52 && LA48_0<=53)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3008:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3008:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3009:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6208);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3033:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3034:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3035:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6245);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6255); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3042:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3045:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3046:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3046:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3046:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3046:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3047:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3047:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3048:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6301);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3064:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3065:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3065:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3066:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6322);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3090:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3091:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3092:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6359);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6370); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3099:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3102:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3103:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3103:1: (kw= '*' | kw= '/' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==52) ) {
                alt49=1;
            }
            else if ( (LA49_0==53) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3104:2: kw= '*'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleMultiplicativeOperator6408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3111:2: kw= '/'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleMultiplicativeOperator6427); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3124:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3125:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3126:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6467);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6477); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3133:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3136:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3137:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3137:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3137:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3137:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==51||(LA50_0>=54 && LA50_0<=55)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3138:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3138:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3139:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6523);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3155:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3156:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3156:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3157:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6545);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3181:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3182:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3183:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6582);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6593); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3190:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3193:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3194:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3194:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt51=1;
                }
                break;
            case 55:
                {
                alt51=2;
                }
                break;
            case 51:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3195:2: kw= 'not'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleUnaryOperator6631); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3202:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleUnaryOperator6650); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3209:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleUnaryOperator6669); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3222:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3223:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3224:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6709);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6719); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3231:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3234:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3235:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3235:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3236:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3236:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3237:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6764);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3261:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3262:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3263:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6799);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6809); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3270:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3273:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_EXPONENT)||(LA52_0>=62 && LA52_0<=63)) ) {
                alt52=1;
            }
            else if ( (LA52_0==16) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3275:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3275:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3276:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6856);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3293:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3293:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3293:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionOrQualifiedExecution6875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3297:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3298:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3298:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3299:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6896);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleExpressionOrQualifiedExecution6908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3319:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==57||LA53_0==59) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3320:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3320:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3321:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution6931);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3345:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3346:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3347:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution6968);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution6978); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3354:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3357:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3358:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3359:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3360:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7024);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3376:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==57||LA54_0==59) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3377:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3377:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3378:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7045);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3402:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3403:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3404:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7082);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7092); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3411:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3414:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3415:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3415:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3415:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleSuperExecution7129); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleSuperExecution7141); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3423:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3424:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3425:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7162);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3441:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==57||LA55_0==59) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3443:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7183);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3467:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3468:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3469:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7220);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7230); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3476:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3479:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3480:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3480:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3480:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleConstructorExecution7267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3484:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3485:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3485:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3486:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7288);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConstructorExecution7300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3506:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_STRING && LA56_0<=RULE_EXPONENT)||LA56_0==16||LA56_0==18||LA56_0==29||(LA56_0>=31 && LA56_0<=32)||LA56_0==35||LA56_0==51||(LA56_0>=54 && LA56_0<=56)||LA56_0==58||(LA56_0>=62 && LA56_0<=63)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3507:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3507:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3508:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7321);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleConstructorExecution7334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3528:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==57||LA57_0==59) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3529:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3529:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3530:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7355);
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
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3554:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3555:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3556:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7392);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7402); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3563:1: ruleSubCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
    public final EObject ruleSubCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_call_1_0 = null;

        EObject lv_arrayEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3566:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==57) ) {
                alt58=1;
            }
            else if ( (LA58_0==59) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:2: (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:2: (otherlv_0= '.' ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3567:4: otherlv_0= '.' ( (lv_call_1_0= ruleCall ) )
                    {
                    otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleSubCall7440); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSubCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3571:1: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3572:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3572:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3573:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7461);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3590:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3590:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3590:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleSubCall7481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3594:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3595:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3595:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3596:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7502);
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

                    otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleSubCall7514); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3624:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3625:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3626:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall7551);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall7561); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3633:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_param_2_0= ruleArgumentList ) )? otherlv_3= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3636:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_param_2_0= ruleArgumentList ) )? otherlv_3= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3637:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_param_2_0= ruleArgumentList ) )? otherlv_3= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3637:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_param_2_0= ruleArgumentList ) )? otherlv_3= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3637:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_param_2_0= ruleArgumentList ) )? otherlv_3= ')'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3637:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3638:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3638:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3639:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall7607);
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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleCall7619); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3659:1: ( (lv_param_2_0= ruleArgumentList ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_EXPONENT)||LA59_0==16||LA59_0==18||LA59_0==29||(LA59_0>=31 && LA59_0<=32)||LA59_0==35||LA59_0==51||(LA59_0>=54 && LA59_0<=56)||LA59_0==58||(LA59_0>=62 && LA59_0<=63)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3660:1: (lv_param_2_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3660:1: (lv_param_2_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3661:3: lv_param_2_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall7640);
                    lv_param_2_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_2_0, 
                              		"ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleCall7653); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCallAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3689:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3690:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3691:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList7689);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList7699); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3698:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3701:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3702:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3702:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3702:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3702:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3703:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3703:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3704:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList7745);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3720:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==25) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3720:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleArgumentList7758); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3724:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3725:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3725:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3726:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList7779);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3750:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3751:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3752:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument7817);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument7827); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3759:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3762:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt61=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA61_1 = input.LA(2);

                    if ( (LA61_1==23) ) {
                        alt61=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA61_2 = input.LA(2);

                    if ( (LA61_2==23) ) {
                        alt61=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA61_3 = input.LA(2);

                    if ( (LA61_3==23) ) {
                        alt61=1;
                    }
                    }
                    break;
            }

            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3763:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3764:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3764:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3765:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument7874);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNamedArgument7886); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3785:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3786:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3786:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3787:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument7909);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3811:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3812:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3813:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix7945);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix7955); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3820:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3823:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3824:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3824:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3824:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3824:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3825:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3825:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3826:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8001);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3842:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==61) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3842:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3842:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3843:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3843:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3844:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,61,FOLLOW_61_in_ruleQualifiedPrefix8020); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3857:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3858:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3858:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3859:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8054);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3883:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3884:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3885:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8092);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8102); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3892:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3895:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3897:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3897:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3898:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8148);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==57) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA63_3 = input.LA(3);

                        if ( (LA63_3==EOF||LA63_3==14||(LA63_3>=17 && LA63_3<=19)||(LA63_3>=24 && LA63_3<=25)||(LA63_3>=39 && LA63_3<=43)||(LA63_3>=45 && LA63_3<=53)||LA63_3==57||(LA63_3>=59 && LA63_3<=60)) ) {
                            alt63=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA63_4 = input.LA(3);

                        if ( (LA63_4==EOF||LA63_4==14||(LA63_4>=17 && LA63_4<=19)||(LA63_4>=24 && LA63_4<=25)||(LA63_4>=39 && LA63_4<=43)||(LA63_4>=45 && LA63_4<=53)||LA63_4==57||(LA63_4>=59 && LA63_4<=60)) ) {
                            alt63=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA63_5 = input.LA(3);

                        if ( (LA63_5==EOF||LA63_5==14||(LA63_5>=17 && LA63_5<=19)||(LA63_5>=24 && LA63_5<=25)||(LA63_5>=39 && LA63_5<=43)||(LA63_5>=45 && LA63_5<=53)||LA63_5==57||(LA63_5>=59 && LA63_5<=60)) ) {
                            alt63=1;
                        }
                        }
                        break;
                }

            }
            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3914:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3915:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3915:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3916:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,57,FOLLOW_57_in_ruleQualifiedName8167); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3929:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3930:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3930:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3931:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8201);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3955:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3956:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3957:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8239);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8249); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3964:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3967:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3968:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3968:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) )
            int alt65=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt65=1;
                }
                break;
            case RULE_STRING:
                {
                alt65=2;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt65=3;
                }
                break;
            case 62:
            case 63:
                {
                alt65=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3968:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3968:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3969:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3969:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3970:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8295);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3987:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3987:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3988:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3988:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3989:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8318); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4006:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4006:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4007:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4007:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4008:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8350);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4025:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4025:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4026:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4026:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4027:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4027:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==62) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==63) ) {
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4028:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,62,FOLLOW_62_in_ruleConstant8376); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4040:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,63,FOLLOW_63_in_ruleConstant8405); if (state.failed) return current;
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

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4063:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4064:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4065:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue8457);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue8467); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4072:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4075:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4076:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4076:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4077:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4077:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4078:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue8508); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4102:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4103:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4104:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier8549);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier8560); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4111:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4114:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4115:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4115:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            int alt66=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt66=1;
                }
                break;
            case RULE_VERSION:
                {
                alt66=2;
                }
                break;
            case RULE_EXPONENT:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4115:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier8600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier8626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4131:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier8652); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4146:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4147:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4148:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType8697);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType8707); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4155:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_set_1_0=null;
        Token lv_seq_3_0=null;
        Token lv_map_5_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_param_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4158:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4159:1: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4159:1: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt67=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt67=1;
                }
                break;
            case 64:
                {
                alt67=2;
                }
                break;
            case 65:
                {
                alt67=3;
                }
                break;
            case 66:
                {
                alt67=4;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4159:2: ( (lv_name_0_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4159:2: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4160:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4160:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4161:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameIdentifierParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleType8753);
                    lv_name_0_0=ruleIdentifier();

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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4178:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4178:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4178:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4178:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4179:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4179:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4180:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,64,FOLLOW_64_in_ruleType8778); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4193:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4194:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4194:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4195:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType8812);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4212:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4212:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4212:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4212:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4213:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4213:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4214:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,65,FOLLOW_65_in_ruleType8838); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4227:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4228:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4228:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4229:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType8872);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4246:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4246:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4246:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4246:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4247:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4247:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4248:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,66,FOLLOW_66_in_ruleType8898); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4261:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4262:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4262:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4263:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType8932);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4287:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4288:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4289:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters8969);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters8979); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4296:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_param_1_0 = null;

        AntlrDatatypeRuleToken lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4299:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4300:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4300:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4300:3: otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTypeParameters9016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4304:1: ( (lv_param_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4305:1: (lv_param_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4305:1: (lv_param_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4306:3: lv_param_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9037);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4322:2: (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==25) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4322:4: otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleTypeParameters9050); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4326:1: ( (lv_param_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:1: (lv_param_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:1: (lv_param_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:3: lv_param_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9071);
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
            	    break loop68;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTypeParameters9085); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4356:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4357:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4358:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9121);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9131); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4365:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4368:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4369:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4369:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4369:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4369:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4370:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer9180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4382:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_STRING && LA70_0<=RULE_EXPONENT)||LA70_0==16||LA70_0==18||LA70_0==29||(LA70_0>=31 && LA70_0<=32)||LA70_0==35||LA70_0==51||(LA70_0>=54 && LA70_0<=56)||LA70_0==58||(LA70_0>=62 && LA70_0<=63)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4382:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4382:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4383:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4383:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4384:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9202);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4400:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==25) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4400:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleContainerInitializer9215); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4404:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4405:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4405:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4406:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9236);
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
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleContainerInitializer9252); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4434:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4435:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4436:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9288);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression9298); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4443:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4446:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_EXPONENT)||LA71_0==16||LA71_0==29||(LA71_0>=31 && LA71_0<=32)||LA71_0==35||LA71_0==51||(LA71_0>=54 && LA71_0<=56)||LA71_0==58||(LA71_0>=62 && LA71_0<=63)) ) {
                alt71=1;
            }
            else if ( (LA71_0==18) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4447:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4448:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4448:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4449:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9344);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4466:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4466:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4467:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4467:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4468:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9371);
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


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA13_eotS =
        "\13\uffff";
    static final String DFA13_eofS =
        "\13\uffff";
    static final String DFA13_minS =
        "\1\4\1\uffff\3\20\1\uffff\1\4\3\5\1\27";
    static final String DFA13_maxS =
        "\1\77\1\uffff\3\75\1\uffff\1\102\3\75\1\73";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\5\uffff";
    static final String DFA13_specialS =
        "\13\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\5\1\3\1\5\1\2\1\4\7\uffff\1\5\7\uffff\1\5\1\uffff\1\1\2"+
            "\uffff\1\5\1\uffff\2\5\2\uffff\1\5\17\uffff\1\5\2\uffff\3\5"+
            "\1\uffff\1\5\3\uffff\2\5",
            "",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\1\5\1\uffff\1\5",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\1\5\1\uffff\1\5",
            "\1\6\7\uffff\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff"+
            "\1\5\1\uffff\1\5",
            "",
            "\1\5\1\10\1\5\1\7\1\11\7\uffff\1\5\1\12\1\5\12\uffff\1\5\1"+
            "\uffff\2\5\2\uffff\1\5\17\uffff\1\5\2\uffff\3\5\1\uffff\1\5"+
            "\3\uffff\2\5\3\1",
            "\1\1\1\uffff\2\1\7\uffff\2\5\5\uffff\1\5\1\uffff\1\5\15\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\1\5\1\uffff\1\5",
            "\1\1\1\uffff\2\1\7\uffff\2\5\5\uffff\1\5\1\uffff\1\5\15\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\1\5\1\uffff\1\5",
            "\1\1\1\uffff\2\1\7\uffff\2\5\5\uffff\1\5\1\uffff\1\5\15\uffff"+
            "\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\1\5\1\uffff\1\5",
            "\1\1\1\5\16\uffff\5\5\1\uffff\11\5\3\uffff\1\5\1\uffff\1\5"
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
    static final String DFA22_eotS =
        "\20\uffff";
    static final String DFA22_eofS =
        "\2\uffff\3\1\10\uffff\3\1";
    static final String DFA22_minS =
        "\1\4\1\uffff\3\16\6\uffff\1\5\1\uffff\3\16";
    static final String DFA22_maxS =
        "\1\77\1\uffff\3\75\6\uffff\1\10\1\uffff\3\75";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\3\uffff";
    static final String DFA22_specialS =
        "\20\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\14\uffff\1\11\1\uffff\1\7"+
            "\1\10\2\uffff\1\6\24\uffff\1\5\1\uffff\1\12\3\uffff\2\1",
            "",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\15\1\17",
            "",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13",
            "\1\1\1\uffff\1\14\3\1\4\uffff\2\1\15\uffff\5\1\1\uffff\11"+
            "\1\3\uffff\1\1\1\uffff\2\1\1\13"
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
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit470 = new BitSet(new long[]{0x00000000000201A0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit491 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit504 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_ruleLanguageUnit525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit538 = new BitSet(new long[]{0xC5C80059A52901F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit559 = new BitSet(new long[]{0xC5C80019A52901F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLoadProperties_in_ruleLanguageUnit581 = new BitSet(new long[]{0xC5C80019A52901F0L,0x0000000000000007L});
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
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleScriptContents968 = new BitSet(new long[]{0xC5C80019A50101F2L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_ruleScriptContents995 = new BitSet(new long[]{0xC5C80019A50101F2L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDeclaration1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1102 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1124 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRuleDeclaration1136 = new BitSet(new long[]{0x00000000000201A0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleRuleDeclaration1157 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleDeclaration1170 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleRuleDeclaration1182 = new BitSet(new long[]{0xC5C80009A10101F0L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1205 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleRuleDeclaration1218 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1240 = new BitSet(new long[]{0xC5C80009A20501F0L});
    public static final BitSet FOLLOW_25_in_ruleRuleDeclaration1253 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleDeclaration1274 = new BitSet(new long[]{0xC5C80009A20501F0L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1299 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRuleDeclaration1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElementBlock1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRuleElementBlock1409 = new BitSet(new long[]{0xC5C80019A80D01F0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1430 = new BitSet(new long[]{0xC5C80019A80D01F0L,0x0000000000000007L});
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
    public static final BitSet FOLLOW_16_in_ruleInstantiate2343 = new BitSet(new long[]{0xC5C80009A00701F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleInstantiate2364 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInstantiate2377 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleInstantiate2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_entryRuleMap2435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMap2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMap2482 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMap2494 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleMap2515 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_25_in_ruleMap2528 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleMap2549 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleMap2563 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMap2584 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMap2596 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleMap2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_entryRuleJoin2653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoin2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleJoin2700 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin2712 = new BitSet(new long[]{0x00000004000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin2733 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleJoin2745 = new BitSet(new long[]{0x00000004000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin2766 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin2778 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleJoin2791 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin2803 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoin2824 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable2874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoinVariable2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleJoinVariable2927 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJoinVariable2962 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleJoinVariable2974 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoinVariable2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemExecution3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleSystemExecution3078 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSystemExecution3099 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSystemExecution3120 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleVariableDeclaration3210 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3245 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3266 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3279 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3300 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVariableDeclaration3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAdvice3397 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAdvice3409 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice3430 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAdvice3442 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVersionSpec3547 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVersionSpec3559 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3580 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleVersionSpec3593 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3614 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleVersionSpec3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId3664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVersionedId3711 = new BitSet(new long[]{0x00000F8000000000L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_ruleVersionedId3732 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionedId3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleVersionOperator3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleVersionOperator3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleVersionOperator3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVersionOperator3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVersionOperator3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList3956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4012 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleParameterList4025 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4046 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4140 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVersionStmt4244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4261 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionStmt4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleImport4361 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4382 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4403 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleImport4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4509 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement4521 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement4544 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4767 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4788 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4881 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLogicalOperator4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLogicalOperator5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleLogicalOperator5026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5122 = new BitSet(new long[]{0x0003008000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5236 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleEqualityOperator5343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEqualityOperator5362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEqualityOperator5381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5477 = new BitSet(new long[]{0x00000F0000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5591 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleRelationalOperator5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRelationalOperator5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleRelationalOperator5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRelationalOperator5755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5851 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5872 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5965 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAdditiveOperator6072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAdditiveOperator6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6187 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6301 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleMultiplicativeOperator6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMultiplicativeOperator6427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6523 = new BitSet(new long[]{0xC5C80009A00101F0L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryOperator6631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator6669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6856 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionOrQualifiedExecution6875 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6896 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExpressionOrQualifiedExecution6908 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution6931 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution6968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7024 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7045 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSuperExecution7129 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleSuperExecution7141 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7162 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7183 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConstructorExecution7267 = new BitSet(new long[]{0x00000000000001A0L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7288 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstructorExecution7300 = new BitSet(new long[]{0xC5C80009A00701F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7321 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConstructorExecution7334 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7355 = new BitSet(new long[]{0x0A00000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSubCall7440 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSubCall7481 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7502 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleSubCall7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall7551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall7561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall7607 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCall7619 = new BitSet(new long[]{0xC5C80009A00701F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall7640 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCall7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList7689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList7699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList7745 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleArgumentList7758 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList7779 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument7817 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument7827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument7874 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedArgument7886 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument7909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix7945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix7955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8001 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleQualifiedPrefix8020 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8054 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8148 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQualifiedName8167 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleConstant8376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleConstant8405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue8457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue8467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue8508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier8549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier8560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier8600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier8626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier8652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType8697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType8707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleType8753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleType8778 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType8812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleType8838 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType8872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleType8898 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters8969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters8979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeParameters9016 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9037 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleTypeParameters9050 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9071 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeParameters9085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer9180 = new BitSet(new long[]{0xC5C80009A00D01F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9202 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleContainerInitializer9215 = new BitSet(new long[]{0xC5C80009A00501F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9236 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleContainerInitializer9252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression9298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression9344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression9371 = new BitSet(new long[]{0x0000000000000002L});

}