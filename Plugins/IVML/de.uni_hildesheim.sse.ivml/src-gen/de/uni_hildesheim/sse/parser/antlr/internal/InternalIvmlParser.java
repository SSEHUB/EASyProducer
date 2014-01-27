package de.uni_hildesheim.sse.parser.antlr.internal; 

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

import de.uni_hildesheim.sse.services.IvmlGrammarAccess;
@SuppressWarnings("all")
public class InternalIvmlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_DSL_CONTENT", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'::'", "'.'", "'true'", "'false'", "'refby'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'DSL'", "'attribute'", "'freeze'", "'but'", "'*'", "'eval'", "'interface'", "'export'", "'import'", "'conflicts'", "'.version'", "'=='", "'>'", "'<'", "'>='", "'<='", "'version'", "'def'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'/'", "'not'", "'->'", "'['", "']'", "'|'", "':'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=8;
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
    public static final int RULE_DSL_CONTENT=6;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int RULE_VERSION=7;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NUMBER=4;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_EXPONENT=9;
    public static final int T__39=39;
    public static final int RULE_WS=12;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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

                if ( (LA1_0==14) ) {
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
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleProject233); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleProject266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:160:1: ( (lv_version_3_0= ruleVersionStmt ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==59) ) {
                alt2=1;
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

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleProject387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:254:1: (otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:254:3: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleProject400); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:275:1: ruleProjectContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:278:28: ( ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:279:2: () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
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
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAttributeTo ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAttributeTo ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:384:1: (lv_elements_6_0= ruleAttributeTo )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:384:1: (lv_elements_6_0= ruleAttributeTo )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:385:3: lv_elements_6_0= ruleAttributeTo
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAttributeToParserRuleCall_1_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttributeTo_in_ruleProjectContents642);
            	    lv_elements_6_0=ruleAttributeTo();

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
            	              		"AttributeTo");
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
            case 18:
                {
                alt8=1;
                }
                break;
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
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleTypedefEnum927); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleTypedefEnum960); if (state.failed) return current;
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

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:581:4: otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleTypedefEnum994); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleTypedefEnum1029); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleTypedefEnum1063); if (state.failed) return current;
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

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:668:4: otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleTypedefEnumLiteral1168); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:707:1: ruleTypedefCompound returns [EObject current=null] : (otherlv_0= 'compound' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )? otherlv_4= '{' ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )* otherlv_8= '}' (otherlv_9= ';' )? ) ;
    public final EObject ruleTypedefCompound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_super_3_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:710:28: ( (otherlv_0= 'compound' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )? otherlv_4= '{' ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )* otherlv_8= '}' (otherlv_9= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:1: (otherlv_0= 'compound' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )? otherlv_4= '{' ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )* otherlv_8= '}' (otherlv_9= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:1: (otherlv_0= 'compound' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )? otherlv_4= '{' ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )* otherlv_8= '}' (otherlv_9= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:711:3: otherlv_0= 'compound' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )? otherlv_4= '{' ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )* otherlv_8= '}' (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleTypedefCompound1274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefCompoundAccess().getCompoundKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:715:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:716:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:716:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:717:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefCompound1295);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:733:2: (otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:733:4: otherlv_2= 'refines' ( (lv_super_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTypedefCompound1308); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTypedefCompoundAccess().getRefinesKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:737:1: ( (lv_super_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:738:1: (lv_super_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:738:1: (lv_super_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:739:3: lv_super_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefCompound1329);
                    lv_super_3_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                      	        }
                             		set(
                             			current, 
                             			"super",
                              		lv_super_3_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypedefCompound1343); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTypedefCompoundAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:759:1: ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )*
            loop13:
            do {
                int alt13=4;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:759:2: ( (lv_elements_5_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:759:2: ( (lv_elements_5_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:760:1: (lv_elements_5_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:760:1: (lv_elements_5_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:761:3: lv_elements_5_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleTypedefCompound1365);
            	    lv_elements_5_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_5_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:778:6: ( (lv_elements_6_0= ruleExpressionStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:778:6: ( (lv_elements_6_0= ruleExpressionStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:779:1: (lv_elements_6_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:779:1: (lv_elements_6_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:780:3: lv_elements_6_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleTypedefCompound1392);
            	    lv_elements_6_0=ruleExpressionStatement();

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
            	              		"ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:797:6: ( (lv_elements_7_0= ruleAttrAssignment ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:797:6: ( (lv_elements_7_0= ruleAttrAssignment ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:798:1: (lv_elements_7_0= ruleAttrAssignment )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:798:1: (lv_elements_7_0= ruleAttrAssignment )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:799:3: lv_elements_7_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsAttrAssignmentParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignment_in_ruleTypedefCompound1419);
            	    lv_elements_7_0=ruleAttrAssignment();

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
            	              		"AttrAssignment");
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

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleTypedefCompound1433); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getTypedefCompoundAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:819:1: (otherlv_9= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:819:3: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleTypedefCompound1446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_6());
                          
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:831:1: entryRuleAttrAssignment returns [EObject current=null] : iv_ruleAttrAssignment= ruleAttrAssignment EOF ;
    public final EObject entryRuleAttrAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignment = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:832:2: (iv_ruleAttrAssignment= ruleAttrAssignment EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:833:2: iv_ruleAttrAssignment= ruleAttrAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAttrAssignment_in_entryRuleAttrAssignment1484);
            iv_ruleAttrAssignment=ruleAttrAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrAssignment1494); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:840:1: ruleAttrAssignment returns [EObject current=null] : (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:843:28: ( (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:844:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:844:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:844:3: otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleAttrAssignment1531); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAssignmentAccess().getAssignKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleAttrAssignment1543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:852:1: ( (lv_parts_2_0= ruleAttrAssignmentPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:853:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:853:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:854:3: lv_parts_2_0= ruleAttrAssignmentPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1564);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:870:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==19) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:870:4: otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleAttrAssignment1577); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getAttrAssignmentAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:874:1: ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:875:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:875:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:876:3: lv_parts_4_0= ruleAttrAssignmentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1598);
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
            	    break loop15;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAttrAssignment1612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAttrAssignmentAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleAttrAssignment1624); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAttrAssignmentAccess().getToKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAttrAssignment1636); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAttrAssignmentAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:904:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=4;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:904:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:904:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:905:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:905:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:906:3: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleAttrAssignment1658);
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
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:923:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:923:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:924:1: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:924:1: (lv_elements_9_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:925:3: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleAttrAssignment1685);
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
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:942:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:942:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:943:1: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:943:1: (lv_elements_10_0= ruleAttrAssignment )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:944:3: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsAttrAssignmentParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttrAssignment_in_ruleAttrAssignment1712);
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
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleAttrAssignment1726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAttrAssignmentAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:964:1: (otherlv_12= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:964:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleAttrAssignment1739); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:976:1: entryRuleAttrAssignmentPart returns [EObject current=null] : iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF ;
    public final EObject entryRuleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignmentPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:977:2: (iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:978:2: iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentPartRule()); 
            }
            pushFollow(FOLLOW_ruleAttrAssignmentPart_in_entryRuleAttrAssignmentPart1777);
            iv_ruleAttrAssignmentPart=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignmentPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrAssignmentPart1787); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:985:1: ruleAttrAssignmentPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) ;
    public final EObject ruleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:988:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:989:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:989:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:989:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:989:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:990:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:990:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:991:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleAttrAssignmentPart1833);
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

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleAttrAssignmentPart1845); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentPartAccess().getEqualsSignKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1011:1: ( (lv_value_2_0= ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1012:1: (lv_value_2_0= ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1012:1: (lv_value_2_0= ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1013:3: lv_value_2_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getValueLogicalExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAttrAssignmentPart1866);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1037:1: entryRuleTypedefMapping returns [EObject current=null] : iv_ruleTypedefMapping= ruleTypedefMapping EOF ;
    public final EObject entryRuleTypedefMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefMapping = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1038:2: (iv_ruleTypedefMapping= ruleTypedefMapping EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1039:2: iv_ruleTypedefMapping= ruleTypedefMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefMappingRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefMapping_in_entryRuleTypedefMapping1902);
            iv_ruleTypedefMapping=ruleTypedefMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefMapping; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefMapping1912); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1046:1: ruleTypedefMapping returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) ;
    public final EObject ruleTypedefMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newType_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_constraint_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1049:28: ( (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1050:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1050:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1050:3: otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTypedefMapping1949); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefMappingAccess().getTypedefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1054:1: ( (lv_newType_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1055:1: (lv_newType_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1055:1: (lv_newType_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1056:3: lv_newType_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getNewTypeIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypedefMapping1970);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1072:2: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1073:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1073:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1074:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypedefMapping1991);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1090:2: ( (lv_constraint_3_0= ruleTypedefConstraint ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1091:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1091:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1092:3: lv_constraint_3_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getConstraintTypedefConstraintParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypedefConstraint_in_ruleTypedefMapping2012);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTypedefMapping2025); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1120:1: entryRuleTypedefConstraint returns [EObject current=null] : iv_ruleTypedefConstraint= ruleTypedefConstraint EOF ;
    public final EObject entryRuleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefConstraint = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1121:2: (iv_ruleTypedefConstraint= ruleTypedefConstraint EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1122:2: iv_ruleTypedefConstraint= ruleTypedefConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleTypedefConstraint_in_entryRuleTypedefConstraint2061);
            iv_ruleTypedefConstraint=ruleTypedefConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedefConstraint2071); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1129:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expressions_2_0 = null;

        EObject lv_expressions_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1132:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1133:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1133:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1133:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleTypedefConstraint2108); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefConstraintAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTypedefConstraint2120); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefConstraintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1141:1: ( (lv_expressions_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1142:1: (lv_expressions_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1142:1: (lv_expressions_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1143:3: lv_expressions_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleTypedefConstraint2141);
            lv_expressions_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefConstraintRule());
              	        }
                     		add(
                     			current, 
                     			"expressions",
                      		lv_expressions_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1159:2: (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==19) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1159:4: otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleTypedefConstraint2154); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTypedefConstraintAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1163:1: ( (lv_expressions_4_0= ruleExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1164:1: (lv_expressions_4_0= ruleExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1164:1: (lv_expressions_4_0= ruleExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1165:3: lv_expressions_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleTypedefConstraint2175);
            	    lv_expressions_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefConstraintRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_4_0, 
            	              		"Expression");
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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleTypedefConstraint2189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTypedefConstraintAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1193:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1194:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1195:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2225);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2235); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1202:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1205:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1206:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1206:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1206:2: ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1206:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1207:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1207:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1208:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration2281);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1224:2: ( (lv_decls_1_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1225:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1225:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1226:3: lv_decls_1_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2302);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1242:2: (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1242:4: otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleVariableDeclaration2315); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1246:1: ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1247:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1247:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1248:3: lv_decls_3_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2336);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleVariableDeclaration2350); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1276:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1277:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1278:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationPartRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2386);
            iv_ruleVariableDeclarationPart=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclarationPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationPart2396); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1285:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1288:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1289:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1289:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1290:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1290:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1291:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2442);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1307:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1307:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleVariableDeclarationPart2455); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1311:1: ( (lv_default_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1312:1: (lv_default_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1312:1: (lv_default_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1313:3: lv_default_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getDefaultExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2476);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1337:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1338:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1339:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType2514);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType2524); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1346:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1349:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1350:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1350:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1350:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1350:2: ( (lv_type_0_0= 'Integer' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1351:1: (lv_type_0_0= 'Integer' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1351:1: (lv_type_0_0= 'Integer' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1352:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,29,FOLLOW_29_in_ruleBasicType2567); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1366:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1366:6: ( (lv_type_1_0= 'Real' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1367:1: (lv_type_1_0= 'Real' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1367:1: (lv_type_1_0= 'Real' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1368:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,30,FOLLOW_30_in_ruleBasicType2604); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1382:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1382:6: ( (lv_type_2_0= 'Boolean' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1383:1: (lv_type_2_0= 'Boolean' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1383:1: (lv_type_2_0= 'Boolean' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1384:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,31,FOLLOW_31_in_ruleBasicType2641); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1398:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1398:6: ( (lv_type_3_0= 'String' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1399:1: (lv_type_3_0= 'String' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1399:1: (lv_type_3_0= 'String' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1400:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,32,FOLLOW_32_in_ruleBasicType2678); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1414:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1414:6: ( (lv_type_4_0= 'Constraint' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1415:1: (lv_type_4_0= 'Constraint' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1415:1: (lv_type_4_0= 'Constraint' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1416:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,33,FOLLOW_33_in_ruleBasicType2715); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1437:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1438:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1439:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType2764);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType2774); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1446:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1449:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1450:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1450:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1450:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1450:2: ( (lv_type_0_0= ruleBasicType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1451:1: (lv_type_0_0= ruleBasicType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1451:1: (lv_type_0_0= ruleBasicType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1452:3: lv_type_0_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeBasicTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_ruleType2820);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1469:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1469:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1470:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1470:1: (lv_id_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1471:3: lv_id_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getIdQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleType2847);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1488:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1488:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1489:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1489:1: (lv_derived_2_0= ruleDerivedType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1490:3: lv_derived_2_0= ruleDerivedType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getDerivedDerivedTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDerivedType_in_ruleType2874);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1514:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1515:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1516:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue2910);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue2920); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1523:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1526:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1527:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1527:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1528:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1528:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1529:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue2961); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1553:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1554:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1555:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3001);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3011); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1562:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1565:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
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
            }

            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1566:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1567:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1567:1: (lv_qName_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1568:3: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3058);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1584:2: ( (lv_qName_1_0= '::' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1585:1: (lv_qName_1_0= '::' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1585:1: (lv_qName_1_0= '::' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1586:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3076); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1599:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
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

                        }

                        switch (alt24) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1599:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1599:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1600:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1600:1: (lv_qName_2_0= ruleIdentifier )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1601:3: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3111);
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

                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1617:2: ( (lv_qName_3_0= '::' ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1618:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1618:1: (lv_qName_3_0= '::' )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1619:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3129); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1632:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1633:1: (lv_qName_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1633:1: (lv_qName_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1634:3: lv_qName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3167);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1658:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1659:2: (iv_ruleAccessName= ruleAccessName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1660:2: iv_ruleAccessName= ruleAccessName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessNameRule()); 
            }
            pushFollow(FOLLOW_ruleAccessName_in_entryRuleAccessName3203);
            iv_ruleAccessName=ruleAccessName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessName3213); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1667:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1670:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1671:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1671:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
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
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1671:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1671:2: ( (lv_aName_0_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1672:1: (lv_aName_0_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1672:1: (lv_aName_0_0= '.' )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1673:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,35,FOLLOW_35_in_ruleAccessName3256); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1686:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1687:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1687:1: (lv_aName_1_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1688:3: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAccessName3290);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1712:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1713:2: (iv_ruleValue= ruleValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1714:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue3327);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue3337); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1721:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' ) | ( (lv_nullValue_8_0= 'null' ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_nullValue_8_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;

        AntlrDatatypeRuleToken lv_rValue_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1724:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' ) | ( (lv_nullValue_8_0= 'null' ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1725:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' ) | ( (lv_nullValue_8_0= 'null' ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1725:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' ) | ( (lv_nullValue_8_0= 'null' ) ) )
            int alt28=6;
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
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt28=3;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1725:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1725:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1726:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1726:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1727:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleValue3383);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1744:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1744:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1745:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1745:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1746:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValue3406); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1763:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1763:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1764:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1764:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1765:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleValue3438);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1782:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1782:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1783:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1783:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1784:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1784:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
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
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1785:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,36,FOLLOW_36_in_ruleValue3464); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1797:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,37,FOLLOW_37_in_ruleValue3493); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1813:6: (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1813:6: (otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1813:8: otherlv_4= 'refby' otherlv_5= '(' ( (lv_rValue_6_0= ruleIdentifier ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleValue3528); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getValueAccess().getRefbyKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleValue3540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getValueAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1821:1: ( (lv_rValue_6_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1822:1: (lv_rValue_6_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1822:1: (lv_rValue_6_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1823:3: lv_rValue_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getRValueIdentifierParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleValue3561);
                    lv_rValue_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
                      	        }
                             		set(
                             			current, 
                             			"rValue",
                              		lv_rValue_6_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleValue3573); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getValueAccess().getRightParenthesisKeyword_4_3());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1844:6: ( (lv_nullValue_8_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1844:6: ( (lv_nullValue_8_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1845:1: (lv_nullValue_8_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1845:1: (lv_nullValue_8_0= 'null' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1846:3: lv_nullValue_8_0= 'null'
                    {
                    lv_nullValue_8_0=(Token)match(input,39,FOLLOW_39_in_ruleValue3598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_nullValue_8_0, grammarAccess.getValueAccess().getNullValueNullKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "nullValue", lv_nullValue_8_0, "null");
                      	    
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1867:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1868:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1869:2: iv_ruleDerivedType= ruleDerivedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerivedTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDerivedType_in_entryRuleDerivedType3647);
            iv_ruleDerivedType=ruleDerivedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDerivedType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDerivedType3657); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1876:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1879:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1880:3: ( (lv_op_0_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1881:1: (lv_op_0_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1881:1: (lv_op_0_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1882:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,40,FOLLOW_40_in_ruleDerivedType3701); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1896:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1896:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1897:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1897:1: (lv_op_1_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1898:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,41,FOLLOW_41_in_ruleDerivedType3738); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1912:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1912:6: ( (lv_op_2_0= 'refTo' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1913:1: (lv_op_2_0= 'refTo' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1913:1: (lv_op_2_0= 'refTo' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1914:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,42,FOLLOW_42_in_ruleDerivedType3775); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDerivedType3801); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1931:1: ( (lv_type_4_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1932:1: (lv_type_4_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1932:1: (lv_type_4_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1933:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleDerivedType3822);
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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleDerivedType3834); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDslContext"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1961:1: entryRuleDslContext returns [EObject current=null] : iv_ruleDslContext= ruleDslContext EOF ;
    public final EObject entryRuleDslContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDslContext = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1962:2: (iv_ruleDslContext= ruleDslContext EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1963:2: iv_ruleDslContext= ruleDslContext EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDslContextRule()); 
            }
            pushFollow(FOLLOW_ruleDslContext_in_entryRuleDslContext3870);
            iv_ruleDslContext=ruleDslContext();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDslContext; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDslContext3880); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDslContext"


    // $ANTLR start "ruleDslContext"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1970:1: ruleDslContext returns [EObject current=null] : (otherlv_0= 'DSL' otherlv_1= '(' ( (lv_stop_2_0= RULE_STRING ) ) otherlv_3= ',' ( (lv_escape_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_command_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_dsl_8_0= RULE_DSL_CONTENT ) ) ) ;
    public final EObject ruleDslContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_stop_2_0=null;
        Token otherlv_3=null;
        Token lv_escape_4_0=null;
        Token otherlv_5=null;
        Token lv_command_6_0=null;
        Token otherlv_7=null;
        Token lv_dsl_8_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1973:28: ( (otherlv_0= 'DSL' otherlv_1= '(' ( (lv_stop_2_0= RULE_STRING ) ) otherlv_3= ',' ( (lv_escape_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_command_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_dsl_8_0= RULE_DSL_CONTENT ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1974:1: (otherlv_0= 'DSL' otherlv_1= '(' ( (lv_stop_2_0= RULE_STRING ) ) otherlv_3= ',' ( (lv_escape_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_command_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_dsl_8_0= RULE_DSL_CONTENT ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1974:1: (otherlv_0= 'DSL' otherlv_1= '(' ( (lv_stop_2_0= RULE_STRING ) ) otherlv_3= ',' ( (lv_escape_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_command_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_dsl_8_0= RULE_DSL_CONTENT ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1974:3: otherlv_0= 'DSL' otherlv_1= '(' ( (lv_stop_2_0= RULE_STRING ) ) otherlv_3= ',' ( (lv_escape_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_command_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_dsl_8_0= RULE_DSL_CONTENT ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleDslContext3917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDslContextAccess().getDSLKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleDslContext3929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDslContextAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1982:1: ( (lv_stop_2_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1983:1: (lv_stop_2_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1983:1: (lv_stop_2_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1984:3: lv_stop_2_0= RULE_STRING
            {
            lv_stop_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDslContext3946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_stop_2_0, grammarAccess.getDslContextAccess().getStopSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDslContextRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"stop",
                      		lv_stop_2_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleDslContext3963); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDslContextAccess().getCommaKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2004:1: ( (lv_escape_4_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2005:1: (lv_escape_4_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2005:1: (lv_escape_4_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2006:3: lv_escape_4_0= RULE_STRING
            {
            lv_escape_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDslContext3980); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_escape_4_0, grammarAccess.getDslContextAccess().getEscapeSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDslContextRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"escape",
                      		lv_escape_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleDslContext3997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDslContextAccess().getCommaKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2026:1: ( (lv_command_6_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2027:1: (lv_command_6_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2027:1: (lv_command_6_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2028:3: lv_command_6_0= RULE_STRING
            {
            lv_command_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDslContext4014); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_command_6_0, grammarAccess.getDslContextAccess().getCommandSTRINGTerminalRuleCall_6_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDslContextRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"command",
                      		lv_command_6_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleDslContext4031); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getDslContextAccess().getRightParenthesisKeyword_7());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2048:1: ( (lv_dsl_8_0= RULE_DSL_CONTENT ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2049:1: (lv_dsl_8_0= RULE_DSL_CONTENT )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2049:1: (lv_dsl_8_0= RULE_DSL_CONTENT )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2050:3: lv_dsl_8_0= RULE_DSL_CONTENT
            {
            lv_dsl_8_0=(Token)match(input,RULE_DSL_CONTENT,FOLLOW_RULE_DSL_CONTENT_in_ruleDslContext4048); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_dsl_8_0, grammarAccess.getDslContextAccess().getDslDSL_CONTENTTerminalRuleCall_8_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDslContextRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"dsl",
                      		lv_dsl_8_0, 
                      		"DSL_CONTENT");
              	    
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
    // $ANTLR end "ruleDslContext"


    // $ANTLR start "entryRuleAttributeTo"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2074:1: entryRuleAttributeTo returns [EObject current=null] : iv_ruleAttributeTo= ruleAttributeTo EOF ;
    public final EObject entryRuleAttributeTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeTo = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2075:2: (iv_ruleAttributeTo= ruleAttributeTo EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2076:2: iv_ruleAttributeTo= ruleAttributeTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeToRule()); 
            }
            pushFollow(FOLLOW_ruleAttributeTo_in_entryRuleAttributeTo4089);
            iv_ruleAttributeTo=ruleAttributeTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeTo; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeTo4099); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeTo"


    // $ANTLR start "ruleAttributeTo"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2083:1: ruleAttributeTo returns [EObject current=null] : (otherlv_0= 'attribute' ( (lv_attributeType_1_0= ruleType ) ) ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleAttributeTo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_attributeType_1_0 = null;

        EObject lv_attributeDecl_2_0 = null;

        AntlrDatatypeRuleToken lv_names_4_0 = null;

        AntlrDatatypeRuleToken lv_names_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2086:28: ( (otherlv_0= 'attribute' ( (lv_attributeType_1_0= ruleType ) ) ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2087:1: (otherlv_0= 'attribute' ( (lv_attributeType_1_0= ruleType ) ) ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2087:1: (otherlv_0= 'attribute' ( (lv_attributeType_1_0= ruleType ) ) ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2087:3: otherlv_0= 'attribute' ( (lv_attributeType_1_0= ruleType ) ) ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleAttributeTo4136); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttributeToAccess().getAttributeKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2091:1: ( (lv_attributeType_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2092:1: (lv_attributeType_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2092:1: (lv_attributeType_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2093:3: lv_attributeType_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttributeToAccess().getAttributeTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleAttributeTo4157);
            lv_attributeType_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeToRule());
              	        }
                     		set(
                     			current, 
                     			"attributeType",
                      		lv_attributeType_1_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2109:2: ( (lv_attributeDecl_2_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2110:1: (lv_attributeDecl_2_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2110:1: (lv_attributeDecl_2_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2111:3: lv_attributeDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttributeToAccess().getAttributeDeclVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleAttributeTo4178);
            lv_attributeDecl_2_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeToRule());
              	        }
                     		set(
                     			current, 
                     			"attributeDecl",
                      		lv_attributeDecl_2_0, 
                      		"VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleAttributeTo4190); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAttributeToAccess().getToKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2131:1: ( (lv_names_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2132:1: (lv_names_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2132:1: (lv_names_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2133:3: lv_names_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttributeToAccess().getNamesIdentifierParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeTo4211);
            lv_names_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeToRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2149:2: (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==19) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2149:4: otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) )
            	    {
            	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleAttributeTo4224); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAttributeToAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2153:1: ( (lv_names_6_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2154:1: (lv_names_6_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2154:1: (lv_names_6_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2155:3: lv_names_6_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttributeToAccess().getNamesIdentifierParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeTo4245);
            	    lv_names_6_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttributeToRule());
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
            	    break loop30;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleAttributeTo4259); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAttributeToAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeTo"


    // $ANTLR start "entryRuleFreeze"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2183:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2184:2: (iv_ruleFreeze= ruleFreeze EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2185:2: iv_ruleFreeze= ruleFreeze EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeRule()); 
            }
            pushFollow(FOLLOW_ruleFreeze_in_entryRuleFreeze4295);
            iv_ruleFreeze=ruleFreeze();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreeze; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeze4305); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2192:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )? (otherlv_6= ';' )? ) ;
    public final EObject ruleFreeze() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_names_2_0 = null;

        EObject lv_but_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2195:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )? (otherlv_6= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2196:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )? (otherlv_6= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2196:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )? (otherlv_6= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2196:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )? (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleFreeze4342); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleFreeze4354); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2204:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_VERSION && LA31_0<=RULE_EXPONENT)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2205:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2205:1: (lv_names_2_0= ruleFreezeStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2206:3: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFreezeStatement_in_ruleFreeze4375);
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
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleFreeze4388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2226:1: (otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2226:3: otherlv_4= 'but' ( (lv_but_5_0= ruleFreezeButList ) )
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleFreeze4401); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2230:1: ( (lv_but_5_0= ruleFreezeButList ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2231:1: (lv_but_5_0= ruleFreezeButList )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2231:1: (lv_but_5_0= ruleFreezeButList )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2232:3: lv_but_5_0= ruleFreezeButList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getButFreezeButListParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFreezeButList_in_ruleFreeze4422);
                    lv_but_5_0=ruleFreezeButList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
                      	        }
                             		set(
                             			current, 
                             			"but",
                              		lv_but_5_0, 
                              		"FreezeButList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2248:4: (otherlv_6= ';' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==17) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2248:6: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFreeze4437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFreezeAccess().getSemicolonKeyword_5());
                          
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2260:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2261:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2262:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeStatementRule()); 
            }
            pushFollow(FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4475);
            iv_ruleFreezeStatement=ruleFreezeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreezeStatement4485); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2269:1: ruleFreezeStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2272:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2273:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2273:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2273:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2273:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2274:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2274:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2275:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4531);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2291:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==35) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2292:1: (lv_access_1_0= ruleAccessName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2292:1: (lv_access_1_0= ruleAccessName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2293:3: lv_access_1_0= ruleAccessName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessName_in_ruleFreezeStatement4552);
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleFreezeStatement4565); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFreezeButList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2321:1: entryRuleFreezeButList returns [EObject current=null] : iv_ruleFreezeButList= ruleFreezeButList EOF ;
    public final EObject entryRuleFreezeButList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeButList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2322:2: (iv_ruleFreezeButList= ruleFreezeButList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2323:2: iv_ruleFreezeButList= ruleFreezeButList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeButListRule()); 
            }
            pushFollow(FOLLOW_ruleFreezeButList_in_entryRuleFreezeButList4601);
            iv_ruleFreezeButList=ruleFreezeButList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeButList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreezeButList4611); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreezeButList"


    // $ANTLR start "ruleFreezeButList"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2330:1: ruleFreezeButList returns [EObject current=null] : (otherlv_0= '(' ( (lv_list_1_0= ruleFreezeButExpression ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleFreezeButList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2333:28: ( (otherlv_0= '(' ( (lv_list_1_0= ruleFreezeButExpression ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2334:1: (otherlv_0= '(' ( (lv_list_1_0= ruleFreezeButExpression ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2334:1: (otherlv_0= '(' ( (lv_list_1_0= ruleFreezeButExpression ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2334:3: otherlv_0= '(' ( (lv_list_1_0= ruleFreezeButExpression ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleFreezeButList4648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeButListAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2338:1: ( (lv_list_1_0= ruleFreezeButExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2339:1: (lv_list_1_0= ruleFreezeButExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2339:1: (lv_list_1_0= ruleFreezeButExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2340:3: lv_list_1_0= ruleFreezeButExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeButListAccess().getListFreezeButExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFreezeButExpression_in_ruleFreezeButList4669);
            lv_list_1_0=ruleFreezeButExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFreezeButListRule());
              	        }
                     		add(
                     			current, 
                     			"list",
                      		lv_list_1_0, 
                      		"FreezeButExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2356:2: (otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==19) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2356:4: otherlv_2= ',' ( (lv_list_3_0= ruleFreezeButExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleFreezeButList4682); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getFreezeButListAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2360:1: ( (lv_list_3_0= ruleFreezeButExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2361:1: (lv_list_3_0= ruleFreezeButExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2361:1: (lv_list_3_0= ruleFreezeButExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2362:3: lv_list_3_0= ruleFreezeButExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeButListAccess().getListFreezeButExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFreezeButExpression_in_ruleFreezeButList4703);
            	    lv_list_3_0=ruleFreezeButExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFreezeButListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"list",
            	              		lv_list_3_0, 
            	              		"FreezeButExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleFreezeButList4717); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFreezeButListAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFreezeButList"


    // $ANTLR start "entryRuleFreezeButExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2390:1: entryRuleFreezeButExpression returns [EObject current=null] : iv_ruleFreezeButExpression= ruleFreezeButExpression EOF ;
    public final EObject entryRuleFreezeButExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeButExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2391:2: (iv_ruleFreezeButExpression= ruleFreezeButExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2392:2: iv_ruleFreezeButExpression= ruleFreezeButExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeButExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleFreezeButExpression_in_entryRuleFreezeButExpression4753);
            iv_ruleFreezeButExpression=ruleFreezeButExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeButExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreezeButExpression4763); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreezeButExpression"


    // $ANTLR start "ruleFreezeButExpression"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2399:1: ruleFreezeButExpression returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? ( (lv_wildcard_2_0= '*' ) )? ) ;
    public final EObject ruleFreezeButExpression() throws RecognitionException {
        EObject current = null;

        Token lv_wildcard_2_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2402:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? ( (lv_wildcard_2_0= '*' ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2403:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? ( (lv_wildcard_2_0= '*' ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2403:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? ( (lv_wildcard_2_0= '*' ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2403:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? ( (lv_wildcard_2_0= '*' ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2403:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2404:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2404:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2405:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeButExpressionAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFreezeButExpression4809);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFreezeButExpressionRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2421:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2422:1: (lv_access_1_0= ruleAccessName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2422:1: (lv_access_1_0= ruleAccessName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2423:3: lv_access_1_0= ruleAccessName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeButExpressionAccess().getAccessAccessNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessName_in_ruleFreezeButExpression4830);
                    lv_access_1_0=ruleAccessName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeButExpressionRule());
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2439:3: ( (lv_wildcard_2_0= '*' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2440:1: (lv_wildcard_2_0= '*' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2440:1: (lv_wildcard_2_0= '*' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2441:3: lv_wildcard_2_0= '*'
                    {
                    lv_wildcard_2_0=(Token)match(input,47,FOLLOW_47_in_ruleFreezeButExpression4849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_wildcard_2_0, grammarAccess.getFreezeButExpressionAccess().getWildcardAsteriskKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFreezeButExpressionRule());
                      	        }
                             		setWithLastConsumed(current, "wildcard", lv_wildcard_2_0, "*");
                      	    
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
    // $ANTLR end "ruleFreezeButExpression"


    // $ANTLR start "entryRuleEval"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2462:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2463:2: (iv_ruleEval= ruleEval EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2464:2: iv_ruleEval= ruleEval EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvalRule()); 
            }
            pushFollow(FOLLOW_ruleEval_in_entryRuleEval4899);
            iv_ruleEval=ruleEval();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEval; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEval4909); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2471:1: ruleEval returns [EObject current=null] : (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2474:28: ( (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2475:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2475:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2475:3: otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleEval4946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEvalAccess().getEvalKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleEval4958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2483:1: ( (lv_nested_2_0= ruleEval ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==48) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2484:1: (lv_nested_2_0= ruleEval )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2484:1: (lv_nested_2_0= ruleEval )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2485:3: lv_nested_2_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEval_in_ruleEval4979);
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
            	    break loop38;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2501:3: ( (lv_statements_3_0= ruleExpressionStatement ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_NUMBER && LA39_0<=RULE_STRING)||(LA39_0>=RULE_VERSION && LA39_0<=RULE_EXPONENT)||LA39_0==15||LA39_0==24||(LA39_0>=36 && LA39_0<=39)||LA39_0==43||LA39_0==61||LA39_0==71||LA39_0==73||(LA39_0>=79 && LA39_0<=80)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2502:1: (lv_statements_3_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2502:1: (lv_statements_3_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2503:3: lv_statements_3_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleEval5001);
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
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleEval5014); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2523:1: (otherlv_5= ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==17) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2523:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleEval5027); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2535:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2536:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2537:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration5065);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceDeclaration5075); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2544:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2547:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2548:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2548:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2548:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleInterfaceDeclaration5112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2552:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2553:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2553:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2554:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration5133);
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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleInterfaceDeclaration5145); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2574:1: ( (lv_exports_3_0= ruleExport ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==50) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2575:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2575:1: (lv_exports_3_0= ruleExport )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2576:3: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExport_in_ruleInterfaceDeclaration5166);
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
            	    break loop41;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleInterfaceDeclaration5179); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2596:1: (otherlv_5= ';' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==17) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2596:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleInterfaceDeclaration5192); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2608:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2609:2: (iv_ruleExport= ruleExport EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2610:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport5230);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport5240); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2617:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_names_1_0 = null;

        AntlrDatatypeRuleToken lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2620:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2621:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2621:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2621:3: otherlv_0= 'export' ( (lv_names_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleExport5277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2625:1: ( (lv_names_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2626:1: (lv_names_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2626:1: (lv_names_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2627:3: lv_names_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNamesIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleExport5298);
            lv_names_1_0=ruleIdentifier();

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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2643:2: (otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==19) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2643:4: otherlv_2= ',' ( (lv_names_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleExport5311); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2647:1: ( (lv_names_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2648:1: (lv_names_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2648:1: (lv_names_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2649:3: lv_names_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExportAccess().getNamesIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleExport5332);
            	    lv_names_3_0=ruleIdentifier();

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
            	              		"Identifier");
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleExport5346); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2677:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2678:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2679:2: iv_ruleImportStmt= ruleImportStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStmtRule()); 
            }
            pushFollow(FOLLOW_ruleImportStmt_in_entryRuleImportStmt5382);
            iv_ruleImportStmt=ruleImportStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStmt5392); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2686:1: ruleImportStmt returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )? otherlv_10= ';' ) ;
    public final EObject ruleImportStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_interface_3_0 = null;

        EObject lv_versions_6_0 = null;

        EObject lv_versions_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2689:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )? otherlv_10= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2690:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )? otherlv_10= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2690:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )? otherlv_10= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2690:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )? otherlv_10= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleImportStmt5429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2694:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2695:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2695:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2696:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5450);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2712:2: (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==34) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2712:4: otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleImportStmt5463); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2716:1: ( (lv_interface_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2717:1: (lv_interface_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2717:1: (lv_interface_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2718:3: lv_interface_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5484);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2734:4: (otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==28) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2734:6: otherlv_4= 'with' otherlv_5= '(' ( (lv_versions_6_0= ruleVersionedId ) ) (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )* otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleImportStmt5499); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImportStmtAccess().getWithKeyword_3_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleImportStmt5511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getImportStmtAccess().getLeftParenthesisKeyword_3_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2742:1: ( (lv_versions_6_0= ruleVersionedId ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2743:1: (lv_versions_6_0= ruleVersionedId )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2743:1: (lv_versions_6_0= ruleVersionedId )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2744:3: lv_versions_6_0= ruleVersionedId
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getVersionsVersionedIdParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionedId_in_ruleImportStmt5532);
                    lv_versions_6_0=ruleVersionedId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      	        }
                             		add(
                             			current, 
                             			"versions",
                              		lv_versions_6_0, 
                              		"VersionedId");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2760:2: (otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==19) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2760:4: otherlv_7= ',' ( (lv_versions_8_0= ruleVersionedId ) )
                    	    {
                    	    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleImportStmt5545); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getImportStmtAccess().getCommaKeyword_3_3_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2764:1: ( (lv_versions_8_0= ruleVersionedId ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2765:1: (lv_versions_8_0= ruleVersionedId )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2765:1: (lv_versions_8_0= ruleVersionedId )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2766:3: lv_versions_8_0= ruleVersionedId
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getImportStmtAccess().getVersionsVersionedIdParserRuleCall_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleVersionedId_in_ruleImportStmt5566);
                    	    lv_versions_8_0=ruleVersionedId();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"versions",
                    	              		lv_versions_8_0, 
                    	              		"VersionedId");
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

                    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleImportStmt5580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getImportStmtAccess().getRightParenthesisKeyword_3_4());
                          
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleImportStmt5594); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getImportStmtAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2798:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2799:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2800:2: iv_ruleConflictStmt= ruleConflictStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConflictStmtRule()); 
            }
            pushFollow(FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5630);
            iv_ruleConflictStmt=ruleConflictStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConflictStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConflictStmt5640); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2807:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )? otherlv_8= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_conflicts_4_0 = null;

        EObject lv_conflicts_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2810:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )? otherlv_8= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2811:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )? otherlv_8= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2811:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )? otherlv_8= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2811:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleConflictStmt5677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2815:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2816:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2816:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2817:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConflictStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleConflictStmt5698);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2833:2: (otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==28) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2833:4: otherlv_2= 'with' otherlv_3= '(' ( (lv_conflicts_4_0= ruleVersionedId ) ) (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )* otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleConflictStmt5711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleConflictStmt5723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getConflictStmtAccess().getLeftParenthesisKeyword_2_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2841:1: ( (lv_conflicts_4_0= ruleVersionedId ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2842:1: (lv_conflicts_4_0= ruleVersionedId )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2842:1: (lv_conflicts_4_0= ruleVersionedId )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2843:3: lv_conflicts_4_0= ruleVersionedId
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getConflictsVersionedIdParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionedId_in_ruleConflictStmt5744);
                    lv_conflicts_4_0=ruleVersionedId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2859:2: (otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==19) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2859:4: otherlv_5= ',' ( (lv_conflicts_6_0= ruleVersionedId ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleConflictStmt5757); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getConflictStmtAccess().getCommaKeyword_2_3_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2863:1: ( (lv_conflicts_6_0= ruleVersionedId ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2864:1: (lv_conflicts_6_0= ruleVersionedId )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2864:1: (lv_conflicts_6_0= ruleVersionedId )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2865:3: lv_conflicts_6_0= ruleVersionedId
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getConflictsVersionedIdParserRuleCall_2_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleVersionedId_in_ruleConflictStmt5778);
                    	    lv_conflicts_6_0=ruleVersionedId();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"conflicts",
                    	              		lv_conflicts_6_0, 
                    	              		"VersionedId");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleConflictStmt5792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getConflictStmtAccess().getRightParenthesisKeyword_2_4());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleConflictStmt5806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getConflictStmtAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleVersionedId"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2897:1: entryRuleVersionedId returns [EObject current=null] : iv_ruleVersionedId= ruleVersionedId EOF ;
    public final EObject entryRuleVersionedId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionedId = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2898:2: (iv_ruleVersionedId= ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2899:2: iv_ruleVersionedId= ruleVersionedId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionedIdRule()); 
            }
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId5842);
            iv_ruleVersionedId=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionedId; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId5852); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2906:1: ruleVersionedId returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '.version' ( (lv_op_2_0= ruleVersionOperator ) ) ( (lv_version_3_0= RULE_VERSION ) ) ) ;
    public final EObject ruleVersionedId() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_version_3_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2909:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '.version' ( (lv_op_2_0= ruleVersionOperator ) ) ( (lv_version_3_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2910:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '.version' ( (lv_op_2_0= ruleVersionOperator ) ) ( (lv_version_3_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2910:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '.version' ( (lv_op_2_0= ruleVersionOperator ) ) ( (lv_version_3_0= RULE_VERSION ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2910:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '.version' ( (lv_op_2_0= ruleVersionOperator ) ) ( (lv_version_3_0= RULE_VERSION ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2910:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2911:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2911:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2912:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVersionedId5898);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionedIdRule());
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

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleVersionedId5910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVersionedIdAccess().getVersionKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2932:1: ( (lv_op_2_0= ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2933:1: (lv_op_2_0= ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2933:1: (lv_op_2_0= ruleVersionOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2934:3: lv_op_2_0= ruleVersionOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_ruleVersionedId5931);
            lv_op_2_0=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionedIdRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_2_0, 
                      		"VersionOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2950:2: ( (lv_version_3_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2951:1: (lv_version_3_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2951:1: (lv_version_3_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2952:3: lv_version_3_0= RULE_VERSION
            {
            lv_version_3_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionedId5948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_version_3_0, grammarAccess.getVersionedIdAccess().getVersionVERSIONTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVersionedIdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"version",
                      		lv_version_3_0, 
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2976:1: entryRuleVersionOperator returns [String current=null] : iv_ruleVersionOperator= ruleVersionOperator EOF ;
    public final String entryRuleVersionOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2977:2: (iv_ruleVersionOperator= ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2978:2: iv_ruleVersionOperator= ruleVersionOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator5990);
            iv_ruleVersionOperator=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator6001); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2985:1: ruleVersionOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleVersionOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2988:28: ( (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2989:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2989:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt49=5;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt49=1;
                }
                break;
            case 55:
                {
                alt49=2;
                }
                break;
            case 56:
                {
                alt49=3;
                }
                break;
            case 57:
                {
                alt49=4;
                }
                break;
            case 58:
                {
                alt49=5;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2990:2: kw= '=='
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleVersionOperator6039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2997:2: kw= '>'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleVersionOperator6058); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3004:2: kw= '<'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleVersionOperator6077); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3011:2: kw= '>='
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleVersionOperator6096); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3018:2: kw= '<='
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleVersionOperator6115); if (state.failed) return current;
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


    // $ANTLR start "entryRuleVersionStmt"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3031:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3032:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3033:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt6155);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt6165); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3040:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3043:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3044:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3044:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3044:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleVersionStmt6202); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3048:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3049:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3049:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3050:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt6219); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleVersionStmt6236); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3078:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3079:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3080:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefStatementRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement6272);
            iv_ruleOpDefStatement=ruleOpDefStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefStatement6282); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3087:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3090:28: ( (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3091:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3091:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3091:3: otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleOpDefStatement6319); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3095:1: ( (lv_result_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3096:1: (lv_result_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3096:1: (lv_result_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3097:3: lv_result_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefStatement6340);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3113:2: ( (lv_id_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3114:1: (lv_id_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3114:1: (lv_id_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3115:3: lv_id_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefStatement6361);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleOpDefStatement6373); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3135:1: ( (lv_param_4_0= ruleOpDefParameterList ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3136:1: (lv_param_4_0= ruleOpDefParameterList )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3136:1: (lv_param_4_0= ruleOpDefParameterList )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3137:3: lv_param_4_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement6394);
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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleOpDefStatement6406); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleOpDefStatement6418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3161:1: ( (lv_impl_7_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3162:1: (lv_impl_7_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3162:1: (lv_impl_7_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3163:3: lv_impl_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleOpDefStatement6439);
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

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleOpDefStatement6451); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3191:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3192:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3193:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList6487);
            iv_ruleOpDefParameterList=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameterList6497); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3200:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3203:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3204:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3204:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3204:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3204:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3205:2: 
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3213:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_VERSION && LA51_0<=RULE_EXPONENT)||(LA51_0>=29 && LA51_0<=33)||(LA51_0>=40 && LA51_0<=42)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3213:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3213:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3214:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3214:1: (lv_list_1_0= ruleOpDefParameter )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3215:3: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList6556);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3231:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==19) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3231:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleOpDefParameterList6569); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3235:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3236:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3236:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3237:3: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList6590);
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
                    	    break loop50;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3261:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3262:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3263:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter6630);
            iv_ruleOpDefParameter=ruleOpDefParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameter6640); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3270:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3273:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3274:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3274:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3274:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3274:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3275:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3275:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3276:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefParameter6686);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3292:2: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3293:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3293:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3294:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefParameter6707);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3310:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==20) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3310:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleOpDefParameter6720); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3314:1: ( (lv_val_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3315:1: (lv_val_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3315:1: (lv_val_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3316:3: lv_val_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getValExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleOpDefParameter6741);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3340:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3341:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3342:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement6779);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement6789); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3349:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3352:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3353:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3353:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3353:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3353:2: ( (lv_expr_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3354:1: (lv_expr_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3354:1: (lv_expr_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3355:3: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement6835);
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleExpressionStatement6847); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3383:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3384:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3385:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression6883);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression6893); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3392:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) | ( (lv_dsl_3_0= ruleDslContext ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_collection_2_0 = null;

        EObject lv_dsl_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3395:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) | ( (lv_dsl_3_0= ruleDslContext ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3396:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) | ( (lv_dsl_3_0= ruleDslContext ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3396:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) | ( (lv_dsl_3_0= ruleDslContext ) ) )
            int alt53=4;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3396:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3396:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3397:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3397:1: (lv_let_0_0= ruleLetExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3398:3: lv_let_0_0= ruleLetExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLetLetExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression6939);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3415:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3415:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3416:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3416:1: (lv_expr_1_0= ruleImplicationExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3417:3: lv_expr_1_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprImplicationExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImplicationExpression_in_ruleExpression6966);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3434:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3434:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3435:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3435:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3436:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCollectionCollectionInitializerParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpression6993);
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
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3453:6: ( (lv_dsl_3_0= ruleDslContext ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3453:6: ( (lv_dsl_3_0= ruleDslContext ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3454:1: (lv_dsl_3_0= ruleDslContext )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3454:1: (lv_dsl_3_0= ruleDslContext )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3455:3: lv_dsl_3_0= ruleDslContext
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getDslDslContextParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDslContext_in_ruleExpression7020);
                    lv_dsl_3_0=ruleDslContext();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"dsl",
                              		lv_dsl_3_0, 
                              		"DslContext");
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3479:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3480:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3481:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression7056);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression7066); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3488:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3491:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3492:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3492:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3492:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleLetExpression7103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3496:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3497:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3497:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3498:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLetExpression7124);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3514:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3515:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3515:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3516:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLetExpression7145);
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

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleLetExpression7157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3536:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3537:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3537:1: (lv_valueExpr_4_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3538:3: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression7178);
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

            otherlv_5=(Token)match(input,62,FOLLOW_62_in_ruleLetExpression7190); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3558:1: ( (lv_subExpr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3559:1: (lv_subExpr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3559:1: (lv_subExpr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3560:3: lv_subExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression7211);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3584:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3585:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3586:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression7247);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression7257); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3593:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3596:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3597:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3597:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3597:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3597:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3598:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3598:1: (lv_left_0_0= ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3599:3: lv_left_0_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftLogicalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression7303);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3615:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==20) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3616:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3616:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3617:3: lv_right_1_0= ruleAssignmentExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightAssignmentExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression7324);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3641:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3642:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3643:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart7361);
            iv_ruleAssignmentExpressionPart=ruleAssignmentExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpressionPart7371); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3650:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3653:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3654:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3654:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3654:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3654:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3655:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3655:1: (lv_op_0_0= ruleAssignmentOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3656:3: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart7417);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3672:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3672:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3672:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:1: (lv_ex_1_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3674:3: lv_ex_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getExLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart7439);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3691:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3691:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3692:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3692:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3693:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart7466);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3717:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3718:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3719:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator7504);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentOperator7515); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3726:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3729:28: (kw= '=' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3731:2: kw= '='
            {
            kw=(Token)match(input,20,FOLLOW_20_in_ruleAssignmentOperator7552); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3744:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3745:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3746:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression7591);
            iv_ruleImplicationExpression=ruleImplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpression7601); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3753:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3756:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3757:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3757:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3757:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3757:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3758:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3758:1: (lv_left_0_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3759:3: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression7647);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3775:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=63 && LA56_0<=64)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3776:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3776:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3777:3: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression7668);
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
    // $ANTLR end "ruleImplicationExpression"


    // $ANTLR start "entryRuleImplicationExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3801:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3802:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3803:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart7705);
            iv_ruleImplicationExpressionPart=ruleImplicationExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpressionPart7715); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3810:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3813:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3815:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3815:1: (lv_op_0_0= ruleImplicationOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3816:3: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart7761);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3832:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3833:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3833:1: (lv_ex_1_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3834:3: lv_ex_1_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart7782);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3858:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3859:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3860:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator7819);
            iv_ruleImplicationOperator=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationOperator7830); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3867:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3870:28: ( (kw= 'implies' | kw= 'iff' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3871:1: (kw= 'implies' | kw= 'iff' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3871:1: (kw= 'implies' | kw= 'iff' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==63) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3872:2: kw= 'implies'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleImplicationOperator7868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3879:2: kw= 'iff'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleImplicationOperator7887); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3892:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3893:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3894:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7927);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression7937); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3901:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3904:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3906:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3906:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3907:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7983);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3923:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=65 && LA58_0<=67)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3924:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3924:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3925:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression8004);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3949:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3950:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3951:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart8041);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart8051); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3958:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3961:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3962:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3962:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3962:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3962:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3963:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3963:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3964:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart8097);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3980:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3981:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3981:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3982:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart8118);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4006:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4007:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4008:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator8155);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator8166); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4015:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4018:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4019:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4019:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt59=3;
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
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4020:2: kw= 'and'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLogicalOperator8204); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4027:2: kw= 'or'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleLogicalOperator8223); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4034:2: kw= 'xor'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleLogicalOperator8242); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4047:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4048:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4049:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression8282);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression8292); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4056:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4059:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4060:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4060:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4060:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4060:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4061:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4061:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4062:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression8338);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4078:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==54||(LA60_0>=68 && LA60_0<=69)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4079:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4079:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4080:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression8359);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4104:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4105:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4106:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart8396);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart8406); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4113:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4116:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4117:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4117:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4117:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4117:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4118:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4118:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4119:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart8452);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4135:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4136:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4136:1: (lv_ex_1_0= ruleRelationalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4137:3: lv_ex_1_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart8474);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4154:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4154:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4155:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4155:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4156:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart8501);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4180:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4181:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4182:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator8539);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator8550); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4189:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4192:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4193:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4193:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt62=1;
                }
                break;
            case 68:
                {
                alt62=2;
                }
                break;
            case 69:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4194:2: kw= '=='
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleEqualityOperator8588); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4201:2: kw= '<>'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleEqualityOperator8607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4208:2: kw= '!='
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleEqualityOperator8626); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4221:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4222:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4223:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression8666);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression8676); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4230:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4233:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4234:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4234:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4234:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4234:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4235:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4235:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4236:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression8722);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4252:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=55 && LA63_0<=58)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4253:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4253:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4254:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression8743);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4278:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4279:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4280:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart8780);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart8790); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4287:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4290:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4291:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4291:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4291:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4291:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4292:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4292:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4293:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart8836);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4309:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4310:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4310:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4311:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart8857);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4335:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4336:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4337:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8894);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator8905); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4344:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4347:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4348:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4348:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt64=1;
                }
                break;
            case 56:
                {
                alt64=2;
                }
                break;
            case 57:
                {
                alt64=3;
                }
                break;
            case 58:
                {
                alt64=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4349:2: kw= '>'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleRelationalOperator8943); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4356:2: kw= '<'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleRelationalOperator8962); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4363:2: kw= '>='
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleRelationalOperator8981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4370:2: kw= '<='
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleRelationalOperator9000); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4383:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4384:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4385:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression9040);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression9050); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4392:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4395:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4397:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4397:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4398:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression9096);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4414:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=70 && LA65_0<=71)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4415:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4415:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4416:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression9117);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4440:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4441:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4442:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart9154);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart9164); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4449:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4452:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4453:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4453:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4453:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4453:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4454:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4454:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4455:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart9210);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4471:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4472:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4472:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4473:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart9231);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4497:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4498:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4499:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator9268);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator9279); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4506:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4509:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4510:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4510:1: (kw= '+' | kw= '-' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==70) ) {
                alt66=1;
            }
            else if ( (LA66_0==71) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4511:2: kw= '+'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleAdditiveOperator9317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4518:2: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleAdditiveOperator9336); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4531:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4532:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4533:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression9376);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression9386); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4540:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4543:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4544:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4544:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4544:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4544:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4545:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4545:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4546:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression9432);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4562:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==47||LA67_0==72) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4563:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4563:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4564:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression9453);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4588:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4589:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4590:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart9490);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart9500); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4597:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4600:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4601:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4601:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4601:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4601:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4602:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4602:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4603:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart9546);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4619:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4620:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4620:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4621:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart9567);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4645:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4646:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4647:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator9604);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator9615); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4654:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4657:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4658:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4658:1: (kw= '*' | kw= '/' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==47) ) {
                alt68=1;
            }
            else if ( (LA68_0==72) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4659:2: kw= '*'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleMultiplicativeOperator9653); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4666:2: kw= '/'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator9672); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4679:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4680:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4681:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression9712);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression9722); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4688:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4691:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4692:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4692:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4692:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4692:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==71||LA69_0==73) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4693:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4693:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4694:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression9768);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4710:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4711:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4711:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4712:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression9790);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4736:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4737:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4738:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator9827);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator9838); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4745:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4748:28: ( (kw= 'not' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4749:1: (kw= 'not' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4749:1: (kw= 'not' | kw= '-' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==73) ) {
                alt70=1;
            }
            else if ( (LA70_0==71) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4750:2: kw= 'not'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleUnaryOperator9876); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4757:2: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleUnaryOperator9895); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4770:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4771:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4772:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9935);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression9945); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4779:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4782:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt73=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==EOF||(LA73_1>=16 && LA73_1<=17)||(LA73_1>=19 && LA73_1<=20)||(LA73_1>=25 && LA73_1<=26)||(LA73_1>=34 && LA73_1<=35)||LA73_1==47||(LA73_1>=54 && LA73_1<=58)||(LA73_1>=62 && LA73_1<=72)||(LA73_1>=74 && LA73_1<=77)||(LA73_1>=81 && LA73_1<=83)) ) {
                    alt73=2;
                }
                else if ( (LA73_1==24) ) {
                    alt73=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA73_2 = input.LA(2);

                if ( (LA73_2==EOF||(LA73_2>=16 && LA73_2<=17)||(LA73_2>=19 && LA73_2<=20)||(LA73_2>=25 && LA73_2<=26)||(LA73_2>=34 && LA73_2<=35)||LA73_2==47||(LA73_2>=54 && LA73_2<=58)||(LA73_2>=62 && LA73_2<=72)||(LA73_2>=74 && LA73_2<=77)||(LA73_2>=81 && LA73_2<=83)) ) {
                    alt73=2;
                }
                else if ( (LA73_2==24) ) {
                    alt73=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA73_3 = input.LA(2);

                if ( (LA73_3==EOF||(LA73_3>=16 && LA73_3<=17)||(LA73_3>=19 && LA73_3<=20)||(LA73_3>=25 && LA73_3<=26)||(LA73_3>=34 && LA73_3<=35)||LA73_3==47||(LA73_3>=54 && LA73_3<=58)||(LA73_3>=62 && LA73_3<=72)||(LA73_3>=74 && LA73_3<=77)||(LA73_3>=81 && LA73_3<=83)) ) {
                    alt73=2;
                }
                else if ( (LA73_3==24) ) {
                    alt73=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 3, input);

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
            case 79:
            case 80:
                {
                alt73=2;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4784:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4784:1: (lv_call_0_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4785:3: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePostfixExpression9992);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4801:2: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==35) ) {
                            switch ( input.LA(2) ) {
                            case RULE_ID:
                                {
                                int LA71_4 = input.LA(3);

                                if ( (LA71_4==24) ) {
                                    alt71=1;
                                }


                                }
                                break;
                            case RULE_VERSION:
                                {
                                int LA71_5 = input.LA(3);

                                if ( (LA71_5==24) ) {
                                    alt71=1;
                                }


                                }
                                break;
                            case RULE_EXPONENT:
                                {
                                int LA71_6 = input.LA(3);

                                if ( (LA71_6==24) ) {
                                    alt71=1;
                                }


                                }
                                break;

                            }

                        }
                        else if ( ((LA71_0>=74 && LA71_0<=75)) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4802:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4802:1: (lv_fCalls_1_0= ruleCall )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4803:3: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCall_in_rulePostfixExpression10013);
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
                    	    break loop71;
                        }
                    } while (true);

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4819:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==35) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4820:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4820:1: (lv_access_2_0= ruleExpressionAccess )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4821:3: lv_access_2_0= ruleExpressionAccess
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getAccessExpressionAccessParserRuleCall_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpressionAccess_in_rulePostfixExpression10035);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4838:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4838:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4839:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4839:1: (lv_left_3_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4840:3: lv_left_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression10064);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4864:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4865:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4866:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall10100);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall10110); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4873:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4876:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt74=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt74=1;
                }
                break;
            case 74:
                {
                alt74=2;
                }
                break;
            case 75:
                {
                alt74=3;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4877:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleCall10148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4881:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4882:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4882:1: (lv_call_1_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4883:3: lv_call_1_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getCallFeatureCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleCall10169);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4900:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4900:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4900:8: otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) )
                    {
                    otherlv_2=(Token)match(input,74,FOLLOW_74_in_ruleCall10189); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4904:1: ( (lv_setOp_3_0= ruleSetOp ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4905:1: (lv_setOp_3_0= ruleSetOp )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4905:1: (lv_setOp_3_0= ruleSetOp )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4906:3: lv_setOp_3_0= ruleSetOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getSetOpSetOpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSetOp_in_ruleCall10210);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4923:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4923:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4923:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,75,FOLLOW_75_in_ruleCall10230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4927:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4928:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4928:1: (lv_arrayEx_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4929:3: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleCall10251);
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

                    otherlv_6=(Token)match(input,76,FOLLOW_76_in_ruleCall10263); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4957:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4958:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4959:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall10300);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall10310); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4966:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4969:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4970:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4970:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4970:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4970:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4971:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4971:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4972:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleFeatureCall10356);
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleFeatureCall10368); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4992:1: ( (lv_param_2_0= ruleActualParameterList ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_NUMBER && LA75_0<=RULE_STRING)||(LA75_0>=RULE_VERSION && LA75_0<=RULE_EXPONENT)||LA75_0==15||LA75_0==24||(LA75_0>=36 && LA75_0<=39)||LA75_0==43||LA75_0==61||LA75_0==71||LA75_0==73||(LA75_0>=79 && LA75_0<=80)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4993:1: (lv_param_2_0= ruleActualParameterList )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4993:1: (lv_param_2_0= ruleActualParameterList )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4994:3: lv_param_2_0= ruleActualParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getParamActualParameterListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleActualParameterList_in_ruleFeatureCall10389);
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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleFeatureCall10402); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5022:1: entryRuleSetOp returns [EObject current=null] : iv_ruleSetOp= ruleSetOp EOF ;
    public final EObject entryRuleSetOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOp = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5023:2: (iv_ruleSetOp= ruleSetOp EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5024:2: iv_ruleSetOp= ruleSetOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetOpRule()); 
            }
            pushFollow(FOLLOW_ruleSetOp_in_entryRuleSetOp10438);
            iv_ruleSetOp=ruleSetOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetOp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetOp10448); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5031:1: ruleSetOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) ;
    public final EObject ruleSetOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_declEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5034:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5035:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5035:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5035:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5035:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5036:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5036:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleSetOp10494);
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSetOp10506); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5057:1: ( (lv_decl_2_0= ruleDeclarator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5058:1: (lv_decl_2_0= ruleDeclarator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5058:1: (lv_decl_2_0= ruleDeclarator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5059:3: lv_decl_2_0= ruleDeclarator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarator_in_ruleSetOp10527);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5075:2: ( (lv_declEx_3_0= ruleExpression ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_NUMBER && LA76_0<=RULE_STRING)||(LA76_0>=RULE_VERSION && LA76_0<=RULE_EXPONENT)||LA76_0==15||LA76_0==24||(LA76_0>=36 && LA76_0<=39)||LA76_0==43||LA76_0==61||LA76_0==71||LA76_0==73||(LA76_0>=79 && LA76_0<=80)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5076:1: (lv_declEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5076:1: (lv_declEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5077:3: lv_declEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclExExpressionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSetOp10548);
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

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSetOp10561); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5105:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5106:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5107:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator10597);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator10607); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5114:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5117:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5118:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5118:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5118:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5118:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5119:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5119:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5120:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator10653);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5136:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==17) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5136:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleDeclarator10666); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5140:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5141:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5141:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5142:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator10687);
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
            	    break loop77;
                }
            } while (true);

            otherlv_3=(Token)match(input,77,FOLLOW_77_in_ruleDeclarator10701); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5170:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5171:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5172:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration10737);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration10747); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5179:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )* (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        AntlrDatatypeRuleToken lv_id_2_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_init_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5182:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )* (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5183:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )* (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5183:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )* (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5183:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )* (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5183:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5184:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5184:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5185:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration10793);
            lv_id_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"id",
                      		lv_id_0_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5201:2: (otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==19) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5201:4: otherlv_1= ',' ( (lv_id_2_0= ruleIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleDeclaration10806); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclarationAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5205:1: ( (lv_id_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5206:1: (lv_id_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5206:1: (lv_id_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5207:3: lv_id_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration10827);
            	    lv_id_2_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"id",
            	              		lv_id_2_0, 
            	              		"Identifier");
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5223:4: (otherlv_3= ':' ( (lv_type_4_0= ruleType ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==78) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5223:6: otherlv_3= ':' ( (lv_type_4_0= ruleType ) )
                    {
                    otherlv_3=(Token)match(input,78,FOLLOW_78_in_ruleDeclaration10842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDeclarationAccess().getColonKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5227:1: ( (lv_type_4_0= ruleType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5228:1: (lv_type_4_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5228:1: (lv_type_4_0= ruleType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5229:3: lv_type_4_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration10863);
                    lv_type_4_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
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


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5245:4: (otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==20) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5245:6: otherlv_5= '=' ( (lv_init_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration10878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5249:1: ( (lv_init_6_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5250:1: (lv_init_6_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5250:1: (lv_init_6_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5251:3: lv_init_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getInitExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclaration10899);
                    lv_init_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_6_0, 
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5275:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5276:2: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5277:2: iv_ruleActualParameterList= ruleActualParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10937);
            iv_ruleActualParameterList=ruleActualParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActualParameterList10947); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5284:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5287:28: ( ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5288:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5288:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5288:2: ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5288:2: ( (lv_param_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5289:1: (lv_param_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5289:1: (lv_param_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5290:3: lv_param_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList10993);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5306:2: (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==19) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5306:4: otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleActualParameterList11006); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5310:1: ( (lv_param_2_0= ruleExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5311:1: (lv_param_2_0= ruleExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5311:1: (lv_param_2_0= ruleExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5312:3: lv_param_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList11027);
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
            	    break loop81;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5336:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5337:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5338:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionAccessRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess11065);
            iv_ruleExpressionAccess=ruleExpressionAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionAccess; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionAccess11075); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5345:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5348:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5349:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5349:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5349:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleExpressionAccess11112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5353:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5354:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5354:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5355:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionAccess11133);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5371:2: ( (lv_calls_2_0= ruleCall ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA82_4 = input.LA(3);

                        if ( (LA82_4==24) ) {
                            alt82=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA82_5 = input.LA(3);

                        if ( (LA82_5==24) ) {
                            alt82=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA82_6 = input.LA(3);

                        if ( (LA82_6==24) ) {
                            alt82=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA82_0>=74 && LA82_0<=75)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5372:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5372:1: (lv_calls_2_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5373:3: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_ruleExpressionAccess11154);
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
            	    break loop82;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5389:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==35) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5390:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5390:1: (lv_access_3_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5391:3: lv_access_3_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getAccessExpressionAccessParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess11176);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5415:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5416:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5417:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression11213);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression11223); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5424:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
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

        AntlrDatatypeRuleToken lv_refName_7_0 = null;

        EObject lv_calls_9_0 = null;

        EObject lv_access_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5427:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) )
            int alt84=4;
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
                {
                alt84=1;
                }
                break;
            case 24:
                {
                alt84=2;
                }
                break;
            case 80:
                {
                alt84=3;
                }
                break;
            case 79:
                {
                alt84=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5429:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5429:1: (lv_lit_0_0= ruleLiteral )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5430:3: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression11270);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5447:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5447:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5447:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression11289); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5451:1: ( (lv_ex_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5452:1: (lv_ex_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5452:1: (lv_ex_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5453:3: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression11310);
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression11322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5474:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5474:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5475:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5475:1: (lv_ifEx_4_0= ruleIfExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5476:3: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression11350);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5493:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5493:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5493:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,79,FOLLOW_79_in_rulePrimaryExpression11369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression11381); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5501:1: ( (lv_refName_7_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5502:1: (lv_refName_7_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5502:1: (lv_refName_7_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5503:3: lv_refName_7_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefNameIdentifierParserRuleCall_0_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_rulePrimaryExpression11402);
                    lv_refName_7_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"refName",
                              		lv_refName_7_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression11414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5523:3: ( (lv_calls_9_0= ruleCall ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA85_4 = input.LA(3);

                        if ( (LA85_4==24) ) {
                            alt85=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA85_5 = input.LA(3);

                        if ( (LA85_5==24) ) {
                            alt85=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA85_6 = input.LA(3);

                        if ( (LA85_6==24) ) {
                            alt85=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA85_0>=74 && LA85_0<=75)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5524:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5524:1: (lv_calls_9_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5525:3: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_rulePrimaryExpression11437);
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
            	    break loop85;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5541:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==35) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5542:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5542:1: (lv_access_10_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5543:3: lv_access_10_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAccessExpressionAccessParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression11459);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5567:1: entryRuleCollectionInitializer returns [EObject current=null] : iv_ruleCollectionInitializer= ruleCollectionInitializer EOF ;
    public final EObject entryRuleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5568:2: (iv_ruleCollectionInitializer= ruleCollectionInitializer EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5569:2: iv_ruleCollectionInitializer= ruleCollectionInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer11496);
            iv_ruleCollectionInitializer=ruleCollectionInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionInitializer11506); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5576:1: ruleCollectionInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5579:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5580:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5580:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5580:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5580:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5581:2: 
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5589:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=RULE_VERSION && LA87_0<=RULE_EXPONENT)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5590:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5590:1: (lv_type_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5591:3: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer11564);
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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleCollectionInitializer11577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCollectionInitializerAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5611:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=RULE_NUMBER && LA88_0<=RULE_STRING)||(LA88_0>=RULE_VERSION && LA88_0<=RULE_EXPONENT)||LA88_0==15||LA88_0==24||(LA88_0>=36 && LA88_0<=39)||LA88_0==71||LA88_0==73||(LA88_0>=79 && LA88_0<=80)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5612:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5612:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5613:3: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer11598);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleCollectionInitializer11611); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5641:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5642:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5643:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange11647);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListOrRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListOrRange11657); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5650:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5653:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5654:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5654:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5654:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5654:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5655:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5655:1: (lv_list_0_0= ruleExpressionListEntry )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5656:3: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange11703);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5672:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==19) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5672:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleExpressionListOrRange11716); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5676:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5677:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5677:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5678:3: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange11737);
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
            	    break loop89;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5702:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5703:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5704:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListEntryRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry11775);
            iv_ruleExpressionListEntry=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListEntry; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListEntry11785); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5711:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5714:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5715:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5716:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5716:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5717:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11832);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5733:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==35) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5733:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleExpressionListEntry11845); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5737:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5738:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5738:1: (lv_attrib_2_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5739:3: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11866);
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

                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleExpressionListEntry11880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5759:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            int alt92=2;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5759:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5759:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5760:1: (lv_value_4_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5760:1: (lv_value_4_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5761:3: lv_value_4_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getValueLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11904);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5778:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5778:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5779:1: (lv_collection_5_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5779:1: (lv_collection_5_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5780:3: lv_collection_5_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11931);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5804:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5805:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5806:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral11968);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral11978); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5813:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5816:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5817:1: ( (lv_val_0_0= ruleValue ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5817:1: ( (lv_val_0_0= ruleValue ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5818:1: (lv_val_0_0= ruleValue )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5818:1: (lv_val_0_0= ruleValue )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5819:3: lv_val_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValue_in_ruleLiteral12023);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5843:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5844:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5845:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression12058);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression12068); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5852:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5855:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5856:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5856:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5856:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_80_in_ruleIfExpression12105); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5860:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5861:1: (lv_ifEx_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5861:1: (lv_ifEx_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5862:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression12126);
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

            otherlv_2=(Token)match(input,81,FOLLOW_81_in_ruleIfExpression12138); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5882:1: ( (lv_thenEx_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5883:1: (lv_thenEx_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5883:1: (lv_thenEx_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5884:3: lv_thenEx_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression12159);
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

            otherlv_4=(Token)match(input,82,FOLLOW_82_in_ruleIfExpression12171); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5904:1: ( (lv_elseEx_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5905:1: (lv_elseEx_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5905:1: (lv_elseEx_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5906:3: lv_elseEx_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression12192);
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

            otherlv_6=(Token)match(input,83,FOLLOW_83_in_ruleIfExpression12204); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5934:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5935:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5936:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier12241);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier12252); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5943:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5946:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5947:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5947:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            int alt93=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt93=1;
                }
                break;
            case RULE_VERSION:
                {
                alt93=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt93=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5947:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier12292); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5955:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier12318); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5963:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier12344); if (state.failed) return current;
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

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA92 dfa92 = new DFA92(this);
    static final String DFA7_eotS =
        "\22\uffff";
    static final String DFA7_eofS =
        "\1\1\21\uffff";
    static final String DFA7_minS =
        "\1\4\3\uffff\3\7\6\uffff\5\7";
    static final String DFA7_maxS =
        "\1\120\3\uffff\3\113\6\uffff\1\11\3\113\1\11";
    static final String DFA7_acceptS =
        "\1\uffff\1\11\1\1\1\2\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\5\uffff";
    static final String DFA7_specialS =
        "\22\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\11\1\uffff\1\5\1\4\1\6\5\uffff\1\11\1\1\1\uffff\1\2\2\uffff"+
            "\1\2\1\uffff\1\14\1\11\2\uffff\1\2\1\uffff\5\3\2\uffff\4\11"+
            "\3\3\1\11\1\12\1\7\2\uffff\1\10\13\uffff\1\13\1\11\11\uffff"+
            "\1\11\1\uffff\1\11\5\uffff\2\11",
            "",
            "",
            "",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\11"+
            "\uffff\1\15\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1"+
            "\uffff\2\11",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\11"+
            "\uffff\1\15\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1"+
            "\uffff\2\11",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\11"+
            "\uffff\1\15\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1"+
            "\uffff\2\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\16\1\20",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\15\uffff\1\21"+
            "\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1\uffff\2\11",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\15\uffff\1\21"+
            "\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1\uffff\2\11",
            "\3\3\5\uffff\1\11\1\uffff\1\11\2\uffff\1\11\15\uffff\1\21"+
            "\1\11\13\uffff\1\11\6\uffff\5\11\4\uffff\12\11\1\uffff\2\11",
            "\1\17\1\16\1\20"
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
            return "()* loopback of 288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAttributeTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
    }
    static final String DFA13_eotS =
        "\15\uffff";
    static final String DFA13_eofS =
        "\15\uffff";
    static final String DFA13_minS =
        "\1\4\2\uffff\3\7\2\uffff\5\7";
    static final String DFA13_maxS =
        "\1\120\2\uffff\3\113\2\uffff\1\11\3\113\1\11";
    static final String DFA13_acceptS =
        "\1\uffff\1\4\1\1\3\uffff\1\2\1\3\5\uffff";
    static final String DFA13_specialS =
        "\15\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\6\1\uffff\1\4\1\3\1\5\5\uffff\1\6\1\1\6\uffff\1\7\1\6\4"+
            "\uffff\5\2\2\uffff\4\6\3\2\1\6\21\uffff\1\6\11\uffff\1\6\1\uffff"+
            "\1\6\5\uffff\2\6",
            "",
            "",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "",
            "",
            "\1\12\1\11\1\13",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\1\12\1\11\1\13"
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
            return "()* loopback of 759:1: ( ( (lv_elements_5_0= ruleVariableDeclaration ) ) | ( (lv_elements_6_0= ruleExpressionStatement ) ) | ( (lv_elements_7_0= ruleAttrAssignment ) ) )*";
        }
    }
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\4\2\uffff\3\7\2\uffff\5\7";
    static final String DFA16_maxS =
        "\1\120\2\uffff\3\113\2\uffff\1\11\3\113\1\11";
    static final String DFA16_acceptS =
        "\1\uffff\1\4\1\1\3\uffff\1\2\1\3\5\uffff";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\6\1\uffff\1\4\1\3\1\5\5\uffff\1\6\1\1\6\uffff\1\7\1\6\4"+
            "\uffff\5\2\2\uffff\4\6\3\2\1\6\21\uffff\1\6\11\uffff\1\6\1\uffff"+
            "\1\6\5\uffff\2\6",
            "",
            "",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\3\uffff\1\6\11\uffff"+
            "\1\10\1\6\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "",
            "",
            "\1\12\1\11\1\13",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\3\2\5\uffff\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\1\14\1\6"+
            "\13\uffff\1\6\6\uffff\5\6\4\uffff\12\6\1\uffff\2\6",
            "\1\12\1\11\1\13"
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
            return "()+ loopback of 904:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+";
        }
    }
    static final String DFA53_eotS =
        "\15\uffff";
    static final String DFA53_eofS =
        "\3\uffff\3\2\3\uffff\3\2\1\uffff";
    static final String DFA53_minS =
        "\1\4\2\uffff\3\17\2\uffff\1\7\3\17\1\7";
    static final String DFA53_maxS =
        "\1\120\2\uffff\3\123\2\uffff\1\11\3\123\1\11";
    static final String DFA53_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\3\1\4\5\uffff";
    static final String DFA53_specialS =
        "\15\uffff}>";
    static final String[] DFA53_transitionS = {
            "\2\2\1\uffff\1\4\1\3\1\5\5\uffff\1\6\10\uffff\1\2\13\uffff"+
            "\4\2\3\uffff\1\7\21\uffff\1\1\11\uffff\1\2\1\uffff\1\2\5\uffff"+
            "\2\2",
            "",
            "",
            "\1\6\1\uffff\1\2\1\uffff\2\2\3\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "\1\6\1\uffff\1\2\1\uffff\2\2\3\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "\1\6\1\uffff\1\2\1\uffff\2\2\3\uffff\3\2\7\uffff\1\10\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "",
            "",
            "\1\12\1\11\1\13",
            "\1\6\1\uffff\1\2\1\uffff\2\2\4\uffff\2\2\7\uffff\1\14\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "\1\6\1\uffff\1\2\1\uffff\2\2\4\uffff\2\2\7\uffff\1\14\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "\1\6\1\uffff\1\2\1\uffff\2\2\4\uffff\2\2\7\uffff\1\14\1\2"+
            "\13\uffff\1\2\6\uffff\5\2\3\uffff\13\2\1\uffff\4\2\3\uffff\3"+
            "\2",
            "\1\12\1\11\1\13"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "3396:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) | ( (lv_dsl_3_0= ruleDslContext ) ) )";
        }
    }
    static final String DFA55_eotS =
        "\13\uffff";
    static final String DFA55_eofS =
        "\2\uffff\3\1\2\uffff\3\1\1\uffff";
    static final String DFA55_minS =
        "\1\4\1\uffff\3\17\1\uffff\1\7\3\17\1\7";
    static final String DFA55_maxS =
        "\1\120\1\uffff\3\123\1\uffff\1\11\3\123\1\11";
    static final String DFA55_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\5\uffff";
    static final String DFA55_specialS =
        "\13\uffff}>";
    static final String[] DFA55_transitionS = {
            "\2\1\1\uffff\1\3\1\2\1\4\5\uffff\1\5\10\uffff\1\1\13\uffff"+
            "\4\1\37\uffff\1\1\1\uffff\1\1\5\uffff\2\1",
            "",
            "\1\5\1\uffff\1\1\1\uffff\1\1\4\uffff\3\1\7\uffff\1\6\1\1\13"+
            "\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3\1",
            "\1\5\1\uffff\1\1\1\uffff\1\1\4\uffff\3\1\7\uffff\1\6\1\1\13"+
            "\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3\1",
            "\1\5\1\uffff\1\1\1\uffff\1\1\4\uffff\3\1\7\uffff\1\6\1\1\13"+
            "\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3\1",
            "",
            "\1\10\1\7\1\11",
            "\1\5\1\uffff\1\1\1\uffff\1\1\5\uffff\2\1\7\uffff\1\12\1\1"+
            "\13\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3"+
            "\1",
            "\1\5\1\uffff\1\1\1\uffff\1\1\5\uffff\2\1\7\uffff\1\12\1\1"+
            "\13\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3"+
            "\1",
            "\1\5\1\uffff\1\1\1\uffff\1\1\5\uffff\2\1\7\uffff\1\12\1\1"+
            "\13\uffff\1\1\6\uffff\5\1\3\uffff\13\1\1\uffff\4\1\3\uffff\3"+
            "\1",
            "\1\10\1\7\1\11"
    };

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "3672:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA61_eotS =
        "\13\uffff";
    static final String DFA61_eofS =
        "\2\uffff\3\1\2\uffff\3\1\1\uffff";
    static final String DFA61_minS =
        "\1\4\1\uffff\3\17\1\uffff\1\7\3\17\1\7";
    static final String DFA61_maxS =
        "\1\120\1\uffff\3\123\1\uffff\1\11\3\123\1\11";
    static final String DFA61_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\5\uffff";
    static final String DFA61_specialS =
        "\13\uffff}>";
    static final String[] DFA61_transitionS = {
            "\2\1\1\uffff\1\3\1\2\1\4\5\uffff\1\5\10\uffff\1\1\13\uffff"+
            "\4\1\37\uffff\1\1\1\uffff\1\1\5\uffff\2\1",
            "",
            "\1\5\2\1\1\uffff\2\1\3\uffff\3\1\7\uffff\1\6\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "\1\5\2\1\1\uffff\2\1\3\uffff\3\1\7\uffff\1\6\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "\1\5\2\1\1\uffff\2\1\3\uffff\3\1\7\uffff\1\6\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "",
            "\1\10\1\7\1\11",
            "\1\5\2\1\1\uffff\2\1\4\uffff\2\1\7\uffff\1\12\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "\1\5\2\1\1\uffff\2\1\4\uffff\2\1\7\uffff\1\12\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "\1\5\2\1\1\uffff\2\1\4\uffff\2\1\7\uffff\1\12\1\1\13\uffff"+
            "\1\1\7\uffff\4\1\3\uffff\6\1\2\uffff\3\1\1\uffff\4\1\3\uffff"+
            "\3\1",
            "\1\10\1\7\1\11"
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
            return "4135:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA91_eotS =
        "\12\uffff";
    static final String DFA91_eofS =
        "\1\uffff\3\4\3\uffff\3\4";
    static final String DFA91_minS =
        "\1\4\3\17\1\uffff\1\7\1\uffff\3\20";
    static final String DFA91_maxS =
        "\1\120\3\113\1\uffff\1\11\1\uffff\3\113";
    static final String DFA91_acceptS =
        "\4\uffff\1\2\1\uffff\1\1\3\uffff";
    static final String DFA91_specialS =
        "\12\uffff}>";
    static final String[] DFA91_transitionS = {
            "\2\4\1\uffff\1\2\1\1\1\3\5\uffff\1\4\10\uffff\1\4\13\uffff"+
            "\4\4\37\uffff\1\4\1\uffff\1\4\5\uffff\2\4",
            "\2\4\2\uffff\1\4\1\6\3\uffff\1\4\11\uffff\1\4\1\5\13\uffff"+
            "\1\4\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4",
            "\2\4\2\uffff\1\4\1\6\3\uffff\1\4\11\uffff\1\4\1\5\13\uffff"+
            "\1\4\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4",
            "\2\4\2\uffff\1\4\1\6\3\uffff\1\4\11\uffff\1\4\1\5\13\uffff"+
            "\1\4\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4",
            "",
            "\1\10\1\7\1\11",
            "",
            "\1\4\2\uffff\1\4\1\6\3\uffff\1\4\12\uffff\1\4\13\uffff\1\4"+
            "\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4",
            "\1\4\2\uffff\1\4\1\6\3\uffff\1\4\12\uffff\1\4\13\uffff\1\4"+
            "\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4",
            "\1\4\2\uffff\1\4\1\6\3\uffff\1\4\12\uffff\1\4\13\uffff\1\4"+
            "\6\uffff\5\4\6\uffff\10\4\1\uffff\2\4"
    };

    static final short[] DFA91_eot = DFA.unpackEncodedString(DFA91_eotS);
    static final short[] DFA91_eof = DFA.unpackEncodedString(DFA91_eofS);
    static final char[] DFA91_min = DFA.unpackEncodedStringToUnsignedChars(DFA91_minS);
    static final char[] DFA91_max = DFA.unpackEncodedStringToUnsignedChars(DFA91_maxS);
    static final short[] DFA91_accept = DFA.unpackEncodedString(DFA91_acceptS);
    static final short[] DFA91_special = DFA.unpackEncodedString(DFA91_specialS);
    static final short[][] DFA91_transition;

    static {
        int numStates = DFA91_transitionS.length;
        DFA91_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA91_transition[i] = DFA.unpackEncodedString(DFA91_transitionS[i]);
        }
    }

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = DFA91_eot;
            this.eof = DFA91_eof;
            this.min = DFA91_min;
            this.max = DFA91_max;
            this.accept = DFA91_accept;
            this.special = DFA91_special;
            this.transition = DFA91_transition;
        }
        public String getDescription() {
            return "5715:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA92_eotS =
        "\13\uffff";
    static final String DFA92_eofS =
        "\2\uffff\3\1\2\uffff\3\1\1\uffff";
    static final String DFA92_minS =
        "\1\4\1\uffff\3\17\1\uffff\1\7\3\17\1\7";
    static final String DFA92_maxS =
        "\1\120\1\uffff\3\113\1\uffff\1\11\3\113\1\11";
    static final String DFA92_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\5\uffff";
    static final String DFA92_specialS =
        "\13\uffff}>";
    static final String[] DFA92_transitionS = {
            "\2\1\1\uffff\1\3\1\2\1\4\5\uffff\1\5\10\uffff\1\1\13\uffff"+
            "\4\1\37\uffff\1\1\1\uffff\1\1\5\uffff\2\1",
            "",
            "\1\5\1\1\2\uffff\1\1\4\uffff\1\1\11\uffff\1\6\1\1\13\uffff"+
            "\1\1\6\uffff\5\1\6\uffff\10\1\1\uffff\2\1",
            "\1\5\1\1\2\uffff\1\1\4\uffff\1\1\11\uffff\1\6\1\1\13\uffff"+
            "\1\1\6\uffff\5\1\6\uffff\10\1\1\uffff\2\1",
            "\1\5\1\1\2\uffff\1\1\4\uffff\1\1\11\uffff\1\6\1\1\13\uffff"+
            "\1\1\6\uffff\5\1\6\uffff\10\1\1\uffff\2\1",
            "",
            "\1\10\1\7\1\11",
            "\1\5\1\1\2\uffff\1\1\16\uffff\1\12\1\1\13\uffff\1\1\6\uffff"+
            "\5\1\6\uffff\10\1\1\uffff\2\1",
            "\1\5\1\1\2\uffff\1\1\16\uffff\1\12\1\1\13\uffff\1\1\6\uffff"+
            "\5\1\6\uffff\10\1\1\uffff\2\1",
            "\1\5\1\1\2\uffff\1\1\16\uffff\1\12\1\1\13\uffff\1\1\6\uffff"+
            "\5\1\6\uffff\10\1\1\uffff\2\1",
            "\1\10\1\7\1\11"
    };

    static final short[] DFA92_eot = DFA.unpackEncodedString(DFA92_eotS);
    static final short[] DFA92_eof = DFA.unpackEncodedString(DFA92_eofS);
    static final char[] DFA92_min = DFA.unpackEncodedStringToUnsignedChars(DFA92_minS);
    static final char[] DFA92_max = DFA.unpackEncodedStringToUnsignedChars(DFA92_maxS);
    static final short[] DFA92_accept = DFA.unpackEncodedString(DFA92_acceptS);
    static final short[] DFA92_special = DFA.unpackEncodedString(DFA92_specialS);
    static final short[][] DFA92_transition;

    static {
        int numStates = DFA92_transitionS.length;
        DFA92_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA92_transition[i] = DFA.unpackEncodedString(DFA92_transitionS[i]);
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = DFA92_eot;
            this.eof = DFA92_eof;
            this.min = DFA92_min;
            this.max = DFA92_max;
            this.accept = DFA92_accept;
            this.special = DFA92_special;
            this.transition = DFA92_transition;
        }
        public String getDescription() {
            return "5759:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleVariabilityUnit_in_entryRuleVariabilityUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariabilityUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProject_in_ruleVariabilityUnit149 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleProject_in_entryRuleProject186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProject196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleProject233 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleProject254 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleProject266 = new BitSet(new long[]{0x381B3FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleProject287 = new BitSet(new long[]{0x301B3FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleImportStmt_in_ruleProject309 = new BitSet(new long[]{0x301B3FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleConflictStmt_in_ruleProject331 = new BitSet(new long[]{0x30133FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_ruleProject353 = new BitSet(new long[]{0x30033FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleProjectContents_in_ruleProject375 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleProject387 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleProject400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProjectContents_in_entryRuleProjectContents438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProjectContents448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedef_in_ruleProjectContents507 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleProjectContents534 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleFreeze_in_ruleProjectContents561 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleEval_in_ruleProjectContents588 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleProjectContents615 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAttributeTo_in_ruleProjectContents642 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleOpDefStatement_in_ruleProjectContents669 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleProjectContents696 = new BitSet(new long[]{0x30013FF3E9A483B2L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleTypedef_in_entryRuleTypedef734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedef744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnum_in_ruleTypedef790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefCompound_in_ruleTypedef817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefMapping_in_ruleTypedef844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnum_in_entryRuleTypedefEnum880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefEnum890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleTypedefEnum927 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefEnum948 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTypedefEnum960 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum981 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_ruleTypedefEnum994 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_ruleTypedefEnum1015 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_ruleTypedefEnum1029 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_ruleTypedefEnum1050 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypedefEnum1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefEnumLiteral_in_entryRuleTypedefEnumLiteral1099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefEnumLiteral1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefEnumLiteral1155 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleTypedefEnumLiteral1168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleTypedefEnumLiteral1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefCompound_in_entryRuleTypedefCompound1227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefCompound1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTypedefCompound1274 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefCompound1295 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_22_in_ruleTypedefCompound1308 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefCompound1329 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTypedefCompound1343 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleTypedefCompound1365 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleTypedefCompound1392 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleTypedefCompound1419 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_16_in_ruleTypedefCompound1433 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleTypedefCompound1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_entryRuleAttrAssignment1484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrAssignment1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAttrAssignment1531 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAttrAssignment1543 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1564 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleAttrAssignment1577 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_ruleAttrAssignment1598 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleAttrAssignment1612 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAttrAssignment1624 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrAssignment1636 = new BitSet(new long[]{0x30013FF3E9A483B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleAttrAssignment1658 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleAttrAssignment1685 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAttrAssignment_in_ruleAttrAssignment1712 = new BitSet(new long[]{0x30013FF3E9A583B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_16_in_ruleAttrAssignment1726 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleAttrAssignment1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrAssignmentPart_in_entryRuleAttrAssignmentPart1777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrAssignmentPart1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttrAssignmentPart1833 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAttrAssignmentPart1845 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAttrAssignmentPart1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefMapping_in_entryRuleTypedefMapping1902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefMapping1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTypedefMapping1949 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypedefMapping1970 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypedefMapping1991 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_ruleTypedefMapping2012 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypedefMapping2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedefConstraint_in_entryRuleTypedefConstraint2061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedefConstraint2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTypedefConstraint2108 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypedefConstraint2120 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTypedefConstraint2141 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleTypedefConstraint2154 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTypedefConstraint2175 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleTypedefConstraint2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration2281 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2302 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration2315 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2336 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleVariableDeclaration2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationPart2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2442 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVariableDeclarationPart2455 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType2514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBasicType2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBasicType2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBasicType2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBasicType2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBasicType2715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType2764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleType2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleType2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_ruleType2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue2910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3058 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3076 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3111 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3129 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessName_in_entryRuleAccessName3203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessName3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAccessName3256 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAccessName3290 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue3327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleValue3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValue3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleValue3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleValue3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleValue3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleValue3528 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleValue3540 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleValue3561 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleValue3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleValue3598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_entryRuleDerivedType3647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDerivedType3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleDerivedType3701 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_41_in_ruleDerivedType3738 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_42_in_ruleDerivedType3775 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDerivedType3801 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleDerivedType3822 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDerivedType3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDslContext_in_entryRuleDslContext3870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDslContext3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDslContext3917 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDslContext3929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDslContext3946 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDslContext3963 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDslContext3980 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDslContext3997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDslContext4014 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDslContext4031 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_DSL_CONTENT_in_ruleDslContext4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeTo_in_entryRuleAttributeTo4089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeTo4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleAttributeTo4136 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleAttributeTo4157 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleAttributeTo4178 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAttributeTo4190 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeTo4211 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleAttributeTo4224 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeTo4245 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleAttributeTo4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeze_in_entryRuleFreeze4295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeze4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFreeze4342 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFreeze4354 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_ruleFreeze4375 = new BitSet(new long[]{0x0000000000010380L});
    public static final BitSet FOLLOW_16_in_ruleFreeze4388 = new BitSet(new long[]{0x0000400000020002L});
    public static final BitSet FOLLOW_46_in_ruleFreeze4401 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleFreezeButList_in_ruleFreeze4422 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleFreeze4437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreezeStatement4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4531 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_ruleAccessName_in_ruleFreezeStatement4552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFreezeStatement4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreezeButList_in_entryRuleFreezeButList4601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreezeButList4611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFreezeButList4648 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleFreezeButExpression_in_ruleFreezeButList4669 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleFreezeButList4682 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleFreezeButExpression_in_ruleFreezeButList4703 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleFreezeButList4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreezeButExpression_in_entryRuleFreezeButExpression4753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreezeButExpression4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFreezeButExpression4809 = new BitSet(new long[]{0x0000800800000002L});
    public static final BitSet FOLLOW_ruleAccessName_in_ruleFreezeButExpression4830 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleFreezeButExpression4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEval_in_entryRuleEval4899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEval4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEval4946 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEval4958 = new BitSet(new long[]{0x200108F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleEval_in_ruleEval4979 = new BitSet(new long[]{0x200108F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleEval5001 = new BitSet(new long[]{0x200008F0010183B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_16_in_ruleEval5014 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleEval5027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration5065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDeclaration5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInterfaceDeclaration5112 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration5133 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInterfaceDeclaration5145 = new BitSet(new long[]{0x0004000000010000L});
    public static final BitSet FOLLOW_ruleExport_in_ruleInterfaceDeclaration5166 = new BitSet(new long[]{0x0004000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceDeclaration5179 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleInterfaceDeclaration5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport5230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport5240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleExport5277 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExport5298 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleExport5311 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExport5332 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleExport5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStmt_in_entryRuleImportStmt5382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStmt5392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleImportStmt5429 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5450 = new BitSet(new long[]{0x0000000410020000L});
    public static final BitSet FOLLOW_34_in_ruleImportStmt5463 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5484 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_28_in_ruleImportStmt5499 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleImportStmt5511 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleImportStmt5532 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleImportStmt5545 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleImportStmt5566 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleImportStmt5580 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleImportStmt5594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConflictStmt5640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleConflictStmt5677 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleConflictStmt5698 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_28_in_ruleConflictStmt5711 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleConflictStmt5723 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleConflictStmt5744 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleConflictStmt5757 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleConflictStmt5778 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleConflictStmt5792 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConflictStmt5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId5842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId5852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVersionedId5898 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleVersionedId5910 = new BitSet(new long[]{0x07C0000000000000L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_ruleVersionedId5931 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionedId5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator5990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleVersionOperator6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleVersionOperator6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleVersionOperator6077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleVersionOperator6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleVersionOperator6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt6155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleVersionStmt6202 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt6219 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVersionStmt6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement6272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefStatement6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleOpDefStatement6319 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefStatement6340 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefStatement6361 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleOpDefStatement6373 = new BitSet(new long[]{0x00000703E2000380L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement6394 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpDefStatement6406 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleOpDefStatement6418 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefStatement6439 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleOpDefStatement6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList6487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameterList6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList6556 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleOpDefParameterList6569 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList6590 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter6630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameter6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefParameter6686 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefParameter6707 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleOpDefParameter6720 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefParameter6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement6779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement6835 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExpressionStatement6847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression6883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression6939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_ruleExpression6966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpression6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDslContext_in_ruleExpression7020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression7056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression7066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleLetExpression7103 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleLetExpression7124 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLetExpression7145 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleLetExpression7157 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression7178 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleLetExpression7190 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression7211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression7247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression7257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression7303 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart7361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpressionPart7371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart7417 = new BitSet(new long[]{0x000000F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart7439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart7466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator7504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentOperator7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAssignmentOperator7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression7591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpression7601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression7647 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression7668 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart7705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpressionPart7715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart7761 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart7782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator7819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationOperator7830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleImplicationOperator7868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleImplicationOperator7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression7937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7983 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression8004 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart8041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart8097 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart8118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator8155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator8166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLogicalOperator8204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleLogicalOperator8223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleLogicalOperator8242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression8282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression8292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression8338 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression8359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart8396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart8452 = new BitSet(new long[]{0x000000F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart8474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart8501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator8539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator8550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleEqualityOperator8588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleEqualityOperator8607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleEqualityOperator8626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression8666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression8722 = new BitSet(new long[]{0x0780000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression8743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart8780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart8790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart8836 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart8857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator8905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleRelationalOperator8943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleRelationalOperator8962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleRelationalOperator8981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleRelationalOperator9000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression9040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression9050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression9096 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression9117 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart9154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart9164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart9210 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart9231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator9268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator9317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleAdditiveOperator9336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression9376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression9432 = new BitSet(new long[]{0x0000800000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression9453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart9490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart9500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart9546 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart9567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator9604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator9615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleMultiplicativeOperator9653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator9672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression9712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression9722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression9768 = new BitSet(new long[]{0x000000F0010003B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression9790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator9827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator9838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleUnaryOperator9876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleUnaryOperator9895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression9945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePostfixExpression9992 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePostfixExpression10013 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePostfixExpression10035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression10064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall10100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall10110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCall10148 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleCall10169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleCall10189 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleSetOp_in_ruleCall10210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleCall10230 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCall10251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCall10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall10300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall10310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleFeatureCall10356 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCall10368 = new BitSet(new long[]{0x200008F0030083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_ruleFeatureCall10389 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCall10402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetOp_in_entryRuleSetOp10438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetOp10448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleSetOp10494 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSetOp10506 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleSetOp10527 = new BitSet(new long[]{0x200008F0030083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSetOp10548 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSetOp10561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator10597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator10607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator10653 = new BitSet(new long[]{0x0000000000020000L,0x0000000000002000L});
    public static final BitSet FOLLOW_17_in_ruleDeclarator10666 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator10687 = new BitSet(new long[]{0x0000000000020000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleDeclarator10701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration10737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration10747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration10793 = new BitSet(new long[]{0x0000000000180002L,0x0000000000004000L});
    public static final BitSet FOLLOW_19_in_ruleDeclaration10806 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration10827 = new BitSet(new long[]{0x0000000000180002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleDeclaration10842 = new BitSet(new long[]{0x00000703E0000380L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration10863 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration10878 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclaration10899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActualParameterList10947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList10993 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleActualParameterList11006 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList11027 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess11065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionAccess11075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleExpressionAccess11112 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionAccess11133 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_ruleExpressionAccess11154 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess11176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression11213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression11223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression11270 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression11289 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression11310 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression11322 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression11350 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_79_in_rulePrimaryExpression11369 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression11381 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rulePrimaryExpression11402 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression11414 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePrimaryExpression11437 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression11459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer11496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionInitializer11506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer11564 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCollectionInitializer11577 = new BitSet(new long[]{0x000000F0010183B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer11598 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCollectionInitializer11611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange11647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListOrRange11657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange11703 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleExpressionListOrRange11716 = new BitSet(new long[]{0x000000F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange11737 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry11775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListEntry11785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11832 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_35_in_ruleExpressionListEntry11845 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11866 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleExpressionListEntry11880 = new BitSet(new long[]{0x000000F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral11968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral11978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleLiteral12023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression12058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression12068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleIfExpression12105 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression12126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleIfExpression12138 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression12159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ruleIfExpression12171 = new BitSet(new long[]{0x200008F0010083B0L,0x0000000000018280L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression12192 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_ruleIfExpression12204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier12241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier12252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier12292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier12318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier12344 = new BitSet(new long[]{0x0000000000000002L});

}