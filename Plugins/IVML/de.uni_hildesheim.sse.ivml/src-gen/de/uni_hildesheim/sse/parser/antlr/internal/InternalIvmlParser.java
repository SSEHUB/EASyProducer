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
import de.uni_hildesheim.sse.services.IvmlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalIvmlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'abstract'", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'::'", "'.'", "'true'", "'false'", "'self'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'attribute'", "'annotate'", "'freeze'", "'but'", "'|'", "'eval'", "'interface'", "'export'", "'import'", "'conflicts'", "'version'", "'def'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'->'", "'['", "']'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
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


        public InternalIvmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIvmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIvmlParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private IvmlGrammarAccess grammarAccess;
     	
        public InternalIvmlParser(TokenStream input, IvmlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "VariabilityUnit";	
       	}
       	
       	@Override
       	protected IvmlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleVariabilityUnit"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:73:1: entryRuleVariabilityUnit returns [EObject current=null] : iv_ruleVariabilityUnit= ruleVariabilityUnit EOF ;
    public final EObject entryRuleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariabilityUnit = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:74:2: (iv_ruleVariabilityUnit= ruleVariabilityUnit EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:75:2: iv_ruleVariabilityUnit= ruleVariabilityUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariabilityUnitRule()); 
            }
            pushFollow(FOLLOW_ruleVariabilityUnit_in_entryRuleVariabilityUnit81);
            iv_ruleVariabilityUnit=ruleVariabilityUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariabilityUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariabilityUnit91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariabilityUnit"


    // $ANTLR start "ruleVariabilityUnit"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:82:1: ruleVariabilityUnit returns [EObject current=null] : ( () ( (lv_projects_1_0= ruleProject ) )* ) ;
    public final EObject ruleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_projects_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:85:28: ( ( () ( (lv_projects_1_0= ruleProject ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:86:2: () ( (lv_projects_1_0= ruleProject ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:86:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariabilityUnitAccess().getVariabilityUnitAction_0(),
                          current);
                  
            }

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:95:2: ( (lv_projects_1_0= ruleProject ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:97:3: lv_projects_1_0= ruleProject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariabilityUnitAccess().getProjectsProjectParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProject_in_ruleVariabilityUnit149);
            	    lv_projects_1_0=ruleProject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariabilityUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"projects",
            	              		lv_projects_1_0, 
            	              		"Project");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleVariabilityUnit"


    // $ANTLR start "entryRuleProject"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:121:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:122:2: (iv_ruleProject= ruleProject EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:123:2: iv_ruleProject= ruleProject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectRule()); 
            }
            pushFollow(FOLLOW_ruleProject_in_entryRuleProject186);
            iv_ruleProject=ruleProject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProject; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProject196); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:130:1: ruleProject returns [EObject current=null] : (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_3_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_conflicts_5_0 = null;

        EObject lv_interfaces_6_0 = null;

        EObject lv_contents_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:133:28: ( (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:134:3: otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleProject233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:138:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:140:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleProject254);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProjectRule());
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleProject266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:160:1: ( (lv_version_3_0= ruleVersionStmt ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==53) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_VERSION) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==16) ) {
                        int LA2_4 = input.LA(4);

                        if ( (synpred2_InternalIvml()) ) {
                            alt2=1;
                        }
                    }
                }
            }
            switch (alt2) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionStmt_in_ruleProject287);
                    lv_version_3_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProjectRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_3_0, 
                              		"VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:178:3: ( (lv_imports_4_0= ruleImportStmt ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==51) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:180:3: lv_imports_4_0= ruleImportStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getImportsImportStmtParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportStmt_in_ruleProject309);
            	    lv_imports_4_0=ruleImportStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_4_0, 
            	              		"ImportStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:196:3: ( (lv_conflicts_5_0= ruleConflictStmt ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==52) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:198:3: lv_conflicts_5_0= ruleConflictStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getConflictsConflictStmtParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConflictStmt_in_ruleProject331);
            	    lv_conflicts_5_0=ruleConflictStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"conflicts",
            	              		lv_conflicts_5_0, 
            	              		"ConflictStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:214:3: ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==49) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:216:3: lv_interfaces_6_0= ruleInterfaceDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getInterfacesInterfaceDeclarationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleInterfaceDeclaration_in_ruleProject353);
            	    lv_interfaces_6_0=ruleInterfaceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"interfaces",
            	              		lv_interfaces_6_0, 
            	              		"InterfaceDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:232:3: ( (lv_contents_7_0= ruleProjectContents ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:234:3: lv_contents_7_0= ruleProjectContents
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getContentsProjectContentsParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleProjectContents_in_ruleProject375);
            lv_contents_7_0=ruleProjectContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProjectRule());
              	        }
                     		set(
                     			current, 
                     			"contents",
                      		lv_contents_7_0, 
                      		"ProjectContents");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleProject387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:254:1: (otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:254:3: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleProject400); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getProjectAccess().getSemicolonKeyword_9());
                          
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
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleProjectContents"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:266:1: entryRuleProjectContents returns [EObject current=null] : iv_ruleProjectContents= ruleProjectContents EOF ;
    public final EObject entryRuleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectContents = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:267:2: (iv_ruleProjectContents= ruleProjectContents EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:268:2: iv_ruleProjectContents= ruleProjectContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectContentsRule()); 
            }
            pushFollow(FOLLOW_ruleProjectContents_in_entryRuleProjectContents438);
            iv_ruleProjectContents=ruleProjectContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProjectContents; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProjectContents448); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectContents"


    // $ANTLR start "ruleProjectContents"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:275:1: ruleProjectContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) ;
    public final EObject ruleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:278:28: ( ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:2: () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:280:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getProjectContentsAccess().getProjectContentsAction_0(),
                          current);
                  
            }

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            loop7:
            do {
                int alt7=9;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:290:3: lv_elements_1_0= ruleTypedef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsTypedefParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypedef_in_ruleProjectContents507);
            	    lv_elements_1_0=ruleTypedef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_1_0, 
            	              		"Typedef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:309:3: lv_elements_2_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsVariableDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleProjectContents534);
            	    lv_elements_2_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:328:3: lv_elements_3_0= ruleFreeze
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsFreezeParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFreeze_in_ruleProjectContents561);
            	    lv_elements_3_0=ruleFreeze();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"Freeze");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:347:3: lv_elements_4_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsEvalParserRuleCall_1_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEval_in_ruleProjectContents588);
            	    lv_elements_4_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_4_0, 
            	              		"Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:366:3: lv_elements_5_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsExpressionStatementParserRuleCall_1_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleProjectContents615);
            	    lv_elements_5_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_5_0, 
            	              		"ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:385:3: lv_elements_6_0= ruleAnnotateTo
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAnnotateToParserRuleCall_1_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnotateTo_in_ruleProjectContents642);
            	    lv_elements_6_0=ruleAnnotateTo();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_6_0, 
            	              		"AnnotateTo");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:404:3: lv_elements_7_0= ruleOpDefStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsOpDefStatementParserRuleCall_1_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpDefStatement_in_ruleProjectContents669);
            	    lv_elements_7_0=ruleOpDefStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_7_0, 
            	              		"OpDefStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:423:3: lv_elements_8_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAttrAssignmentParserRuleCall_1_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignment_in_ruleProjectContents696);
            	    lv_elements_8_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // $ANTLR end "ruleProjectContents"


    // $ANTLR start "entryRuleTypedef"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:447:1: entryRuleTypedef returns [EObject current=null] : iv_ruleTypedef= ruleTypedef EOF ;
    public final EObject entryRuleTypedef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedef = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:448:2: (iv_ruleTypedef= ruleTypedef EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:449:2: iv_ruleTypedef= ruleTypedef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefRule()); 
            }
            pushFollow(FOLLOW_ruleTypedef_in_entryRuleTypedef734);
            iv_ruleTypedef=ruleTypedef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedef744); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedef"


    // $ANTLR start "ruleTypedef"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:456:1: ruleTypedef returns [EObject current=null] : ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) ;
    public final EObject ruleTypedef() throws RecognitionException {
        EObject current = null;

        EObject lv_tEnum_0_0 = null;

        EObject lv_tCompound_1_0 = null;

        EObject lv_tMapping_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:459:28: ( ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 20:
            case 21:
                {
                alt8=2;
                }
                break;
            case 27:
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:462:3: lv_tEnum_0_0= ruleTypedefEnum
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTEnumTypedefEnumParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefEnum_in_ruleTypedef790);
                    lv_tEnum_0_0=ruleTypedefEnum();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tEnum",
                              		lv_tEnum_0_0, 
                              		"TypedefEnum");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:481:3: lv_tCompound_1_0= ruleTypedefCompound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTCompoundTypedefCompoundParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefCompound_in_ruleTypedef817);
                    lv_tCompound_1_0=ruleTypedefCompound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tCompound",
                              		lv_tCompound_1_0, 
                              		"TypedefCompound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:500:3: lv_tMapping_2_0= ruleTypedefMapping
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTMappingTypedefMappingParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefMapping_in_ruleTypedef844);
                    lv_tMapping_2_0=ruleTypedefMapping();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tMapping",
                              		lv_tMapping_2_0, 
                              		"TypedefMapping");
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
    // $ANTLR end "ruleTypedef"


    // $ANTLR start "entryRuleTypedefEnum"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:524:1: entryRuleTypedefEnum returns [EObject current=null] : iv_ruleTypedefEnum= ruleTypedefEnum EOF ;
    public final EObject entryRuleTypedefEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnum = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:525:2: (iv_ruleTypedefEnum= ruleTypedefEnum EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:526:2: iv_ruleTypedefEnum= ruleTypedefEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefEnum_in_entryRuleTypedefEnum880);
            iv_ruleTypedefEnum=ruleTypedefEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnum; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefEnum890); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefEnum"


    // $ANTLR start "ruleTypedefEnum"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:533:1: ruleTypedefEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) ;
    public final EObject ruleTypedefEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;

        EObject lv_constraint_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:536:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:537:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleTypedefEnum927); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefEnumAccess().getEnumKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:541:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:543:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefEnum948);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleTypedefEnum960); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypedefEnumAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:563:1: ( (lv_literals_3_0= ruleTypedefEnumLiteral ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:565:3: lv_literals_3_0= ruleTypedefEnumLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum981);
            lv_literals_3_0=ruleTypedefEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
              	        }
                     		add(
                     			current, 
                     			"literals",
                      		lv_literals_3_0, 
                      		"TypedefEnumLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:581:2: (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:581:4: otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTypedefEnum994); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getTypedefEnumAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:585:1: ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:587:3: lv_literals_5_0= ruleTypedefEnumLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum1015);
            	    lv_literals_5_0=ruleTypedefEnumLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"literals",
            	              		lv_literals_5_0, 
            	              		"TypedefEnumLiteral");
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

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleTypedefEnum1029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTypedefEnumAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:607:1: ( (lv_constraint_7_0= ruleTypedefConstraint ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:609:3: lv_constraint_7_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getConstraintTypedefConstraintParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefConstraint_in_ruleTypedefEnum1050);
                    lv_constraint_7_0=ruleTypedefConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
                      	        }
                             		set(
                             			current, 
                             			"constraint",
                              		lv_constraint_7_0, 
                              		"TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleTypedefEnum1063); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getTypedefEnumAccess().getSemicolonKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefEnum"


    // $ANTLR start "entryRuleTypedefEnumLiteral"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:637:1: entryRuleTypedefEnumLiteral returns [EObject current=null] : iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF ;
    public final EObject entryRuleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnumLiteral = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:638:2: (iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:639:2: iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefEnumLiteral_in_entryRuleTypedefEnumLiteral1099);
            iv_ruleTypedefEnumLiteral=ruleTypedefEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnumLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefEnumLiteral1109); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefEnumLiteral"


    // $ANTLR start "ruleTypedefEnumLiteral"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:646:1: ruleTypedefEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) ;
    public final EObject ruleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:649:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:652:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefEnumLiteral1155);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumLiteralRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:668:2: (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:668:4: otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleTypedefEnumLiteral1168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedefEnumLiteralAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:672:1: ( (lv_value_2_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:674:3: lv_value_2_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getValueNumValueParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleTypedefEnumLiteral1189);
                    lv_value_2_0=ruleNumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefEnumLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"NumValue");
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
    // $ANTLR end "ruleTypedefEnumLiteral"


    // $ANTLR start "entryRuleTypedefCompound"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:698:1: entryRuleTypedefCompound returns [EObject current=null] : iv_ruleTypedefCompound= ruleTypedefCompound EOF ;
    public final EObject entryRuleTypedefCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefCompound = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:699:2: (iv_ruleTypedefCompound= ruleTypedefCompound EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:700:2: iv_ruleTypedefCompound= ruleTypedefCompound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefCompoundRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefCompound_in_entryRuleTypedefCompound1227);
            iv_ruleTypedefCompound=ruleTypedefCompound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefCompound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefCompound1237); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefCompound"


    // $ANTLR start "ruleTypedefCompound"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:707:1: ruleTypedefCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* otherlv_9= '}' (otherlv_10= ';' )? ) ;
    public final EObject ruleTypedefCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:710:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* otherlv_9= '}' (otherlv_10= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* otherlv_9= '}' (otherlv_10= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* otherlv_9= '}' (otherlv_10= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* otherlv_9= '}' (otherlv_10= ';' )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:713:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,20,FOLLOW_20_in_ruleTypedefCompound1280); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_abstract_0_0, grammarAccess.getTypedefCompoundAccess().getAbstractAbstractKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypedefCompoundRule());
                      	        }
                             		setWithLastConsumed(current, "abstract", lv_abstract_0_0, "abstract");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleTypedefCompound1306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefCompoundAccess().getCompoundKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:730:1: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:732:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefCompound1327);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:748:2: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:748:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleTypedefCompound1340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedefCompoundAccess().getRefinesKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:752:1: ( (lv_super_4_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:754:3: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefCompound1361);
                    lv_super_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                      	        }
                             		set(
                             			current, 
                             			"super",
                              		lv_super_4_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleTypedefCompound1375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTypedefCompoundAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:774:1: ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            loop14:
            do {
                int alt14=4;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:774:2: ( (lv_elements_6_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:774:2: ( (lv_elements_6_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:775:1: (lv_elements_6_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:775:1: (lv_elements_6_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:776:3: lv_elements_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleTypedefCompound1397);
            	    lv_elements_6_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_6_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:793:6: ( (lv_elements_7_0= ruleExpressionStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:793:6: ( (lv_elements_7_0= ruleExpressionStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:794:1: (lv_elements_7_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:794:1: (lv_elements_7_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:795:3: lv_elements_7_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleTypedefCompound1424);
            	    lv_elements_7_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_7_0, 
            	              		"ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:812:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:812:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:813:1: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:813:1: (lv_elements_8_0= ruleAttrAssignment )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:814:3: lv_elements_8_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsAttrAssignmentParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignment_in_ruleTypedefCompound1451);
            	    lv_elements_8_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleTypedefCompound1465); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getTypedefCompoundAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:834:1: (otherlv_10= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==16) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:834:3: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleTypedefCompound1478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_7());
                          
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
    // $ANTLR end "ruleTypedefCompound"


    // $ANTLR start "entryRuleAttrAssignment"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:846:1: entryRuleAttrAssignment returns [EObject current=null] : iv_ruleAttrAssignment= ruleAttrAssignment EOF ;
    public final EObject entryRuleAttrAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignment = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:847:2: (iv_ruleAttrAssignment= ruleAttrAssignment EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:848:2: iv_ruleAttrAssignment= ruleAttrAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAttrAssignment_in_entryRuleAttrAssignment1516);
            iv_ruleAttrAssignment=ruleAttrAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrAssignment1526); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrAssignment"


    // $ANTLR start "ruleAttrAssignment"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:855:1: ruleAttrAssignment returns [EObject current=null] : (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) ;
    public final EObject ruleAttrAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_parts_2_0 = null;

        EObject lv_parts_4_0 = null;

        EObject lv_elements_8_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:858:28: ( (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:859:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:859:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:859:3: otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleAttrAssignment1563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAssignmentAccess().getAssignKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleAttrAssignment1575); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:867:1: ( (lv_parts_2_0= ruleAttrAssignmentPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:868:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:868:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:869:3: lv_parts_2_0= ruleAttrAssignmentPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1596);
            lv_parts_2_0=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
              	        }
                     		add(
                     			current, 
                     			"parts",
                      		lv_parts_2_0, 
                      		"AttrAssignmentPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:885:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==18) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:885:4: otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleAttrAssignment1609); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getAttrAssignmentAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:889:1: ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:890:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:890:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:891:3: lv_parts_4_0= ruleAttrAssignmentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1630);
            	    lv_parts_4_0=ruleAttrAssignmentPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_4_0, 
            	              		"AttrAssignmentPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAttrAssignment1644); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAttrAssignmentAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleAttrAssignment1656); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAttrAssignmentAccess().getToKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleAttrAssignment1668); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAttrAssignmentAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:919:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:919:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:919:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:920:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:920:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:921:3: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleAttrAssignment1690);
            	    lv_elements_8_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:938:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:938:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:939:1: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:939:1: (lv_elements_9_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:940:3: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleAttrAssignment1717);
            	    lv_elements_9_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_9_0, 
            	              		"ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:957:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:957:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:958:1: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:958:1: (lv_elements_10_0= ruleAttrAssignment )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:959:3: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsAttrAssignmentParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignment_in_ruleAttrAssignment1744);
            	    lv_elements_10_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_10_0, 
            	              		"AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleAttrAssignment1758); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAttrAssignmentAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:979:1: (otherlv_12= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==16) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:979:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleAttrAssignment1771); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getAttrAssignmentAccess().getSemicolonKeyword_9());
                          
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
    // $ANTLR end "ruleAttrAssignment"


    // $ANTLR start "entryRuleAttrAssignmentPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:991:1: entryRuleAttrAssignmentPart returns [EObject current=null] : iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF ;
    public final EObject entryRuleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignmentPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:992:2: (iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:993:2: iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentPartRule()); 
            }
            pushFollow(FOLLOW_ruleAttrAssignmentPart_in_entryRuleAttrAssignmentPart1809);
            iv_ruleAttrAssignmentPart=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignmentPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrAssignmentPart1819); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrAssignmentPart"


    // $ANTLR start "ruleAttrAssignmentPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1000:1: ruleAttrAssignmentPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) ;
    public final EObject ruleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1003:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1004:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1004:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1004:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1004:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1005:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1005:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1006:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleAttrAssignmentPart1865);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentPartRule());
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

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleAttrAssignmentPart1877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentPartAccess().getEqualsSignKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1026:1: ( (lv_value_2_0= ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1027:1: (lv_value_2_0= ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1027:1: (lv_value_2_0= ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1028:3: lv_value_2_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getValueLogicalExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAttrAssignmentPart1898);
            lv_value_2_0=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentPartRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"LogicalExpression");
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
    // $ANTLR end "ruleAttrAssignmentPart"


    // $ANTLR start "entryRuleTypedefMapping"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1052:1: entryRuleTypedefMapping returns [EObject current=null] : iv_ruleTypedefMapping= ruleTypedefMapping EOF ;
    public final EObject entryRuleTypedefMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefMapping = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1053:2: (iv_ruleTypedefMapping= ruleTypedefMapping EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1054:2: iv_ruleTypedefMapping= ruleTypedefMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefMappingRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefMapping_in_entryRuleTypedefMapping1934);
            iv_ruleTypedefMapping=ruleTypedefMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefMapping; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefMapping1944); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefMapping"


    // $ANTLR start "ruleTypedefMapping"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1061:1: ruleTypedefMapping returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) ;
    public final EObject ruleTypedefMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newType_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_constraint_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1064:28: ( (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1065:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1065:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1065:3: otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTypedefMapping1981); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefMappingAccess().getTypedefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1069:1: ( (lv_newType_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1070:1: (lv_newType_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1070:1: (lv_newType_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1071:3: lv_newType_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getNewTypeIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefMapping2002);
            lv_newType_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
              	        }
                     		set(
                     			current, 
                     			"newType",
                      		lv_newType_1_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1087:2: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1088:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1088:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1089:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypedefMapping2023);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1105:2: ( (lv_constraint_3_0= ruleTypedefConstraint ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1106:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1106:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1107:3: lv_constraint_3_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getConstraintTypedefConstraintParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefConstraint_in_ruleTypedefMapping2044);
                    lv_constraint_3_0=ruleTypedefConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
                      	        }
                             		set(
                             			current, 
                             			"constraint",
                              		lv_constraint_3_0, 
                              		"TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleTypedefMapping2057); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTypedefMappingAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefMapping"


    // $ANTLR start "entryRuleTypedefConstraint"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1135:1: entryRuleTypedefConstraint returns [EObject current=null] : iv_ruleTypedefConstraint= ruleTypedefConstraint EOF ;
    public final EObject entryRuleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefConstraint = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1136:2: (iv_ruleTypedefConstraint= ruleTypedefConstraint EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1137:2: iv_ruleTypedefConstraint= ruleTypedefConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefConstraint_in_entryRuleTypedefConstraint2093);
            iv_ruleTypedefConstraint=ruleTypedefConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefConstraint2103); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefConstraint"


    // $ANTLR start "ruleTypedefConstraint"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1144:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1147:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleTypedefConstraint2140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefConstraintAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTypedefConstraint2152); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefConstraintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1156:1: ( (lv_expressions_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1157:1: (lv_expressions_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1157:1: (lv_expressions_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1158:3: lv_expressions_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleTypedefConstraint2173);
            lv_expressions_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"expressions",
                      		lv_expressions_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleTypedefConstraint2185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypedefConstraintAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefConstraint"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1186:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1187:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1188:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2221);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2231); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1195:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1198:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1199:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1199:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1199:2: ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1199:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1200:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1200:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1201:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration2277);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1217:2: ( (lv_decls_1_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1218:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1218:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1219:3: lv_decls_1_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2298);
            lv_decls_1_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"decls",
                      		lv_decls_1_0, 
                      		"VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1235:2: (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==18) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1235:4: otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVariableDeclaration2311); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1239:1: ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1240:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1240:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1241:3: lv_decls_3_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2332);
            	    lv_decls_3_0=ruleVariableDeclarationPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decls",
            	              		lv_decls_3_0, 
            	              		"VariableDeclarationPart");
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleVariableDeclaration2346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleVariableDeclarationPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1269:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1270:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1271:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationPartRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2382);
            iv_ruleVariableDeclarationPart=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclarationPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationPart2392); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclarationPart"


    // $ANTLR start "ruleVariableDeclarationPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1278:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1281:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1282:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1282:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1282:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1282:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1283:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1283:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1284:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2438);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationPartRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1300:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1300:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleVariableDeclarationPart2451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1304:1: ( (lv_default_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1305:1: (lv_default_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1305:1: (lv_default_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1306:3: lv_default_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getDefaultExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2472);
                    lv_default_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationPartRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_2_0, 
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
    // $ANTLR end "ruleVariableDeclarationPart"


    // $ANTLR start "entryRuleBasicType"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1330:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1331:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1332:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType2510);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType2520); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1339:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1342:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1343:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1343:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            int alt22=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt22=1;
                }
                break;
            case 30:
                {
                alt22=2;
                }
                break;
            case 31:
                {
                alt22=3;
                }
                break;
            case 32:
                {
                alt22=4;
                }
                break;
            case 33:
                {
                alt22=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1343:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1343:2: ( (lv_type_0_0= 'Integer' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1344:1: (lv_type_0_0= 'Integer' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1344:1: (lv_type_0_0= 'Integer' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1345:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,29,FOLLOW_29_in_ruleBasicType2563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_0, grammarAccess.getBasicTypeAccess().getTypeIntegerKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_0, "Integer");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1359:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1359:6: ( (lv_type_1_0= 'Real' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1360:1: (lv_type_1_0= 'Real' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1360:1: (lv_type_1_0= 'Real' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1361:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,30,FOLLOW_30_in_ruleBasicType2600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_1_0, grammarAccess.getBasicTypeAccess().getTypeRealKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_1_0, "Real");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1375:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1375:6: ( (lv_type_2_0= 'Boolean' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1376:1: (lv_type_2_0= 'Boolean' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1376:1: (lv_type_2_0= 'Boolean' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1377:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,31,FOLLOW_31_in_ruleBasicType2637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_2_0, grammarAccess.getBasicTypeAccess().getTypeBooleanKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_2_0, "Boolean");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1391:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1391:6: ( (lv_type_3_0= 'String' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1392:1: (lv_type_3_0= 'String' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1392:1: (lv_type_3_0= 'String' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1393:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,32,FOLLOW_32_in_ruleBasicType2674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_3_0, grammarAccess.getBasicTypeAccess().getTypeStringKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_3_0, "String");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1407:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1407:6: ( (lv_type_4_0= 'Constraint' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1408:1: (lv_type_4_0= 'Constraint' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1408:1: (lv_type_4_0= 'Constraint' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1409:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,33,FOLLOW_33_in_ruleBasicType2711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_4_0, grammarAccess.getBasicTypeAccess().getTypeConstraintKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_4_0, "Constraint");
                      	    
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
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleType"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1430:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1431:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1432:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType2760);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType2770); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1439:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1442:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1443:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1443:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt23=1;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 53:
                {
                alt23=2;
                }
                break;
            case 40:
            case 41:
            case 42:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1443:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1443:2: ( (lv_type_0_0= ruleBasicType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1444:1: (lv_type_0_0= ruleBasicType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1444:1: (lv_type_0_0= ruleBasicType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1445:3: lv_type_0_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeBasicTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_ruleType2816);
                    lv_type_0_0=ruleBasicType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_0_0, 
                              		"BasicType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1462:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1462:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1463:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1463:1: (lv_id_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1464:3: lv_id_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getIdQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleType2843);
                    lv_id_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"id",
                              		lv_id_1_0, 
                              		"QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1481:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1481:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1482:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1482:1: (lv_derived_2_0= ruleDerivedType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1483:3: lv_derived_2_0= ruleDerivedType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getDerivedDerivedTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDerivedType_in_ruleType2870);
                    lv_derived_2_0=ruleDerivedType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"derived",
                              		lv_derived_2_0, 
                              		"DerivedType");
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleNumValue"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1507:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1508:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1509:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue2906);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue2916); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1516:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1519:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1520:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1520:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1521:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1521:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1522:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue2957); if (state.failed) return current;
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1546:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1547:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1548:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2997);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3007); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1555:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1558:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
            int alt25=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==34) ) {
                        alt25=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==34) ) {
                        alt25=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA25_3 = input.LA(2);

                    if ( (LA25_3==34) ) {
                        alt25=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA25_4 = input.LA(2);

                    if ( (LA25_4==34) ) {
                        alt25=1;
                    }
                    }
                    break;
            }

            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1559:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1560:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1560:1: (lv_qName_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1561:3: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3054);
                    lv_qName_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                      	        }
                             		add(
                             			current, 
                             			"qName",
                              		lv_qName_0_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1577:2: ( (lv_qName_1_0= '::' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1578:1: (lv_qName_1_0= '::' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1578:1: (lv_qName_1_0= '::' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1579:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qName_1_0, grammarAccess.getQualifiedNameAccess().getQNameColonColonKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getQualifiedNameRule());
                      	        }
                             		addWithLastConsumed(current, "qName", lv_qName_1_0, "::");
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1592:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA24_1 = input.LA(2);

                            if ( (LA24_1==34) ) {
                                alt24=1;
                            }


                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA24_2 = input.LA(2);

                            if ( (LA24_2==34) ) {
                                alt24=1;
                            }


                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA24_3 = input.LA(2);

                            if ( (LA24_3==34) ) {
                                alt24=1;
                            }


                            }
                            break;
                        case 53:
                            {
                            int LA24_4 = input.LA(2);

                            if ( (LA24_4==34) ) {
                                alt24=1;
                            }


                            }
                            break;

                        }

                        switch (alt24) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1592:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1592:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1593:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1593:1: (lv_qName_2_0= ruleIdentifier )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1594:3: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3107);
                    	    lv_qName_2_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"qName",
                    	              		lv_qName_2_0, 
                    	              		"Identifier");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1610:2: ( (lv_qName_3_0= '::' ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1611:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1611:1: (lv_qName_3_0= '::' )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1612:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3125); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              newLeafNode(lv_qName_3_0, grammarAccess.getQualifiedNameAccess().getQNameColonColonKeyword_0_2_1_0());
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getQualifiedNameRule());
                    	      	        }
                    	             		addWithLastConsumed(current, "qName", lv_qName_3_0, "::");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1625:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1626:1: (lv_qName_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1626:1: (lv_qName_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1627:3: lv_qName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3163);
            lv_qName_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
              	        }
                     		add(
                     			current, 
                     			"qName",
                      		lv_qName_4_0, 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleAccessName"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1651:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1652:2: (iv_ruleAccessName= ruleAccessName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1653:2: iv_ruleAccessName= ruleAccessName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessNameRule()); 
            }
            pushFollow(FOLLOW_ruleAccessName_in_entryRuleAccessName3199);
            iv_ruleAccessName=ruleAccessName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessName3209); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessName"


    // $ANTLR start "ruleAccessName"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1660:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1663:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1664:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1664:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==35) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1664:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1664:2: ( (lv_aName_0_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1665:1: (lv_aName_0_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1665:1: (lv_aName_0_0= '.' )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1666:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,35,FOLLOW_35_in_ruleAccessName3252); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_aName_0_0, grammarAccess.getAccessNameAccess().getANameFullStopKeyword_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessNameRule());
            	      	        }
            	             		addWithLastConsumed(current, "aName", lv_aName_0_0, ".");
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1679:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1680:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1680:1: (lv_aName_1_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1681:3: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAccessName3286);
            	    lv_aName_1_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessNameRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"aName",
            	              		lv_aName_1_0, 
            	              		"Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessName"


    // $ANTLR start "entryRuleValue"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1705:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1706:2: (iv_ruleValue= ruleValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1707:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue3323);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue3333); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1714:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token lv_self_4_0=null;
        Token lv_nullValue_5_0=null;
        Token lv_version_6_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1717:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1718:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1718:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            int alt28=7;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt28=1;
                }
                break;
            case RULE_STRING:
                {
                alt28=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 53:
                {
                alt28=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA28_4 = input.LA(2);

                if ( (synpred45_InternalIvml()) ) {
                    alt28=3;
                }
                else if ( (synpred50_InternalIvml()) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 4, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
                {
                alt28=4;
                }
                break;
            case 38:
                {
                alt28=5;
                }
                break;
            case 39:
                {
                alt28=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1718:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1718:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1719:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1719:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1720:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleValue3379);
                    lv_nValue_0_0=ruleNumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1737:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1737:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1738:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1738:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1739:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValue3402); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sValue_1_0, grammarAccess.getValueAccess().getSValueSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1756:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1756:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1757:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1757:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1758:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleValue3434);
                    lv_qValue_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1775:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1775:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1776:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1776:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1777:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1777:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==36) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==37) ) {
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
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,36,FOLLOW_36_in_ruleValue3460); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_1, grammarAccess.getValueAccess().getBValueTrueKeyword_3_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueRule());
                              	        }
                                     		setWithLastConsumed(current, "bValue", lv_bValue_3_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1790:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,37,FOLLOW_37_in_ruleValue3489); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_2, grammarAccess.getValueAccess().getBValueFalseKeyword_3_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueRule());
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1806:6: ( (lv_self_4_0= 'self' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1806:6: ( (lv_self_4_0= 'self' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1807:1: (lv_self_4_0= 'self' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1807:1: (lv_self_4_0= 'self' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1808:3: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,38,FOLLOW_38_in_ruleValue3529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_self_4_0, grammarAccess.getValueAccess().getSelfSelfKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "self", lv_self_4_0, "self");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1822:6: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1822:6: ( (lv_nullValue_5_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1823:1: (lv_nullValue_5_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1823:1: (lv_nullValue_5_0= 'null' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1824:3: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,39,FOLLOW_39_in_ruleValue3566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_nullValue_5_0, grammarAccess.getValueAccess().getNullValueNullKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "nullValue", lv_nullValue_5_0, "null");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1838:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1838:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1838:7: ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1844:1: (lv_version_6_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1845:3: lv_version_6_0= RULE_VERSION
                    {
                    lv_version_6_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleValue3613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_version_6_0, grammarAccess.getValueAccess().getVersionVERSIONTerminalRuleCall_6_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"version",
                              		lv_version_6_0, 
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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleDerivedType"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1869:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1870:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1871:2: iv_ruleDerivedType= ruleDerivedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerivedTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDerivedType_in_entryRuleDerivedType3654);
            iv_ruleDerivedType=ruleDerivedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDerivedType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDerivedType3664); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDerivedType"


    // $ANTLR start "ruleDerivedType"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1878:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
    public final EObject ruleDerivedType() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        Token lv_op_1_0=null;
        Token lv_op_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1881:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt29=1;
                }
                break;
            case 41:
                {
                alt29=2;
                }
                break;
            case 42:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:3: ( (lv_op_0_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1883:1: (lv_op_0_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1883:1: (lv_op_0_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1884:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,40,FOLLOW_40_in_ruleDerivedType3708); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_0_0, grammarAccess.getDerivedTypeAccess().getOpSetOfKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_0_0, "setOf");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1898:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1898:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1899:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1899:1: (lv_op_1_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1900:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,41,FOLLOW_41_in_ruleDerivedType3745); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_1_0, grammarAccess.getDerivedTypeAccess().getOpSequenceOfKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_1_0, "sequenceOf");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1914:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1914:6: ( (lv_op_2_0= 'refTo' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1915:1: (lv_op_2_0= 'refTo' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1915:1: (lv_op_2_0= 'refTo' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1916:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,42,FOLLOW_42_in_ruleDerivedType3782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getDerivedTypeAccess().getOpRefToKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "refTo");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDerivedType3808); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1933:1: ( (lv_type_4_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1934:1: (lv_type_4_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1934:1: (lv_type_4_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1935:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleDerivedType3829);
            lv_type_4_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDerivedTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_4_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleDerivedType3841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDerivedTypeAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDerivedType"


    // $ANTLR start "entryRuleAnnotateTo"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1963:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1964:2: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1965:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotateToRule()); 
            }
            pushFollow(FOLLOW_ruleAnnotateTo_in_entryRuleAnnotateTo3877);
            iv_ruleAnnotateTo=ruleAnnotateTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotateTo; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotateTo3887); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotateTo"


    // $ANTLR start "ruleAnnotateTo"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1972:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleAnnotateTo() throws RecognitionException {
        EObject current = null;

        Token lv_sname_0_1=null;
        Token lv_sname_0_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotationType_1_0 = null;

        EObject lv_annotationDecl_2_0 = null;

        AntlrDatatypeRuleToken lv_names_4_0 = null;

        AntlrDatatypeRuleToken lv_names_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1975:28: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1976:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1976:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1976:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1976:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1977:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1977:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1978:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1978:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==43) ) {
                alt30=1;
            }
            else if ( (LA30_0==44) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1979:3: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,43,FOLLOW_43_in_ruleAnnotateTo3932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sname_0_1, grammarAccess.getAnnotateToAccess().getSnameAttributeKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAnnotateToRule());
                      	        }
                             		setWithLastConsumed(current, "sname", lv_sname_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1991:8: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,44,FOLLOW_44_in_ruleAnnotateTo3961); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sname_0_2, grammarAccess.getAnnotateToAccess().getSnameAnnotateKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAnnotateToRule());
                      	        }
                             		setWithLastConsumed(current, "sname", lv_sname_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2006:2: ( (lv_annotationType_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2007:1: (lv_annotationType_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2007:1: (lv_annotationType_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2008:3: lv_annotationType_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleAnnotateTo3998);
            lv_annotationType_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
              	        }
                     		set(
                     			current, 
                     			"annotationType",
                      		lv_annotationType_1_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2024:2: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2025:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2025:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2026:3: lv_annotationDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationDeclVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleAnnotateTo4019);
            lv_annotationDecl_2_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
              	        }
                     		set(
                     			current, 
                     			"annotationDecl",
                      		lv_annotationDecl_2_0, 
                      		"VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleAnnotateTo4031); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAnnotateToAccess().getToKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2046:1: ( (lv_names_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2047:1: (lv_names_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2047:1: (lv_names_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2048:3: lv_names_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleAnnotateTo4052);
            lv_names_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
              	        }
                     		add(
                     			current, 
                     			"names",
                      		lv_names_4_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2064:2: (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2064:4: otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleAnnotateTo4065); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAnnotateToAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2068:1: ( (lv_names_6_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2069:1: (lv_names_6_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2069:1: (lv_names_6_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2070:3: lv_names_6_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAnnotateTo4086);
            	    lv_names_6_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_6_0, 
            	              		"Identifier");
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

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleAnnotateTo4100); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAnnotateToAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotateTo"


    // $ANTLR start "entryRuleFreeze"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2098:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2099:2: (iv_ruleFreeze= ruleFreeze EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2100:2: iv_ruleFreeze= ruleFreeze EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeRule()); 
            }
            pushFollow(FOLLOW_ruleFreeze_in_entryRuleFreeze4136);
            iv_ruleFreeze=ruleFreeze();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreeze; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeze4146); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreeze"


    // $ANTLR start "ruleFreeze"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2107:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
    public final EObject ruleFreeze() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_names_2_0 = null;

        AntlrDatatypeRuleToken lv_id_6_0 = null;

        EObject lv_ex_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2110:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2111:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2111:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2111:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleFreeze4183); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleFreeze4195); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2119:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_VERSION && LA32_0<=RULE_EXPONENT)||LA32_0==53) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2120:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2120:1: (lv_names_2_0= ruleFreezeStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2121:3: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFreezeStatement_in_ruleFreeze4216);
            	    lv_names_2_0=ruleFreezeStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_2_0, 
            	              		"FreezeStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleFreeze4229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2141:1: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2141:3: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleFreeze4242); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleFreeze4254); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2149:1: ( (lv_id_6_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2150:1: (lv_id_6_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2150:1: (lv_id_6_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2151:3: lv_id_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getIdIdentifierParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleFreeze4275);
                    lv_id_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
                      	        }
                             		set(
                             			current, 
                             			"id",
                              		lv_id_6_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,47,FOLLOW_47_in_ruleFreeze4287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2171:1: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2172:1: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2172:1: (lv_ex_8_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2173:3: lv_ex_8_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getExLogicalExpressionParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleFreeze4308);
                    lv_ex_8_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_8_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleFreeze4320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFreezeAccess().getRightParenthesisKeyword_4_5());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2193:3: (otherlv_10= ';' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2193:5: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleFreeze4335); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFreezeAccess().getSemicolonKeyword_5());
                          
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
    // $ANTLR end "ruleFreeze"


    // $ANTLR start "entryRuleFreezeStatement"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2205:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2206:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2207:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeStatementRule()); 
            }
            pushFollow(FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4373);
            iv_ruleFreezeStatement=ruleFreezeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreezeStatement4383); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreezeStatement"


    // $ANTLR start "ruleFreezeStatement"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2214:1: ruleFreezeStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2217:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2218:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2218:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2218:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2218:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2219:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2219:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2220:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4429);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2236:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2237:1: (lv_access_1_0= ruleAccessName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2237:1: (lv_access_1_0= ruleAccessName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2238:3: lv_access_1_0= ruleAccessName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessName_in_ruleFreezeStatement4450);
                    lv_access_1_0=ruleAccessName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"access",
                              		lv_access_1_0, 
                              		"AccessName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFreezeStatement4463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFreezeStatementAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFreezeStatement"


    // $ANTLR start "entryRuleEval"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2266:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2267:2: (iv_ruleEval= ruleEval EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2268:2: iv_ruleEval= ruleEval EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvalRule()); 
            }
            pushFollow(FOLLOW_ruleEval_in_entryRuleEval4499);
            iv_ruleEval=ruleEval();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEval; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEval4509); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEval"


    // $ANTLR start "ruleEval"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2275:1: ruleEval returns [EObject current=null] : (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) ;
    public final EObject ruleEval() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_nested_2_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2278:28: ( (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2279:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2279:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2279:3: otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleEval4546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEvalAccess().getEvalKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleEval4558); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2287:1: ( (lv_nested_2_0= ruleEval ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==48) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2288:1: (lv_nested_2_0= ruleEval )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2288:1: (lv_nested_2_0= ruleEval )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2289:3: lv_nested_2_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEval_in_ruleEval4579);
            	    lv_nested_2_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nested",
            	              		lv_nested_2_0, 
            	              		"Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2305:3: ( (lv_statements_3_0= ruleExpressionStatement ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_NUMBER && LA37_0<=RULE_EXPONENT)||LA37_0==14||LA37_0==24||(LA37_0>=36 && LA37_0<=39)||LA37_0==53||LA37_0==55||LA37_0==70||LA37_0==73||(LA37_0>=77 && LA37_0<=78)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2306:1: (lv_statements_3_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2306:1: (lv_statements_3_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2307:3: lv_statements_3_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleEval4601);
            	    lv_statements_3_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_3_0, 
            	              		"ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEval4614); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2327:1: (otherlv_5= ';' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2327:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleEval4627); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEvalAccess().getSemicolonKeyword_5());
                          
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
    // $ANTLR end "ruleEval"


    // $ANTLR start "entryRuleInterfaceDeclaration"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2339:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2340:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2341:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration4665);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceDeclaration4675); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceDeclaration"


    // $ANTLR start "ruleInterfaceDeclaration"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2348:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
    public final EObject ruleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exports_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2351:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2352:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2352:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2352:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleInterfaceDeclaration4712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2356:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2357:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2357:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2358:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration4733);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInterfaceDeclarationRule());
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleInterfaceDeclaration4745); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2378:1: ( (lv_exports_3_0= ruleExport ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==50) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2379:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2379:1: (lv_exports_3_0= ruleExport )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2380:3: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExport_in_ruleInterfaceDeclaration4766);
            	    lv_exports_3_0=ruleExport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInterfaceDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exports",
            	              		lv_exports_3_0, 
            	              		"Export");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleInterfaceDeclaration4779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2400:1: (otherlv_5= ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2400:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleInterfaceDeclaration4792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getInterfaceDeclarationAccess().getSemicolonKeyword_5());
                          
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
    // $ANTLR end "ruleInterfaceDeclaration"


    // $ANTLR start "entryRuleExport"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2412:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2413:2: (iv_ruleExport= ruleExport EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2414:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport4830);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport4840); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExport"


    // $ANTLR start "ruleExport"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2421:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2424:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2425:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2425:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2425:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleExport4877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2429:1: ( (lv_names_1_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2430:1: (lv_names_1_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2430:1: (lv_names_1_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2431:3: lv_names_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleExport4898);
            lv_names_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExportRule());
              	        }
                     		add(
                     			current, 
                     			"names",
                      		lv_names_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2447:2: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==18) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2447:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleExport4911); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2451:1: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2452:1: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2452:1: (lv_names_3_0= ruleQualifiedName )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2453:3: lv_names_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleExport4932);
            	    lv_names_3_0=ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExportRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_3_0, 
            	              		"QualifiedName");
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleExport4946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getExportAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExport"


    // $ANTLR start "entryRuleImportStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2481:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2482:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2483:2: iv_ruleImportStmt= ruleImportStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStmtRule()); 
            }
            pushFollow(FOLLOW_ruleImportStmt_in_entryRuleImportStmt4982);
            iv_ruleImportStmt=ruleImportStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStmt4992); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportStmt"


    // $ANTLR start "ruleImportStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2490:1: ruleImportStmt returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleImportStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_interface_3_0 = null;

        EObject lv_restriction_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2493:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2494:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2494:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2494:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleImportStmt5029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2498:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2499:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2499:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2500:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5050);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2516:2: (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2516:4: otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleImportStmt5063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2520:1: ( (lv_interface_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2521:1: (lv_interface_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2521:1: (lv_interface_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2522:3: lv_interface_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5084);
                    lv_interface_3_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"interface",
                              		lv_interface_3_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2538:4: (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==28) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2538:6: otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleImportStmt5099); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImportStmtAccess().getWithKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2542:1: ( (lv_restriction_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2543:1: (lv_restriction_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2543:1: (lv_restriction_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2544:3: lv_restriction_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getRestrictionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleImportStmt5120);
                    lv_restriction_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"restriction",
                              		lv_restriction_5_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleImportStmt5134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getImportStmtAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportStmt"


    // $ANTLR start "entryRuleConflictStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2572:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2573:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2574:2: iv_ruleConflictStmt= ruleConflictStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConflictStmtRule()); 
            }
            pushFollow(FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5170);
            iv_ruleConflictStmt=ruleConflictStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConflictStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConflictStmt5180); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConflictStmt"


    // $ANTLR start "ruleConflictStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2581:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2584:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2585:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2585:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2585:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleConflictStmt5217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2589:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2590:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2590:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2591:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConflictStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleConflictStmt5238);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2607:2: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2607:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleConflictStmt5251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2611:1: ( (lv_restriction_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2612:1: (lv_restriction_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2612:1: (lv_restriction_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2613:3: lv_restriction_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getRestrictionExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConflictStmt5272);
                    lv_restriction_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"restriction",
                              		lv_restriction_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleConflictStmt5286); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConflictStmtAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConflictStmt"


    // $ANTLR start "entryRuleVersionStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2641:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2642:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2643:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt5322);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt5332); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2650:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2653:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2654:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2654:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2654:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleVersionStmt5369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2658:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2659:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2659:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2660:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt5386); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleVersionStmt5403); if (state.failed) return current;
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


    // $ANTLR start "entryRuleOpDefStatement"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2688:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2689:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2690:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefStatementRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement5439);
            iv_ruleOpDefStatement=ruleOpDefStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefStatement5449); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefStatement"


    // $ANTLR start "ruleOpDefStatement"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2697:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) ;
    public final EObject ruleOpDefStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_result_1_0 = null;

        AntlrDatatypeRuleToken lv_id_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_impl_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2700:28: ( (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2701:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2701:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2701:3: otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleOpDefStatement5486); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2705:1: ( (lv_result_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2706:1: (lv_result_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2706:1: (lv_result_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2707:3: lv_result_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefStatement5507);
            lv_result_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"result",
                      		lv_result_1_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2723:2: ( (lv_id_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2724:1: (lv_id_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2724:1: (lv_id_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2725:3: lv_id_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefStatement5528);
            lv_id_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleOpDefStatement5540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2745:1: ( (lv_param_4_0= ruleOpDefParameterList ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2746:1: (lv_param_4_0= ruleOpDefParameterList )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2746:1: (lv_param_4_0= ruleOpDefParameterList )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2747:3: lv_param_4_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement5561);
            lv_param_4_0=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"param",
                      		lv_param_4_0, 
                      		"OpDefParameterList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleOpDefStatement5573); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleOpDefStatement5585); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2771:1: ( (lv_impl_7_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2772:1: (lv_impl_7_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2772:1: (lv_impl_7_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2773:3: lv_impl_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleOpDefStatement5606);
            lv_impl_7_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"impl",
                      		lv_impl_7_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleOpDefStatement5618); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getOpDefStatementAccess().getSemicolonKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpDefStatement"


    // $ANTLR start "entryRuleOpDefParameterList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2801:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2802:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2803:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList5654);
            iv_ruleOpDefParameterList=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameterList5664); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefParameterList"


    // $ANTLR start "ruleOpDefParameterList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2810:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2813:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2814:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2814:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2814:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2814:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2815:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOpDefParameterListAccess().getOpDefParameterListAction_0(),
                          current);
                  
            }

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2823:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_VERSION && LA46_0<=RULE_EXPONENT)||(LA46_0>=29 && LA46_0<=33)||(LA46_0>=40 && LA46_0<=42)||LA46_0==53) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2823:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2823:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2824:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2824:1: (lv_list_1_0= ruleOpDefParameter )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2825:3: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5723);
                    lv_list_1_0=ruleOpDefParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefParameterListRule());
                      	        }
                             		add(
                             			current, 
                             			"list",
                              		lv_list_1_0, 
                              		"OpDefParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2841:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==18) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2841:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleOpDefParameterList5736); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2845:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2846:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2846:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2847:3: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5757);
                    	    lv_list_3_0=ruleOpDefParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOpDefParameterListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"list",
                    	              		lv_list_3_0, 
                    	              		"OpDefParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
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
    // $ANTLR end "ruleOpDefParameterList"


    // $ANTLR start "entryRuleOpDefParameter"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2871:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2872:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2873:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter5797);
            iv_ruleOpDefParameter=ruleOpDefParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameter5807); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefParameter"


    // $ANTLR start "ruleOpDefParameter"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2880:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2883:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2884:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2884:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2884:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2884:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2885:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2885:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2886:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefParameter5853);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2902:2: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2903:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2903:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2904:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefParameter5874);
            lv_id_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_1_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2920:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==19) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2920:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleOpDefParameter5887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2924:1: ( (lv_val_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2925:1: (lv_val_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2925:1: (lv_val_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2926:3: lv_val_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getValExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleOpDefParameter5908);
                    lv_val_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_3_0, 
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
    // $ANTLR end "ruleOpDefParameter"


    // $ANTLR start "entryRuleExpressionStatement"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2950:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2951:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2952:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement5946);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement5956); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2959:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2962:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2963:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2963:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2963:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2963:2: ( (lv_expr_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2964:1: (lv_expr_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2964:1: (lv_expr_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2965:3: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement6002);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_0_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionStatement6014); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2993:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2994:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2995:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression6050);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression6060); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3002:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3005:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3006:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3006:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt48=3;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3006:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3006:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3007:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3007:1: (lv_let_0_0= ruleLetExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3008:3: lv_let_0_0= ruleLetExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLetLetExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression6106);
                    lv_let_0_0=ruleLetExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"let",
                              		lv_let_0_0, 
                              		"LetExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3025:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3025:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3026:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3026:1: (lv_expr_1_0= ruleImplicationExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3027:3: lv_expr_1_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprImplicationExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImplicationExpression_in_ruleExpression6133);
                    lv_expr_1_0=ruleImplicationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_1_0, 
                              		"ImplicationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3044:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3044:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3045:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3045:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3046:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCollectionCollectionInitializerParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpression6160);
                    lv_collection_2_0=ruleCollectionInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"collection",
                              		lv_collection_2_0, 
                              		"CollectionInitializer");
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


    // $ANTLR start "entryRuleLetExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3070:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3071:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3072:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression6196);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression6206); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetExpression"


    // $ANTLR start "ruleLetExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3079:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_valueExpr_4_0 = null;

        EObject lv_subExpr_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3082:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3083:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3083:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3083:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleLetExpression6243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3087:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3088:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3088:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3089:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLetExpression6264);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3105:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3106:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3106:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3107:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLetExpression6285);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleLetExpression6297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3127:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3128:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3128:1: (lv_valueExpr_4_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3129:3: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression6318);
            lv_valueExpr_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"valueExpr",
                      		lv_valueExpr_4_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,56,FOLLOW_56_in_ruleLetExpression6330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3149:1: ( (lv_subExpr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3150:1: (lv_subExpr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3150:1: (lv_subExpr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3151:3: lv_subExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression6351);
            lv_subExpr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"subExpr",
                      		lv_subExpr_6_0, 
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
    // $ANTLR end "ruleLetExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3175:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3176:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3177:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression6387);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression6397); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3184:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3187:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3188:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3188:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3188:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3188:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3189:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3189:1: (lv_left_0_0= ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3190:3: lv_left_0_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftLogicalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression6443);
            lv_left_0_0=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"LogicalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3206:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==19) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3207:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3207:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3208:3: lv_right_1_0= ruleAssignmentExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightAssignmentExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression6464);
                    lv_right_1_0=ruleAssignmentExpressionPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      	        }
                             		add(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"AssignmentExpressionPart");
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleAssignmentExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3232:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3233:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3234:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart6501);
            iv_ruleAssignmentExpressionPart=ruleAssignmentExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpressionPart6511); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpressionPart"


    // $ANTLR start "ruleAssignmentExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3241:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3244:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3245:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3245:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3245:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3245:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3246:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3246:1: (lv_op_0_0= ruleAssignmentOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3247:3: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart6557);
            lv_op_0_0=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"AssignmentOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3263:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3263:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3263:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3264:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3264:1: (lv_ex_1_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3265:3: lv_ex_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getExLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart6579);
                    lv_ex_1_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_1_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3282:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3282:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3283:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3283:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3284:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart6606);
                    lv_collection_2_0=ruleCollectionInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"collection",
                              		lv_collection_2_0, 
                              		"CollectionInitializer");
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
    // $ANTLR end "ruleAssignmentExpressionPart"


    // $ANTLR start "entryRuleAssignmentOperator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3308:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3309:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3310:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator6644);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentOperator6655); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3317:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3320:28: (kw= '=' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3322:2: kw= '='
            {
            kw=(Token)match(input,19,FOLLOW_19_in_ruleAssignmentOperator6692); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleImplicationExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3335:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3336:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3337:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression6731);
            iv_ruleImplicationExpression=ruleImplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpression6741); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationExpression"


    // $ANTLR start "ruleImplicationExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3344:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3347:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3348:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3348:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3348:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3348:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3349:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3349:1: (lv_left_0_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3350:3: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression6787);
            lv_left_0_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"AssignmentExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3366:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=57 && LA51_0<=58)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3367:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3367:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3368:3: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression6808);
            	    lv_right_1_0=ruleImplicationExpressionPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImplicationExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_1_0, 
            	              		"ImplicationExpressionPart");
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
    // $ANTLR end "ruleImplicationExpression"


    // $ANTLR start "entryRuleImplicationExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3392:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3393:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3394:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart6845);
            iv_ruleImplicationExpressionPart=ruleImplicationExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpressionPart6855); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationExpressionPart"


    // $ANTLR start "ruleImplicationExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3401:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3404:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3405:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3405:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3405:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3405:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3406:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3406:1: (lv_op_0_0= ruleImplicationOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3407:3: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart6901);
            lv_op_0_0=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"ImplicationOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3423:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3424:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3424:1: (lv_ex_1_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3425:3: lv_ex_1_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart6922);
            lv_ex_1_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_1_0, 
                      		"AssignmentExpression");
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
    // $ANTLR end "ruleImplicationExpressionPart"


    // $ANTLR start "entryRuleImplicationOperator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3449:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3450:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3451:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator6959);
            iv_ruleImplicationOperator=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationOperator6970); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationOperator"


    // $ANTLR start "ruleImplicationOperator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3458:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3461:28: ( (kw= 'implies' | kw= 'iff' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3462:1: (kw= 'implies' | kw= 'iff' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3462:1: (kw= 'implies' | kw= 'iff' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==57) ) {
                alt52=1;
            }
            else if ( (LA52_0==58) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3463:2: kw= 'implies'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleImplicationOperator7008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3470:2: kw= 'iff'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleImplicationOperator7027); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getIffKeyword_1()); 
                          
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
    // $ANTLR end "ruleImplicationOperator"


    // $ANTLR start "entryRuleLogicalExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3483:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3484:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3485:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7067);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression7077); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3492:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3495:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3496:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3496:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3496:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3496:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3497:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3497:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3498:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7123);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3514:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=59 && LA53_0<=61)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3515:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3515:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3516:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression7144);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3540:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3541:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3542:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart7181);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart7191); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3549:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3552:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3553:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3553:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3553:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3553:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3554:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3554:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3555:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart7237);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3571:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3572:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3572:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3573:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart7258);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3597:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3598:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3599:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator7295);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator7306); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3606:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3609:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3610:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3610:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt54=1;
                }
                break;
            case 60:
                {
                alt54=2;
                }
                break;
            case 61:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3611:2: kw= 'and'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleLogicalOperator7344); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3618:2: kw= 'or'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleLogicalOperator7363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3625:2: kw= 'xor'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleLogicalOperator7382); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3638:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3639:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3640:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression7422);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression7432); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3647:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3650:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3651:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3651:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3651:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3651:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3652:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3652:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3653:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression7478);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3669:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=62 && LA55_0<=64)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3670:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3670:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3671:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression7499);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3695:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3696:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3697:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart7536);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart7546); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3704:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3707:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3708:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3708:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3708:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3708:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3709:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3709:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3710:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart7592);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3726:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt56=2;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3726:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3726:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3727:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3727:1: (lv_ex_1_0= ruleRelationalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3728:3: lv_ex_1_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart7614);
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
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3745:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3745:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3746:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3746:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3747:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart7641);
                    lv_collection_2_0=ruleCollectionInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"collection",
                              		lv_collection_2_0, 
                              		"CollectionInitializer");
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
    // $ANTLR end "ruleEqualityExpressionPart"


    // $ANTLR start "entryRuleEqualityOperator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3771:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3772:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3773:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator7679);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator7690); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3780:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3783:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3784:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3784:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt57=1;
                }
                break;
            case 63:
                {
                alt57=2;
                }
                break;
            case 64:
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3785:2: kw= '=='
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleEqualityOperator7728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3792:2: kw= '<>'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleEqualityOperator7747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3799:2: kw= '!='
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleEqualityOperator7766); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3812:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3813:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression7806);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression7816); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3821:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3824:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3825:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3825:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3825:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3825:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3826:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3826:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3827:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression7862);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3843:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=65 && LA58_0<=68)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3844:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3844:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3845:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression7883);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3869:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3870:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3871:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart7920);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart7930); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3878:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3881:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3882:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3882:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3882:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3882:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3883:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3883:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3884:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart7976);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3900:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3901:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3901:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3902:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart7997);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3926:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3927:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3928:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8034);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator8045); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3935:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3938:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3939:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3939:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt59=4;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt59=1;
                }
                break;
            case 66:
                {
                alt59=2;
                }
                break;
            case 67:
                {
                alt59=3;
                }
                break;
            case 68:
                {
                alt59=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3940:2: kw= '>'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleRelationalOperator8083); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3947:2: kw= '<'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleRelationalOperator8102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3954:2: kw= '>='
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleRelationalOperator8121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3961:2: kw= '<='
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleRelationalOperator8140); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3974:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3975:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3976:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression8180);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression8190); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3983:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3986:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3987:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3987:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3987:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3987:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3988:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3988:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3989:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression8236);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4005:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=69 && LA60_0<=70)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4006:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4006:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4007:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression8257);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4031:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4032:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4033:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart8294);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart8304); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4040:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4043:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4044:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4044:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4044:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4044:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4045:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4045:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4046:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart8350);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4062:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4063:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4063:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4064:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart8371);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4088:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4089:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4090:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator8408);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator8419); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4097:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4100:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4101:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4101:1: (kw= '+' | kw= '-' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==69) ) {
                alt61=1;
            }
            else if ( (LA61_0==70) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4102:2: kw= '+'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleAdditiveOperator8457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4109:2: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleAdditiveOperator8476); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4122:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4123:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4124:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression8516);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression8526); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4131:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4134:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4136:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4136:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4137:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression8572);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4153:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=71 && LA62_0<=72)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4154:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4154:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4155:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression8593);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4179:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4180:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4181:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart8630);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart8640); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4188:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4191:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4192:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4192:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4192:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4192:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4193:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4193:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4194:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart8686);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4210:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4211:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4211:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4212:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart8707);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4236:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4237:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4238:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator8744);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator8755); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4245:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4248:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4249:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4249:1: (kw= '*' | kw= '/' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==71) ) {
                alt63=1;
            }
            else if ( (LA63_0==72) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4250:2: kw= '*'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleMultiplicativeOperator8793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4257:2: kw= '/'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator8812); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4270:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4271:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4272:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression8852);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression8862); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4279:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4282:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4283:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4283:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4283:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4283:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==70||LA64_0==73) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4284:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4284:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4285:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression8908);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4301:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4302:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4302:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4303:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression8930);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4327:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4328:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4329:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator8967);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator8978); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4336:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4339:28: ( (kw= 'not' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4340:1: (kw= 'not' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4340:1: (kw= 'not' | kw= '-' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==73) ) {
                alt65=1;
            }
            else if ( (LA65_0==70) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4341:2: kw= 'not'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleUnaryOperator9016); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4348:2: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleUnaryOperator9035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_1()); 
                          
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4361:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4362:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4363:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9075);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression9085); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4370:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4373:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt68=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==EOF||(LA68_1>=15 && LA68_1<=16)||(LA68_1>=18 && LA68_1<=19)||(LA68_1>=25 && LA68_1<=26)||(LA68_1>=34 && LA68_1<=35)||LA68_1==47||(LA68_1>=56 && LA68_1<=72)||(LA68_1>=74 && LA68_1<=76)||(LA68_1>=79 && LA68_1<=81)) ) {
                    alt68=2;
                }
                else if ( (LA68_1==24) ) {
                    alt68=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA68_2 = input.LA(2);

                if ( (LA68_2==EOF||(LA68_2>=15 && LA68_2<=16)||(LA68_2>=18 && LA68_2<=19)||(LA68_2>=25 && LA68_2<=26)||(LA68_2>=34 && LA68_2<=35)||LA68_2==47||(LA68_2>=56 && LA68_2<=72)||(LA68_2>=74 && LA68_2<=76)||(LA68_2>=79 && LA68_2<=81)) ) {
                    alt68=2;
                }
                else if ( (LA68_2==24) ) {
                    alt68=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA68_3 = input.LA(2);

                if ( (LA68_3==EOF||(LA68_3>=15 && LA68_3<=16)||(LA68_3>=18 && LA68_3<=19)||(LA68_3>=25 && LA68_3<=26)||(LA68_3>=34 && LA68_3<=35)||LA68_3==47||(LA68_3>=56 && LA68_3<=72)||(LA68_3>=74 && LA68_3<=76)||(LA68_3>=79 && LA68_3<=81)) ) {
                    alt68=2;
                }
                else if ( (LA68_3==24) ) {
                    alt68=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                int LA68_4 = input.LA(2);

                if ( (LA68_4==24) ) {
                    alt68=1;
                }
                else if ( (LA68_4==EOF||(LA68_4>=15 && LA68_4<=16)||(LA68_4>=18 && LA68_4<=19)||(LA68_4>=25 && LA68_4<=26)||(LA68_4>=34 && LA68_4<=35)||LA68_4==47||(LA68_4>=56 && LA68_4<=72)||(LA68_4>=74 && LA68_4<=76)||(LA68_4>=79 && LA68_4<=81)) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_NUMBER:
            case RULE_STRING:
            case 24:
            case 36:
            case 37:
            case 38:
            case 39:
            case 77:
            case 78:
                {
                alt68=2;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4374:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4375:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4375:1: (lv_call_0_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4376:3: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePostfixExpression9132);
                    lv_call_0_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"call",
                              		lv_call_0_0, 
                              		"FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4392:2: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==35) ) {
                            switch ( input.LA(2) ) {
                            case RULE_ID:
                                {
                                int LA66_4 = input.LA(3);

                                if ( (LA66_4==24) ) {
                                    alt66=1;
                                }


                                }
                                break;
                            case RULE_VERSION:
                                {
                                int LA66_5 = input.LA(3);

                                if ( (LA66_5==24) ) {
                                    alt66=1;
                                }


                                }
                                break;
                            case RULE_EXPONENT:
                                {
                                int LA66_6 = input.LA(3);

                                if ( (LA66_6==24) ) {
                                    alt66=1;
                                }


                                }
                                break;
                            case 53:
                                {
                                int LA66_7 = input.LA(3);

                                if ( (LA66_7==24) ) {
                                    alt66=1;
                                }


                                }
                                break;

                            }

                        }
                        else if ( ((LA66_0>=74 && LA66_0<=75)) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4393:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4393:1: (lv_fCalls_1_0= ruleCall )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4394:3: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCall_in_rulePostfixExpression9153);
                    	    lv_fCalls_1_0=ruleCall();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fCalls",
                    	              		lv_fCalls_1_0, 
                    	              		"Call");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4410:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==35) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4411:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4411:1: (lv_access_2_0= ruleExpressionAccess )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4412:3: lv_access_2_0= ruleExpressionAccess
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getAccessExpressionAccessParserRuleCall_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpressionAccess_in_rulePostfixExpression9175);
                            lv_access_2_0=ruleExpressionAccess();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"access",
                                      		lv_access_2_0, 
                                      		"ExpressionAccess");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4429:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4429:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4430:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4430:1: (lv_left_3_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4431:3: lv_left_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression9204);
                    lv_left_3_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"left",
                              		lv_left_3_0, 
                              		"PrimaryExpression");
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4455:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4456:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4457:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall9240);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall9250); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4464:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_call_1_0 = null;

        EObject lv_setOp_3_0 = null;

        EObject lv_arrayEx_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4467:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4468:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4468:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt69=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt69=1;
                }
                break;
            case 74:
                {
                alt69=2;
                }
                break;
            case 75:
                {
                alt69=3;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4468:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4468:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4468:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleCall9288); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4472:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4473:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4473:1: (lv_call_1_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4474:3: lv_call_1_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getCallFeatureCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleCall9309);
                    lv_call_1_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"call",
                              		lv_call_1_0, 
                              		"FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4491:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4491:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4491:8: otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) )
                    {
                    otherlv_2=(Token)match(input,74,FOLLOW_74_in_ruleCall9329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4495:1: ( (lv_setOp_3_0= ruleSetOp ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4496:1: (lv_setOp_3_0= ruleSetOp )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4496:1: (lv_setOp_3_0= ruleSetOp )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4497:3: lv_setOp_3_0= ruleSetOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getSetOpSetOpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSetOp_in_ruleCall9350);
                    lv_setOp_3_0=ruleSetOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"setOp",
                              		lv_setOp_3_0, 
                              		"SetOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4514:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4514:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4514:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,75,FOLLOW_75_in_ruleCall9370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4518:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4519:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4519:1: (lv_arrayEx_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4520:3: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleCall9391);
                    lv_arrayEx_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"arrayEx",
                              		lv_arrayEx_5_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,76,FOLLOW_76_in_ruleCall9403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCallAccess().getRightSquareBracketKeyword_2_2());
                          
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
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleFeatureCall"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4548:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4549:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4550:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall9440);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall9450); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4557:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4560:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4561:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4561:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4561:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4561:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4562:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4562:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4563:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleFeatureCall9496);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleFeatureCall9508); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4583:1: ( (lv_param_2_0= ruleActualParameterList ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_NUMBER && LA70_0<=RULE_EXPONENT)||LA70_0==14||LA70_0==24||(LA70_0>=36 && LA70_0<=39)||LA70_0==53||LA70_0==55||LA70_0==70||LA70_0==73||(LA70_0>=77 && LA70_0<=78)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4584:1: (lv_param_2_0= ruleActualParameterList )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4584:1: (lv_param_2_0= ruleActualParameterList )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4585:3: lv_param_2_0= ruleActualParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getParamActualParameterListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleActualParameterList_in_ruleFeatureCall9529);
                    lv_param_2_0=ruleActualParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_2_0, 
                              		"ActualParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleFeatureCall9542); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleSetOp"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4613:1: entryRuleSetOp returns [EObject current=null] : iv_ruleSetOp= ruleSetOp EOF ;
    public final EObject entryRuleSetOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOp = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4614:2: (iv_ruleSetOp= ruleSetOp EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4615:2: iv_ruleSetOp= ruleSetOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetOpRule()); 
            }
            pushFollow(FOLLOW_ruleSetOp_in_entryRuleSetOp9578);
            iv_ruleSetOp=ruleSetOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetOp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetOp9588); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetOp"


    // $ANTLR start "ruleSetOp"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4622:1: ruleSetOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) ;
    public final EObject ruleSetOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_declEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4625:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4626:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4626:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4626:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4626:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4627:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4627:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4628:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleSetOp9634);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSetOpRule());
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSetOp9646); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4648:1: ( (lv_decl_2_0= ruleDeclarator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4649:1: (lv_decl_2_0= ruleDeclarator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4649:1: (lv_decl_2_0= ruleDeclarator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4650:3: lv_decl_2_0= ruleDeclarator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarator_in_ruleSetOp9667);
            lv_decl_2_0=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSetOpRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4666:2: ( (lv_declEx_3_0= ruleExpression ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_NUMBER && LA71_0<=RULE_EXPONENT)||LA71_0==14||LA71_0==24||(LA71_0>=36 && LA71_0<=39)||LA71_0==53||LA71_0==55||LA71_0==70||LA71_0==73||(LA71_0>=77 && LA71_0<=78)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4667:1: (lv_declEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4667:1: (lv_declEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4668:3: lv_declEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclExExpressionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSetOp9688);
                    lv_declEx_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSetOpRule());
                      	        }
                             		set(
                             			current, 
                             			"declEx",
                              		lv_declEx_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSetOp9701); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSetOpAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetOp"


    // $ANTLR start "entryRuleDeclarator"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4696:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4697:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4698:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator9737);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator9747); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4705:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4708:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4709:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4709:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4709:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4709:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4710:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4710:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4711:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator9793);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4727:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==16) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4727:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleDeclarator9806); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4731:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4732:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4732:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4733:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator9827);
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
            	    break loop72;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleDeclarator9841); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4761:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4762:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4763:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration9877);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration9887); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4770:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4773:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4774:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4774:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4774:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4774:2: ( (lv_type_0_0= ruleType ) )?
            int alt73=2;
            switch ( input.LA(1) ) {
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 40:
                case 41:
                case 42:
                    {
                    alt73=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA73_2 = input.LA(2);

                    if ( ((LA73_2>=RULE_VERSION && LA73_2<=RULE_EXPONENT)||LA73_2==34||LA73_2==53) ) {
                        alt73=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA73_3 = input.LA(2);

                    if ( ((LA73_3>=RULE_VERSION && LA73_3<=RULE_EXPONENT)||LA73_3==34||LA73_3==53) ) {
                        alt73=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA73_4 = input.LA(2);

                    if ( ((LA73_4>=RULE_VERSION && LA73_4<=RULE_EXPONENT)||LA73_4==34||LA73_4==53) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA73_5 = input.LA(2);

                    if ( ((LA73_5>=RULE_VERSION && LA73_5<=RULE_EXPONENT)||LA73_5==34||LA73_5==53) ) {
                        alt73=1;
                    }
                    }
                    break;
            }

            switch (alt73) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4775:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4775:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4776:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration9933);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4792:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4793:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4793:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4794:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration9955);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4810:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==18) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4810:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleDeclaration9968); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4814:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4815:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4815:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4816:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration9989);
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
            	    break loop74;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4832:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==19) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4832:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleDeclaration10004); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4836:1: ( (lv_init_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4837:1: (lv_init_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4837:1: (lv_init_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4838:3: lv_init_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getInitExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclaration10025);
                    lv_init_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_5_0, 
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleActualParameterList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4862:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4863:2: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4864:2: iv_ruleActualParameterList= ruleActualParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10063);
            iv_ruleActualParameterList=ruleActualParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActualParameterList10073); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActualParameterList"


    // $ANTLR start "ruleActualParameterList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4871:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4874:28: ( ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4875:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4875:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4875:2: ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4875:2: ( (lv_param_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4876:1: (lv_param_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4876:1: (lv_param_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:3: lv_param_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList10119);
            lv_param_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualParameterListRule());
              	        }
                     		add(
                     			current, 
                     			"param",
                      		lv_param_0_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4893:2: (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==18) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4893:4: otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleActualParameterList10132); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4897:1: ( (lv_param_2_0= ruleExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4898:1: (lv_param_2_0= ruleExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4898:1: (lv_param_2_0= ruleExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4899:3: lv_param_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList10153);
            	    lv_param_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualParameterListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"param",
            	              		lv_param_2_0, 
            	              		"Expression");
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActualParameterList"


    // $ANTLR start "entryRuleExpressionAccess"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4923:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4924:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4925:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionAccessRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess10191);
            iv_ruleExpressionAccess=ruleExpressionAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionAccess; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionAccess10201); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionAccess"


    // $ANTLR start "ruleExpressionAccess"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4932:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4935:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4936:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4936:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4936:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleExpressionAccess10238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4940:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4941:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4941:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4942:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionAccess10259);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4958:2: ( (lv_calls_2_0= ruleCall ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA77_4 = input.LA(3);

                        if ( (LA77_4==24) ) {
                            alt77=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA77_5 = input.LA(3);

                        if ( (LA77_5==24) ) {
                            alt77=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA77_6 = input.LA(3);

                        if ( (LA77_6==24) ) {
                            alt77=1;
                        }


                        }
                        break;
                    case 53:
                        {
                        int LA77_7 = input.LA(3);

                        if ( (LA77_7==24) ) {
                            alt77=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA77_0>=74 && LA77_0<=75)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4959:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4959:1: (lv_calls_2_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4960:3: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_ruleExpressionAccess10280);
            	    lv_calls_2_0=ruleCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_2_0, 
            	              		"Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4976:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==35) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4977:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4977:1: (lv_access_3_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4978:3: lv_access_3_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getAccessExpressionAccessParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess10302);
                    lv_access_3_0=ruleExpressionAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
                      	        }
                             		set(
                             			current, 
                             			"access",
                              		lv_access_3_0, 
                              		"ExpressionAccess");
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
    // $ANTLR end "ruleExpressionAccess"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5002:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5003:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5004:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression10339);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression10349); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5011:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_lit_0_0 = null;

        EObject lv_ex_2_0 = null;

        EObject lv_ifEx_4_0 = null;

        EObject lv_refEx_7_0 = null;

        EObject lv_calls_9_0 = null;

        EObject lv_access_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5014:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) )
            int alt79=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case RULE_STRING:
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 36:
            case 37:
            case 38:
            case 39:
            case 53:
                {
                alt79=1;
                }
                break;
            case 24:
                {
                alt79=2;
                }
                break;
            case 78:
                {
                alt79=3;
                }
                break;
            case 77:
                {
                alt79=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5015:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5016:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5016:1: (lv_lit_0_0= ruleLiteral )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5017:3: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression10396);
                    lv_lit_0_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"lit",
                              		lv_lit_0_0, 
                              		"Literal");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5034:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5034:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5034:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression10415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5038:1: ( (lv_ex_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5039:1: (lv_ex_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5039:1: (lv_ex_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5040:3: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression10436);
                    lv_ex_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression10448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5061:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5061:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5062:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5062:1: (lv_ifEx_4_0= ruleIfExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5063:3: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression10476);
                    lv_ifEx_4_0=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"ifEx",
                              		lv_ifEx_4_0, 
                              		"IfExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5080:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5080:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5080:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,77,FOLLOW_77_in_rulePrimaryExpression10495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression10507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5088:1: ( (lv_refEx_7_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5089:1: (lv_refEx_7_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5089:1: (lv_refEx_7_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5090:3: lv_refEx_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefExExpressionParserRuleCall_0_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression10528);
                    lv_refEx_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"refEx",
                              		lv_refEx_7_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression10540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5110:3: ( (lv_calls_9_0= ruleCall ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA80_4 = input.LA(3);

                        if ( (LA80_4==24) ) {
                            alt80=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA80_5 = input.LA(3);

                        if ( (LA80_5==24) ) {
                            alt80=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA80_6 = input.LA(3);

                        if ( (LA80_6==24) ) {
                            alt80=1;
                        }


                        }
                        break;
                    case 53:
                        {
                        int LA80_7 = input.LA(3);

                        if ( (LA80_7==24) ) {
                            alt80=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA80_0>=74 && LA80_0<=75)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5111:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5111:1: (lv_calls_9_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5112:3: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_rulePrimaryExpression10563);
            	    lv_calls_9_0=ruleCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_9_0, 
            	              		"Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5128:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==35) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5129:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5129:1: (lv_access_10_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5130:3: lv_access_10_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAccessExpressionAccessParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression10585);
                    lv_access_10_0=ruleExpressionAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"access",
                              		lv_access_10_0, 
                              		"ExpressionAccess");
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleCollectionInitializer"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5154:1: entryRuleCollectionInitializer returns [EObject current=null] : iv_ruleCollectionInitializer= ruleCollectionInitializer EOF ;
    public final EObject entryRuleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5155:2: (iv_ruleCollectionInitializer= ruleCollectionInitializer EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5156:2: iv_ruleCollectionInitializer= ruleCollectionInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer10622);
            iv_ruleCollectionInitializer=ruleCollectionInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionInitializer10632); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionInitializer"


    // $ANTLR start "ruleCollectionInitializer"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5163:1: ruleCollectionInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5166:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5167:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5167:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5167:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5167:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5168:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCollectionInitializerAccess().getCollectionInitializerAction_0(),
                          current);
                  
            }

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5176:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_VERSION && LA82_0<=RULE_EXPONENT)||LA82_0==53) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5177:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5177:1: (lv_type_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5178:3: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer10690);
                    lv_type_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionInitializerRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_1_0, 
                              		"QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleCollectionInitializer10703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCollectionInitializerAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5198:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_NUMBER && LA83_0<=RULE_EXPONENT)||LA83_0==14||LA83_0==24||(LA83_0>=36 && LA83_0<=39)||LA83_0==53||LA83_0==70||LA83_0==73||(LA83_0>=77 && LA83_0<=78)) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5199:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5199:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5200:3: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer10724);
                    lv_init_3_0=ruleExpressionListOrRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionInitializerRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_3_0, 
                              		"ExpressionListOrRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCollectionInitializer10737); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCollectionInitializerAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionInitializer"


    // $ANTLR start "entryRuleExpressionListOrRange"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5228:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5229:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5230:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange10773);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListOrRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListOrRange10783); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionListOrRange"


    // $ANTLR start "ruleExpressionListOrRange"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5237:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5240:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5241:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5241:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5241:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5241:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5242:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5242:1: (lv_list_0_0= ruleExpressionListEntry )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5243:3: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10829);
            lv_list_0_0=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
              	        }
                     		add(
                     			current, 
                     			"list",
                      		lv_list_0_0, 
                      		"ExpressionListEntry");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5259:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==18) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5259:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleExpressionListOrRange10842); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5263:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5264:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5264:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5265:3: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10863);
            	    lv_list_2_0=ruleExpressionListEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"list",
            	              		lv_list_2_0, 
            	              		"ExpressionListEntry");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
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
    // $ANTLR end "ruleExpressionListOrRange"


    // $ANTLR start "entryRuleExpressionListEntry"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5289:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5290:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5291:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListEntryRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry10901);
            iv_ruleExpressionListEntry=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListEntry; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListEntry10911); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionListEntry"


    // $ANTLR start "ruleExpressionListEntry"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5298:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_collection_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5301:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5302:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5303:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5303:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5304:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10958);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5320:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==35) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5320:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleExpressionListEntry10971); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5325:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5325:1: (lv_attrib_2_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5326:3: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10992);
                            lv_attrib_2_0=ruleIdentifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"attrib",
                                      		lv_attrib_2_0, 
                                      		"Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleExpressionListEntry11006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5346:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5346:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5346:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5347:1: (lv_value_4_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5347:1: (lv_value_4_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5348:3: lv_value_4_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getValueLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11030);
                    lv_value_4_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5365:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5365:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5366:1: (lv_collection_5_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5366:1: (lv_collection_5_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5367:3: lv_collection_5_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11057);
                    lv_collection_5_0=ruleCollectionInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      	        }
                             		set(
                             			current, 
                             			"collection",
                              		lv_collection_5_0, 
                              		"CollectionInitializer");
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
    // $ANTLR end "ruleExpressionListEntry"


    // $ANTLR start "entryRuleLiteral"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5391:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5392:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5393:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral11094);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral11104); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5400:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5403:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5404:1: ( (lv_val_0_0= ruleValue ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5404:1: ( (lv_val_0_0= ruleValue ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5405:1: (lv_val_0_0= ruleValue )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5405:1: (lv_val_0_0= ruleValue )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5406:3: lv_val_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValue_in_ruleLiteral11149);
            lv_val_0_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_0_0, 
                      		"Value");
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIfExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5430:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5431:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5432:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression11184);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression11194); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5439:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ifEx_1_0 = null;

        EObject lv_thenEx_3_0 = null;

        EObject lv_elseEx_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5442:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5443:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5443:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5443:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_78_in_ruleIfExpression11231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5447:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5448:1: (lv_ifEx_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5448:1: (lv_ifEx_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5449:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11252);
            lv_ifEx_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"ifEx",
                      		lv_ifEx_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,79,FOLLOW_79_in_ruleIfExpression11264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5469:1: ( (lv_thenEx_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5470:1: (lv_thenEx_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5470:1: (lv_thenEx_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5471:3: lv_thenEx_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11285);
            lv_thenEx_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"thenEx",
                      		lv_thenEx_3_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,80,FOLLOW_80_in_ruleIfExpression11297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5491:1: ( (lv_elseEx_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5492:1: (lv_elseEx_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5492:1: (lv_elseEx_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5493:3: lv_elseEx_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11318);
            lv_elseEx_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"elseEx",
                      		lv_elseEx_5_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,81,FOLLOW_81_in_ruleIfExpression11330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIfExpressionAccess().getEndifKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleIdentifier"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5521:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5522:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5523:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier11367);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier11378); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5530:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5533:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5534:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5534:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt88=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt88=1;
                }
                break;
            case RULE_VERSION:
                {
                alt88=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt88=3;
                }
                break;
            case 53:
                {
                alt88=4;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5534:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier11418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5542:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier11444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5550:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier11470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5559:2: kw= 'version'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleIdentifier11494); if (state.failed) return current;
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

    // $ANTLR start synpred2_InternalIvml
    public final void synpred2_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_version_3_0 = null;


        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:161:1: ( (lv_version_3_0= ruleVersionStmt ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVersionStmt_in_synpred2_InternalIvml287);
        lv_version_3_0=ruleVersionStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalIvml

    // $ANTLR start synpred45_InternalIvml
    public final void synpred45_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1756:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1756:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1756:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1757:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1757:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1758:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred45_InternalIvml3434);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred45_InternalIvml

    // $ANTLR start synpred50_InternalIvml
    public final void synpred50_InternalIvml_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1838:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1839:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1839:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1840:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred50_InternalIvml3599); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred50_InternalIvml

    // Delegated rules

    public final boolean synpred2_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA87 dfa87 = new DFA87(this);
    static final String DFA7_eotS =
        "\24\uffff";
    static final String DFA7_eofS =
        "\1\1\23\uffff";
    static final String DFA7_minS =
        "\1\4\3\uffff\4\6\6\uffff\6\6";
    static final String DFA7_maxS =
        "\1\116\3\uffff\4\113\6\uffff\1\65\4\113\1\65";
    static final String DFA7_acceptS =
        "\1\uffff\1\11\1\1\1\2\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\6\uffff";
    static final String DFA7_specialS =
        "\24\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\12\1\5\1\4\1\6\5\uffff\1\12\1\1\1\uffff\1\2\2\uffff\2\2"+
            "\1\uffff\1\15\1\12\2\uffff\1\2\1\uffff\5\3\2\uffff\4\12\3\3"+
            "\2\13\1\10\2\uffff\1\11\4\uffff\1\7\1\14\1\12\16\uffff\1\12"+
            "\2\uffff\1\12\3\uffff\2\12",
            "",
            "",
            "",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11"+
            "\uffff\1\16\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11"+
            "\uffff\1\16\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11"+
            "\uffff\1\16\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11"+
            "\uffff\1\16\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\17\1\21\54\uffff\1\22",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23"+
            "\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23"+
            "\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23"+
            "\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23"+
            "\1\12\21\uffff\1\3\3\uffff\20\12\1\uffff\2\12",
            "\1\20\1\17\1\21\54\uffff\1\22"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
    }
    static final String DFA14_eotS =
        "\17\uffff";
    static final String DFA14_eofS =
        "\17\uffff";
    static final String DFA14_minS =
        "\1\4\2\uffff\4\6\2\uffff\6\6";
    static final String DFA14_maxS =
        "\1\116\2\uffff\4\113\2\uffff\1\65\4\113\1\65";
    static final String DFA14_acceptS =
        "\1\uffff\1\4\1\1\4\uffff\1\2\1\3\6\uffff";
    static final String DFA14_specialS =
        "\17\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\5"+
            "\2\2\uffff\4\7\3\2\12\uffff\1\6\1\uffff\1\7\16\uffff\1\7\2\uffff"+
            "\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "\1\13\1\12\1\14\54\uffff\1\15",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\1\13\1\12\1\14\54\uffff\1\15"
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
            return "()* loopback of 774:1: ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
    }
    static final String DFA17_eotS =
        "\17\uffff";
    static final String DFA17_eofS =
        "\17\uffff";
    static final String DFA17_minS =
        "\1\4\2\uffff\4\6\2\uffff\6\6";
    static final String DFA17_maxS =
        "\1\116\2\uffff\4\113\2\uffff\1\65\4\113\1\65";
    static final String DFA17_acceptS =
        "\1\uffff\1\4\1\1\4\uffff\1\2\1\3\6\uffff";
    static final String DFA17_specialS =
        "\17\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\5"+
            "\2\2\uffff\4\7\3\2\12\uffff\1\6\1\uffff\1\7\16\uffff\1\7\2\uffff"+
            "\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff"+
            "\1\11\1\7\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "\1\13\1\12\1\14\54\uffff\1\15",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7"+
            "\21\uffff\1\2\3\uffff\20\7\1\uffff\2\7",
            "\1\13\1\12\1\14\54\uffff\1\15"
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
            return "()+ loopback of 919:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+";
        }
    }
    static final String DFA48_eotS =
        "\16\uffff";
    static final String DFA48_eofS =
        "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String DFA48_minS =
        "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA48_maxS =
        "\1\116\2\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String DFA48_specialS =
        "\16\uffff}>";
    static final String[] DFA48_transitionS = {
            "\2\2\1\4\1\3\1\5\5\uffff\1\7\11\uffff\1\2\13\uffff\4\2\15\uffff"+
            "\1\6\1\uffff\1\1\16\uffff\1\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "",
            "\1\12\1\11\1\13\54\uffff\1\14",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2"+
            "\13\uffff\1\2\10\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\12\1\11\1\13\54\uffff\1\14"
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
            return "3006:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA50_eotS =
        "\15\uffff";
    static final String DFA50_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA50_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA50_maxS =
        "\1\116\1\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA50_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA50_specialS =
        "\15\uffff}>";
    static final String[] DFA50_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff"+
            "\1\5\20\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\1\uffff\1\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13"+
            "\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13"+
            "\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13"+
            "\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13"+
            "\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\1\uffff\1\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1"+
            "\13\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1"+
            "\13\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1"+
            "\13\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\1\uffff\1\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1"+
            "\13\uffff\1\1\10\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "3263:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA56_eotS =
        "\15\uffff";
    static final String DFA56_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA56_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA56_maxS =
        "\1\116\1\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA56_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA56_specialS =
        "\15\uffff}>";
    static final String[] DFA56_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff"+
            "\1\5\20\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff"+
            "\1\1\10\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3726:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA86_eotS =
        "\14\uffff";
    static final String DFA86_eofS =
        "\1\uffff\4\5\3\uffff\4\5";
    static final String DFA86_minS =
        "\1\4\4\16\1\uffff\1\6\1\uffff\4\17";
    static final String DFA86_maxS =
        "\1\116\4\113\1\uffff\1\65\1\uffff\4\113";
    static final String DFA86_acceptS =
        "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA86_specialS =
        "\14\uffff}>";
    static final String[] DFA86_transitionS = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\13\uffff\4\5\15\uffff"+
            "\1\4\20\uffff\1\5\2\uffff\1\5\3\uffff\2\5",
            "\2\5\2\uffff\1\5\1\7\4\uffff\1\5\11\uffff\1\5\1\6\27\uffff"+
            "\16\5\1\uffff\2\5",
            "\2\5\2\uffff\1\5\1\7\4\uffff\1\5\11\uffff\1\5\1\6\27\uffff"+
            "\16\5\1\uffff\2\5",
            "\2\5\2\uffff\1\5\1\7\4\uffff\1\5\11\uffff\1\5\1\6\27\uffff"+
            "\16\5\1\uffff\2\5",
            "\2\5\2\uffff\1\5\1\7\4\uffff\1\5\11\uffff\1\5\1\6\27\uffff"+
            "\16\5\1\uffff\2\5",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "",
            "\1\5\2\uffff\1\5\1\7\4\uffff\1\5\12\uffff\1\5\27\uffff\16"+
            "\5\1\uffff\2\5",
            "\1\5\2\uffff\1\5\1\7\4\uffff\1\5\12\uffff\1\5\27\uffff\16"+
            "\5\1\uffff\2\5",
            "\1\5\2\uffff\1\5\1\7\4\uffff\1\5\12\uffff\1\5\27\uffff\16"+
            "\5\1\uffff\2\5",
            "\1\5\2\uffff\1\5\1\7\4\uffff\1\5\12\uffff\1\5\27\uffff\16"+
            "\5\1\uffff\2\5"
    };

    static final short[] DFA86_eot = DFA.unpackEncodedString(DFA86_eotS);
    static final short[] DFA86_eof = DFA.unpackEncodedString(DFA86_eofS);
    static final char[] DFA86_min = DFA.unpackEncodedStringToUnsignedChars(DFA86_minS);
    static final char[] DFA86_max = DFA.unpackEncodedStringToUnsignedChars(DFA86_maxS);
    static final short[] DFA86_accept = DFA.unpackEncodedString(DFA86_acceptS);
    static final short[] DFA86_special = DFA.unpackEncodedString(DFA86_specialS);
    static final short[][] DFA86_transition;

    static {
        int numStates = DFA86_transitionS.length;
        DFA86_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA86_transition[i] = DFA.unpackEncodedString(DFA86_transitionS[i]);
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = DFA86_eot;
            this.eof = DFA86_eof;
            this.min = DFA86_min;
            this.max = DFA86_max;
            this.accept = DFA86_accept;
            this.special = DFA86_special;
            this.transition = DFA86_transition;
        }
        public String getDescription() {
            return "5302:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA87_eotS =
        "\15\uffff";
    static final String DFA87_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA87_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA87_maxS =
        "\1\116\1\uffff\4\113\1\uffff\1\65\4\113\1\65";
    static final String DFA87_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA87_specialS =
        "\15\uffff}>";
    static final String[] DFA87_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff"+
            "\1\5\20\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\1\1\2\uffff\1\1\5\uffff\1\1\11\uffff\1\7\1\1\27\uffff"+
            "\16\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\1\1\5\uffff\1\1\11\uffff\1\7\1\1\27\uffff"+
            "\16\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\1\1\5\uffff\1\1\11\uffff\1\7\1\1\27\uffff"+
            "\16\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\1\1\5\uffff\1\1\11\uffff\1\7\1\1\27\uffff"+
            "\16\1\1\uffff\2\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\1\1\2\uffff\1\1\17\uffff\1\14\1\1\27\uffff\16\1\1\uffff"+
            "\2\1",
            "\1\6\1\1\2\uffff\1\1\17\uffff\1\14\1\1\27\uffff\16\1\1\uffff"+
            "\2\1",
            "\1\6\1\1\2\uffff\1\1\17\uffff\1\14\1\1\27\uffff\16\1\1\uffff"+
            "\2\1",
            "\1\6\1\1\2\uffff\1\1\17\uffff\1\14\1\1\27\uffff\16\1\1\uffff"+
            "\2\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "5346:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleVariabilityUnit_in_entryRuleVariabilityUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariabilityUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProject_in_ruleVariabilityUnit149 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleProject_in_entryRuleProject186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProject196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleProject233 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleProject254 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleProject266 = new BitSet(new long[]{0x00FB3FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleProject287 = new BitSet(new long[]{0x00FB3FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleImportStmt_in_ruleProject309 = new BitSet(new long[]{0x00FB3FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleConflictStmt_in_ruleProject331 = new BitSet(new long[]{0x00F33FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_ruleProject353 = new BitSet(new long[]{0x00E33FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleProjectContents_in_ruleProject375 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleProject387 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleProject400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProjectContents_in_entryRuleProjectContents438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProjectContents448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedef_in_ruleProjectContents507 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleProjectContents534 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleFreeze_in_ruleProjectContents561 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleEval_in_ruleProjectContents588 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleProjectContents615 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAnnotateTo_in_ruleProjectContents642 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleOpDefStatement_in_ruleProjectContents669 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleProjectContents696 = new BitSet(new long[]{0x00E13FF3E9B241F2L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleTypedef_in_entryRuleTypedef734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedef744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnum_in_ruleTypedef790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefCompound_in_ruleTypedef817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefMapping_in_ruleTypedef844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnum_in_entryRuleTypedefEnum880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefEnum890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTypedefEnum927 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefEnum948 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTypedefEnum960 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum981 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTypedefEnum994 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum1015 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTypedefEnum1029 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_ruleTypedefEnum1050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTypedefEnum1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_entryRuleTypedefEnumLiteral1099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefEnumLiteral1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefEnumLiteral1155 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleTypedefEnumLiteral1168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleTypedefEnumLiteral1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefCompound_in_entryRuleTypedefCompound1227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefCompound1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleTypedefCompound1280 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTypedefCompound1306 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefCompound1327 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_22_in_ruleTypedefCompound1340 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefCompound1361 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTypedefCompound1375 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleTypedefCompound1397 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleTypedefCompound1424 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleTypedefCompound1451 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_15_in_ruleTypedefCompound1465 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleTypedefCompound1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_entryRuleAttrAssignment1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrAssignment1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAttrAssignment1563 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAttrAssignment1575 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1596 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_18_in_ruleAttrAssignment1609 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1630 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_25_in_ruleAttrAssignment1644 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAttrAssignment1656 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAttrAssignment1668 = new BitSet(new long[]{0x00E13FF3E9B241F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleAttrAssignment1690 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleAttrAssignment1717 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleAttrAssignment1744 = new BitSet(new long[]{0x00E13FF3E9B2C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_15_in_ruleAttrAssignment1758 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleAttrAssignment1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_entryRuleAttrAssignmentPart1809 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrAssignmentPart1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttrAssignmentPart1865 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttrAssignmentPart1877 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAttrAssignmentPart1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefMapping_in_entryRuleTypedefMapping1934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefMapping1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTypedefMapping1981 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefMapping2002 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypedefMapping2023 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_ruleTypedefMapping2044 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTypedefMapping2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_entryRuleTypedefConstraint2093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefConstraint2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTypedefConstraint2140 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypedefConstraint2152 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTypedefConstraint2173 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTypedefConstraint2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration2277 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2298 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleVariableDeclaration2311 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2332 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleVariableDeclaration2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationPart2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2438 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclarationPart2451 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType2510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBasicType2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBasicType2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBasicType2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBasicType2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBasicType2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType2760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleType2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleType2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_ruleType2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue2906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3054 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3072 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3107 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3125 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessName_in_entryRuleAccessName3199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessName3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAccessName3252 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAccessName3286 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue3323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleValue3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValue3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleValue3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleValue3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleValue3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleValue3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleValue3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleValue3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_entryRuleDerivedType3654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDerivedType3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleDerivedType3708 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_41_in_ruleDerivedType3745 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_42_in_ruleDerivedType3782 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDerivedType3808 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleDerivedType3829 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDerivedType3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotateTo_in_entryRuleAnnotateTo3877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotateTo3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleAnnotateTo3932 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_44_in_ruleAnnotateTo3961 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleAnnotateTo3998 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleAnnotateTo4019 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAnnotateTo4031 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAnnotateTo4052 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleAnnotateTo4065 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAnnotateTo4086 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleAnnotateTo4100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeze_in_entryRuleFreeze4136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeze4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFreeze4183 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFreeze4195 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_ruleFreeze4216 = new BitSet(new long[]{0x00200000000081C0L});
    public static final BitSet FOLLOW_15_in_ruleFreeze4229 = new BitSet(new long[]{0x0000400000010002L});
    public static final BitSet FOLLOW_46_in_ruleFreeze4242 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFreeze4254 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleFreeze4275 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleFreeze4287 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleFreeze4308 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFreeze4320 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFreeze4335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreezeStatement4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4429 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_ruleAccessName_in_ruleFreezeStatement4450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFreezeStatement4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEval_in_entryRuleEval4499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEval4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEval4546 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEval4558 = new BitSet(new long[]{0x00A100F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleEval_in_ruleEval4579 = new BitSet(new long[]{0x00A100F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleEval4601 = new BitSet(new long[]{0x00A000F00100C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_15_in_ruleEval4614 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleEval4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration4665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDeclaration4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInterfaceDeclaration4712 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration4733 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInterfaceDeclaration4745 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_ruleExport_in_ruleInterfaceDeclaration4766 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInterfaceDeclaration4779 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceDeclaration4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport4830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleExport4877 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleExport4898 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleExport4911 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleExport4932 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleExport4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStmt_in_entryRuleImportStmt4982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStmt4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleImportStmt5029 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5050 = new BitSet(new long[]{0x0000000410010000L});
    public static final BitSet FOLLOW_34_in_ruleImportStmt5063 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5084 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_28_in_ruleImportStmt5099 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleImportStmt5120 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleImportStmt5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConflictStmt5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleConflictStmt5217 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleConflictStmt5238 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_28_in_ruleConflictStmt5251 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConflictStmt5272 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConflictStmt5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt5322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVersionStmt5369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt5386 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVersionStmt5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement5439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefStatement5449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpDefStatement5486 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefStatement5507 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefStatement5528 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleOpDefStatement5540 = new BitSet(new long[]{0x00200703E20001C0L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement5561 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpDefStatement5573 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOpDefStatement5585 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefStatement5606 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOpDefStatement5618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList5654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameterList5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5723 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleOpDefParameterList5736 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5757 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter5797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameter5807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefParameter5853 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefParameter5874 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleOpDefParameter5887 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefParameter5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement5946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement6002 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleExpressionStatement6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression6050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression6106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_ruleExpression6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpression6160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression6196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression6206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleLetExpression6243 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLetExpression6264 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLetExpression6285 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLetExpression6297 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression6318 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleLetExpression6330 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression6351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression6387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression6397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression6443 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression6464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart6501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpressionPart6511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart6557 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart6606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator6644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentOperator6655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentOperator6692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression6731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpression6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression6787 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression6808 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart6845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpressionPart6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart6901 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart6922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator6959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationOperator6970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleImplicationOperator7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleImplicationOperator7027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression7077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7123 = new BitSet(new long[]{0x3800000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression7144 = new BitSet(new long[]{0x3800000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart7181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart7191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart7237 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart7258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator7295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator7306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleLogicalOperator7344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleLogicalOperator7363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleLogicalOperator7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression7422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression7432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression7478 = new BitSet(new long[]{0xC000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression7499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart7536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart7546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart7592 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart7614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart7641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator7679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator7690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleEqualityOperator7728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleEqualityOperator7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleEqualityOperator7766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression7806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression7816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression7862 = new BitSet(new long[]{0x0000000000000002L,0x000000000000001EL});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart7920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart7930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart7976 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart7997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator8045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleRelationalOperator8083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleRelationalOperator8102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRelationalOperator8121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator8140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression8180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression8236 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression8257 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart8294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart8304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart8350 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart8371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator8408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator8419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleAdditiveOperator8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator8476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression8516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression8526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression8572 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression8593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart8630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart8640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart8686 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart8707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator8744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator8755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplicativeOperator8793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator8812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression8852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression8862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression8908 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression8930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator8967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator8978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleUnaryOperator9016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleUnaryOperator9035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression9085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePostfixExpression9132 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePostfixExpression9153 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePostfixExpression9175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression9204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall9240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall9250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCall9288 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleCall9309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleCall9329 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleSetOp_in_ruleCall9350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleCall9370 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCall9391 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCall9403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall9440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall9450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleFeatureCall9496 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCall9508 = new BitSet(new long[]{0x00A000F0030041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_ruleFeatureCall9529 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCall9542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetOp_in_entryRuleSetOp9578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetOp9588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleSetOp9634 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSetOp9646 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleSetOp9667 = new BitSet(new long[]{0x00A000F0030041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSetOp9688 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSetOp9701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator9737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator9747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator9793 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_16_in_ruleDeclarator9806 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator9827 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_47_in_ruleDeclarator9841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration9877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration9887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration9933 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration9955 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleDeclaration9968 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration9989 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_19_in_ruleDeclaration10004 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclaration10025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActualParameterList10073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList10119 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleActualParameterList10132 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList10153 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess10191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionAccess10201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleExpressionAccess10238 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionAccess10259 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_ruleExpressionAccess10280 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess10302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression10339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression10349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression10396 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression10415 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression10436 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression10448 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression10476 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_77_in_rulePrimaryExpression10495 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression10507 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression10528 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression10540 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePrimaryExpression10563 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression10585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer10622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionInitializer10632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer10690 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCollectionInitializer10703 = new BitSet(new long[]{0x00A000F00100C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer10724 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCollectionInitializer10737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange10773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListOrRange10783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10829 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleExpressionListOrRange10842 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10863 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry10901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListEntry10911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10958 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_35_in_ruleExpressionListEntry10971 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10992 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleExpressionListEntry11006 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral11094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral11104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleLiteral11149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression11184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression11194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleIfExpression11231 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11252 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleIfExpression11264 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleIfExpression11297 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleIfExpression11330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier11367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier11378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier11418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier11444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier11470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleIdentifier11494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred2_InternalIvml287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred45_InternalIvml3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred50_InternalIvml3599 = new BitSet(new long[]{0x0000000000000002L});

}