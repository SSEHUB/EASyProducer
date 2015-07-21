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
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
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
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_EXPONENT=8;
    public static final int T__39=39;
    public static final int RULE_WS=11;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1144:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1147:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1148:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )* otherlv_5= ')'
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
                     		add(
                     			current, 
                     			"expressions",
                      		lv_expressions_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1174:2: (otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==18) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1174:4: otherlv_3= ',' ( (lv_expressions_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTypedefConstraint2186); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTypedefConstraintAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1178:1: ( (lv_expressions_4_0= ruleExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1179:1: (lv_expressions_4_0= ruleExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1179:1: (lv_expressions_4_0= ruleExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1180:3: lv_expressions_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleTypedefConstraint2207);
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
            	    break loop20;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleTypedefConstraint2221); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1208:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1209:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1210:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2257);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2267); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1217:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1220:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1221:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1221:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1221:2: ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1221:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1222:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1222:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1223:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration2313);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1239:2: ( (lv_decls_1_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1240:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1240:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1241:3: lv_decls_1_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2334);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1257:2: (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==18) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1257:4: otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVariableDeclaration2347); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1261:1: ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1262:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1262:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1263:3: lv_decls_3_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2368);
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
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleVariableDeclaration2382); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1291:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1292:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1293:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationPartRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2418);
            iv_ruleVariableDeclarationPart=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclarationPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationPart2428); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1300:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1303:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1304:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1304:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1304:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1304:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1305:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1305:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1306:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2474);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1322:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1322:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleVariableDeclarationPart2487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1326:1: ( (lv_default_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1327:1: (lv_default_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1327:1: (lv_default_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1328:3: lv_default_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getDefaultExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2508);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1352:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1353:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1354:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType2546);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType2556); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1361:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1364:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1365:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1365:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt23=1;
                }
                break;
            case 30:
                {
                alt23=2;
                }
                break;
            case 31:
                {
                alt23=3;
                }
                break;
            case 32:
                {
                alt23=4;
                }
                break;
            case 33:
                {
                alt23=5;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1365:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1365:2: ( (lv_type_0_0= 'Integer' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1366:1: (lv_type_0_0= 'Integer' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1366:1: (lv_type_0_0= 'Integer' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1367:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,29,FOLLOW_29_in_ruleBasicType2599); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1381:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1381:6: ( (lv_type_1_0= 'Real' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1382:1: (lv_type_1_0= 'Real' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1382:1: (lv_type_1_0= 'Real' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1383:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,30,FOLLOW_30_in_ruleBasicType2636); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1397:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1397:6: ( (lv_type_2_0= 'Boolean' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1398:1: (lv_type_2_0= 'Boolean' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1398:1: (lv_type_2_0= 'Boolean' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1399:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,31,FOLLOW_31_in_ruleBasicType2673); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1413:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1413:6: ( (lv_type_3_0= 'String' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1414:1: (lv_type_3_0= 'String' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1414:1: (lv_type_3_0= 'String' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1415:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,32,FOLLOW_32_in_ruleBasicType2710); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1429:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1429:6: ( (lv_type_4_0= 'Constraint' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1430:1: (lv_type_4_0= 'Constraint' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1430:1: (lv_type_4_0= 'Constraint' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1431:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,33,FOLLOW_33_in_ruleBasicType2747); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1452:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1453:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1454:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType2796);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType2806); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1461:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1464:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1465:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1465:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt24=1;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 53:
                {
                alt24=2;
                }
                break;
            case 40:
            case 41:
            case 42:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1465:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1465:2: ( (lv_type_0_0= ruleBasicType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1466:1: (lv_type_0_0= ruleBasicType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1466:1: (lv_type_0_0= ruleBasicType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1467:3: lv_type_0_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeBasicTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_ruleType2852);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1484:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1484:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1485:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1485:1: (lv_id_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1486:3: lv_id_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getIdQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleType2879);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1503:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1503:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1504:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1504:1: (lv_derived_2_0= ruleDerivedType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1505:3: lv_derived_2_0= ruleDerivedType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getDerivedDerivedTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDerivedType_in_ruleType2906);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1529:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1530:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1531:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue2942);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue2952); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1538:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1541:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1542:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1542:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1543:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1543:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1544:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue2993); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1568:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1569:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1570:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3033);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3043); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1577:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1580:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
            int alt26=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==34) ) {
                        alt26=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA26_2 = input.LA(2);

                    if ( (LA26_2==34) ) {
                        alt26=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA26_3 = input.LA(2);

                    if ( (LA26_3==34) ) {
                        alt26=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA26_4 = input.LA(2);

                    if ( (LA26_4==34) ) {
                        alt26=1;
                    }
                    }
                    break;
            }

            switch (alt26) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1581:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1582:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1582:1: (lv_qName_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1583:3: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3090);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1599:2: ( (lv_qName_1_0= '::' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1600:1: (lv_qName_1_0= '::' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1600:1: (lv_qName_1_0= '::' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1601:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3108); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1614:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    loop25:
                    do {
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
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1614:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1614:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1615:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1615:1: (lv_qName_2_0= ruleIdentifier )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1616:3: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3143);
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

                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1632:2: ( (lv_qName_3_0= '::' ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1633:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1633:1: (lv_qName_3_0= '::' )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1634:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,34,FOLLOW_34_in_ruleQualifiedName3161); if (state.failed) return current;
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
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1647:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1648:1: (lv_qName_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1648:1: (lv_qName_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1649:3: lv_qName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName3199);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1673:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1674:2: (iv_ruleAccessName= ruleAccessName EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1675:2: iv_ruleAccessName= ruleAccessName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessNameRule()); 
            }
            pushFollow(FOLLOW_ruleAccessName_in_entryRuleAccessName3235);
            iv_ruleAccessName=ruleAccessName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessName3245); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1682:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1685:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1686:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1686:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==35) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1686:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1686:2: ( (lv_aName_0_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1687:1: (lv_aName_0_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1687:1: (lv_aName_0_0= '.' )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1688:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,35,FOLLOW_35_in_ruleAccessName3288); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1701:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1702:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1702:1: (lv_aName_1_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1703:3: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAccessName3322);
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
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1727:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1728:2: (iv_ruleValue= ruleValue EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1729:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue3359);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue3369); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1736:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1739:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1740:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1740:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            int alt29=7;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt29=1;
                }
                break;
            case RULE_STRING:
                {
                alt29=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 53:
                {
                alt29=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred46_InternalIvml()) ) {
                    alt29=3;
                }
                else if ( (synpred51_InternalIvml()) ) {
                    alt29=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
                {
                alt29=4;
                }
                break;
            case 38:
                {
                alt29=5;
                }
                break;
            case 39:
                {
                alt29=6;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1740:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1740:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1741:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1741:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1742:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleValue3415);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1759:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1759:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1760:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1760:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1761:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValue3438); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1779:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1779:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1780:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleValue3470);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1797:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1797:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1798:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1798:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1799:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1799:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==36) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==37) ) {
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
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1800:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,36,FOLLOW_36_in_ruleValue3496); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1812:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,37,FOLLOW_37_in_ruleValue3525); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1828:6: ( (lv_self_4_0= 'self' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1828:6: ( (lv_self_4_0= 'self' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1829:1: (lv_self_4_0= 'self' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1829:1: (lv_self_4_0= 'self' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1830:3: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,38,FOLLOW_38_in_ruleValue3565); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1844:6: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1844:6: ( (lv_nullValue_5_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1845:1: (lv_nullValue_5_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1845:1: (lv_nullValue_5_0= 'null' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1846:3: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,39,FOLLOW_39_in_ruleValue3602); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1860:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1860:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1860:7: ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1866:1: (lv_version_6_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1867:3: lv_version_6_0= RULE_VERSION
                    {
                    lv_version_6_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleValue3649); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1891:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1892:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1893:2: iv_ruleDerivedType= ruleDerivedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerivedTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDerivedType_in_entryRuleDerivedType3690);
            iv_ruleDerivedType=ruleDerivedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDerivedType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDerivedType3700); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1900:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1903:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case 42:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1904:3: ( (lv_op_0_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1905:1: (lv_op_0_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1905:1: (lv_op_0_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1906:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,40,FOLLOW_40_in_ruleDerivedType3744); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1920:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1920:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1921:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1921:1: (lv_op_1_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1922:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,41,FOLLOW_41_in_ruleDerivedType3781); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1936:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1936:6: ( (lv_op_2_0= 'refTo' ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1937:1: (lv_op_2_0= 'refTo' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1937:1: (lv_op_2_0= 'refTo' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1938:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,42,FOLLOW_42_in_ruleDerivedType3818); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDerivedType3844); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1955:1: ( (lv_type_4_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1956:1: (lv_type_4_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1956:1: (lv_type_4_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1957:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleDerivedType3865);
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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleDerivedType3877); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1985:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1986:2: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1987:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotateToRule()); 
            }
            pushFollow(FOLLOW_ruleAnnotateTo_in_entryRuleAnnotateTo3913);
            iv_ruleAnnotateTo=ruleAnnotateTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotateTo; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotateTo3923); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1994:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1997:28: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1998:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1998:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1998:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1998:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1999:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1999:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2000:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2000:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            else if ( (LA31_0==44) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2001:3: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,43,FOLLOW_43_in_ruleAnnotateTo3968); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2013:8: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,44,FOLLOW_44_in_ruleAnnotateTo3997); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2028:2: ( (lv_annotationType_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2029:1: (lv_annotationType_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2029:1: (lv_annotationType_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2030:3: lv_annotationType_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleAnnotateTo4034);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2046:2: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2047:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2047:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2048:3: lv_annotationDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationDeclVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclarationPart_in_ruleAnnotateTo4055);
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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleAnnotateTo4067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAnnotateToAccess().getToKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2068:1: ( (lv_names_4_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2069:1: (lv_names_4_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2069:1: (lv_names_4_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2070:3: lv_names_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleAnnotateTo4088);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2086:2: (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==18) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2086:4: otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleAnnotateTo4101); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAnnotateToAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2090:1: ( (lv_names_6_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2091:1: (lv_names_6_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2091:1: (lv_names_6_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2092:3: lv_names_6_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleAnnotateTo4122);
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
            	    break loop32;
                }
            } while (true);

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleAnnotateTo4136); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2120:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2121:2: (iv_ruleFreeze= ruleFreeze EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2122:2: iv_ruleFreeze= ruleFreeze EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeRule()); 
            }
            pushFollow(FOLLOW_ruleFreeze_in_entryRuleFreeze4172);
            iv_ruleFreeze=ruleFreeze();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreeze; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeze4182); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2129:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2132:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2133:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2133:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2133:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleFreeze4219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleFreeze4231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2141:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_VERSION && LA33_0<=RULE_EXPONENT)||LA33_0==53) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2142:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2142:1: (lv_names_2_0= ruleFreezeStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2143:3: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFreezeStatement_in_ruleFreeze4252);
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
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleFreeze4265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2163:1: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==46) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2163:3: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleFreeze4278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleFreeze4290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2171:1: ( (lv_id_6_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2172:1: (lv_id_6_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2172:1: (lv_id_6_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2173:3: lv_id_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getIdIdentifierParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleFreeze4311);
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

                    otherlv_7=(Token)match(input,47,FOLLOW_47_in_ruleFreeze4323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2193:1: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2194:1: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2194:1: (lv_ex_8_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2195:3: lv_ex_8_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getExLogicalExpressionParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleFreeze4344);
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

                    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleFreeze4356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFreezeAccess().getRightParenthesisKeyword_4_5());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2215:3: (otherlv_10= ';' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2215:5: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleFreeze4371); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2227:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2228:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2229:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeStatementRule()); 
            }
            pushFollow(FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4409);
            iv_ruleFreezeStatement=ruleFreezeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreezeStatement4419); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2236:1: ruleFreezeStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2239:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2240:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2240:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2240:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2240:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2241:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2241:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2242:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4465);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2258:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2259:1: (lv_access_1_0= ruleAccessName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2259:1: (lv_access_1_0= ruleAccessName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2260:3: lv_access_1_0= ruleAccessName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessName_in_ruleFreezeStatement4486);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFreezeStatement4499); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2288:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2289:2: (iv_ruleEval= ruleEval EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2290:2: iv_ruleEval= ruleEval EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvalRule()); 
            }
            pushFollow(FOLLOW_ruleEval_in_entryRuleEval4535);
            iv_ruleEval=ruleEval();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEval; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEval4545); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2297:1: ruleEval returns [EObject current=null] : (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2300:28: ( (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2301:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2301:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2301:3: otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleEval4582); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEvalAccess().getEvalKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleEval4594); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2309:1: ( (lv_nested_2_0= ruleEval ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==48) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2310:1: (lv_nested_2_0= ruleEval )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2310:1: (lv_nested_2_0= ruleEval )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2311:3: lv_nested_2_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEval_in_ruleEval4615);
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
            	    break loop37;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2327:3: ( (lv_statements_3_0= ruleExpressionStatement ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_NUMBER && LA38_0<=RULE_EXPONENT)||LA38_0==14||LA38_0==24||(LA38_0>=36 && LA38_0<=39)||LA38_0==53||LA38_0==55||LA38_0==70||LA38_0==73||(LA38_0>=77 && LA38_0<=78)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2328:1: (lv_statements_3_0= ruleExpressionStatement )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2328:1: (lv_statements_3_0= ruleExpressionStatement )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2329:3: lv_statements_3_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleEval4637);
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
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEval4650); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2349:1: (otherlv_5= ';' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==16) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2349:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleEval4663); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2361:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2362:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2363:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration4701);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceDeclaration4711); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2370:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2373:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2374:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2374:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2374:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleInterfaceDeclaration4748); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2378:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2379:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2379:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2380:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration4769);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleInterfaceDeclaration4781); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2400:1: ( (lv_exports_3_0= ruleExport ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2401:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2401:1: (lv_exports_3_0= ruleExport )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2402:3: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExport_in_ruleInterfaceDeclaration4802);
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
            	    break loop40;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleInterfaceDeclaration4815); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2422:1: (otherlv_5= ';' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==16) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2422:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleInterfaceDeclaration4828); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2434:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2435:2: (iv_ruleExport= ruleExport EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2436:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport4866);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport4876); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2443:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2446:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2447:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2447:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2447:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleExport4913); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2451:1: ( (lv_names_1_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2452:1: (lv_names_1_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2452:1: (lv_names_1_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2453:3: lv_names_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleExport4934);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2469:2: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==18) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2469:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleExport4947); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2473:1: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2474:1: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2474:1: (lv_names_3_0= ruleQualifiedName )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2475:3: lv_names_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleExport4968);
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
            	    break loop42;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleExport4982); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2503:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2504:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2505:2: iv_ruleImportStmt= ruleImportStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStmtRule()); 
            }
            pushFollow(FOLLOW_ruleImportStmt_in_entryRuleImportStmt5018);
            iv_ruleImportStmt=ruleImportStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStmt5028); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2512:1: ruleImportStmt returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2515:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2516:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2516:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2516:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleImportStmt5065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2520:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2521:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2521:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2522:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5086);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2538:2: (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==34) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2538:4: otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleImportStmt5099); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2542:1: ( (lv_interface_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2543:1: (lv_interface_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2543:1: (lv_interface_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2544:3: lv_interface_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleImportStmt5120);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2560:4: (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2560:6: otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleImportStmt5135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImportStmtAccess().getWithKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2564:1: ( (lv_restriction_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2565:1: (lv_restriction_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2565:1: (lv_restriction_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2566:3: lv_restriction_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getRestrictionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleImportStmt5156);
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

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleImportStmt5170); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2594:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2595:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2596:2: iv_ruleConflictStmt= ruleConflictStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConflictStmtRule()); 
            }
            pushFollow(FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5206);
            iv_ruleConflictStmt=ruleConflictStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConflictStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConflictStmt5216); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2603:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2606:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2607:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2607:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2607:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleConflictStmt5253); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2611:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2612:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2612:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2613:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConflictStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleConflictStmt5274);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2629:2: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==28) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2629:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleConflictStmt5287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2633:1: ( (lv_restriction_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2634:1: (lv_restriction_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2634:1: (lv_restriction_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2635:3: lv_restriction_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getRestrictionExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConflictStmt5308);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleConflictStmt5322); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2663:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2664:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2665:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt5358);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt5368); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2672:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2675:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2676:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2676:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2676:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleVersionStmt5405); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2680:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2681:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2681:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2682:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt5422); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleVersionStmt5439); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2710:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2711:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2712:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefStatementRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement5475);
            iv_ruleOpDefStatement=ruleOpDefStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefStatement5485); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2719:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2722:28: ( (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2723:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2723:1: (otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2723:3: otherlv_0= 'def' ( (lv_result_1_0= ruleType ) ) ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleOpDefParameterList ) ) otherlv_5= ')' otherlv_6= '=' ( (lv_impl_7_0= ruleExpression ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleOpDefStatement5522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2727:1: ( (lv_result_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2728:1: (lv_result_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2728:1: (lv_result_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2729:3: lv_result_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefStatement5543);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2745:2: ( (lv_id_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2746:1: (lv_id_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2746:1: (lv_id_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2747:3: lv_id_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefStatement5564);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleOpDefStatement5576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2767:1: ( (lv_param_4_0= ruleOpDefParameterList ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2768:1: (lv_param_4_0= ruleOpDefParameterList )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2768:1: (lv_param_4_0= ruleOpDefParameterList )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2769:3: lv_param_4_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement5597);
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

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleOpDefStatement5609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleOpDefStatement5621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2793:1: ( (lv_impl_7_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2794:1: (lv_impl_7_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2794:1: (lv_impl_7_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2795:3: lv_impl_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleOpDefStatement5642);
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

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleOpDefStatement5654); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2823:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2824:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2825:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList5690);
            iv_ruleOpDefParameterList=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameterList5700); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2832:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2835:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2836:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2836:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2836:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2836:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2837:2: 
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2845:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_VERSION && LA47_0<=RULE_EXPONENT)||(LA47_0>=29 && LA47_0<=33)||(LA47_0>=40 && LA47_0<=42)||LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2845:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2845:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2846:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2846:1: (lv_list_1_0= ruleOpDefParameter )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2847:3: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5759);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2863:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==18) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2863:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleOpDefParameterList5772); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2867:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2868:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2868:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2869:3: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5793);
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
                    	    break loop46;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2893:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2894:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2895:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterRule()); 
            }
            pushFollow(FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter5833);
            iv_ruleOpDefParameter=ruleOpDefParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpDefParameter5843); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2902:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2905:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2906:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2906:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2906:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2906:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2907:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2907:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2908:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleOpDefParameter5889);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2924:2: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2925:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2925:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2926:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleOpDefParameter5910);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2942:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==19) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2942:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleOpDefParameter5923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2946:1: ( (lv_val_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2947:1: (lv_val_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2947:1: (lv_val_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2948:3: lv_val_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getValExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleOpDefParameter5944);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2972:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2973:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2974:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement5982);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement5992); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2981:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2984:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2985:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2985:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2985:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2985:2: ( (lv_expr_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2986:1: (lv_expr_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2986:1: (lv_expr_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:2987:3: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement6038);
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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionStatement6050); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3015:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3016:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3017:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression6086);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression6096); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3024:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3027:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3028:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3028:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt49=3;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3028:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3028:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3029:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3029:1: (lv_let_0_0= ruleLetExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3030:3: lv_let_0_0= ruleLetExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLetLetExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression6142);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3047:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3047:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3048:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3048:1: (lv_expr_1_0= ruleImplicationExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3049:3: lv_expr_1_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprImplicationExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImplicationExpression_in_ruleExpression6169);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3066:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3066:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3067:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3067:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3068:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCollectionCollectionInitializerParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpression6196);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3092:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3093:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3094:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression6232);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression6242); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3101:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3104:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3105:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3105:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3105:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleLetExpression6279); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3109:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3110:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3110:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3111:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLetExpression6300);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3127:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3128:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3128:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3129:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLetExpression6321);
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleLetExpression6333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3149:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3150:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3150:1: (lv_valueExpr_4_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3151:3: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression6354);
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

            otherlv_5=(Token)match(input,56,FOLLOW_56_in_ruleLetExpression6366); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3171:1: ( (lv_subExpr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3172:1: (lv_subExpr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3172:1: (lv_subExpr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3173:3: lv_subExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression6387);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3197:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3198:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3199:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression6423);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression6433); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3206:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3209:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3210:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3210:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3210:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3210:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3211:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3211:1: (lv_left_0_0= ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3212:3: lv_left_0_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftLogicalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression6479);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3228:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==19) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3229:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3229:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3230:3: lv_right_1_0= ruleAssignmentExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightAssignmentExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression6500);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3254:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3255:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3256:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart6537);
            iv_ruleAssignmentExpressionPart=ruleAssignmentExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpressionPart6547); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3263:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3266:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3267:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3267:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3267:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3267:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3268:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3268:1: (lv_op_0_0= ruleAssignmentOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3269:3: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart6593);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3285:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3285:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3285:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3286:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3286:1: (lv_ex_1_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3287:3: lv_ex_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getExLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart6615);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3304:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3304:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3305:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3305:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3306:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart6642);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3330:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3331:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3332:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator6680);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentOperator6691); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3339:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3342:28: (kw= '=' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3344:2: kw= '='
            {
            kw=(Token)match(input,19,FOLLOW_19_in_ruleAssignmentOperator6728); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3357:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3358:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3359:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression6767);
            iv_ruleImplicationExpression=ruleImplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpression6777); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3366:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3369:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3370:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3370:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3370:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3370:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3371:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3371:1: (lv_left_0_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3372:3: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression6823);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3388:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=57 && LA52_0<=58)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3389:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3389:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3390:3: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression6844);
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
    // $ANTLR end "ruleImplicationExpression"


    // $ANTLR start "entryRuleImplicationExpressionPart"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3414:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3415:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3416:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart6881);
            iv_ruleImplicationExpressionPart=ruleImplicationExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationExpressionPart6891); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3423:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3426:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3427:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3427:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3427:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3427:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3428:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3428:1: (lv_op_0_0= ruleImplicationOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3429:3: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart6937);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3445:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3446:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3446:1: (lv_ex_1_0= ruleAssignmentExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3447:3: lv_ex_1_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart6958);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3471:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3472:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3473:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator6995);
            iv_ruleImplicationOperator=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplicationOperator7006); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3480:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3483:28: ( (kw= 'implies' | kw= 'iff' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3484:1: (kw= 'implies' | kw= 'iff' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3484:1: (kw= 'implies' | kw= 'iff' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==57) ) {
                alt53=1;
            }
            else if ( (LA53_0==58) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3485:2: kw= 'implies'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleImplicationOperator7044); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3492:2: kw= 'iff'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleImplicationOperator7063); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3505:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3506:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3507:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7103);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression7113); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3514:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3517:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3518:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3518:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3518:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3518:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3519:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3519:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3520:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7159);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3536:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=59 && LA54_0<=61)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3537:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3537:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3538:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression7180);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3562:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3563:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3564:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart7217);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart7227); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3571:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3574:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3575:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3575:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3575:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3575:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3576:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3576:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3577:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart7273);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3593:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3594:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3594:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3595:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart7294);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3619:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3620:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3621:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator7331);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator7342); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3628:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3631:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3632:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3632:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt55=1;
                }
                break;
            case 60:
                {
                alt55=2;
                }
                break;
            case 61:
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3633:2: kw= 'and'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleLogicalOperator7380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3640:2: kw= 'or'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleLogicalOperator7399); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3647:2: kw= 'xor'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleLogicalOperator7418); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3660:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3661:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3662:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression7458);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression7468); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3669:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3672:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3673:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3674:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3674:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3675:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression7514);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3691:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=62 && LA56_0<=64)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3692:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3692:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3693:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression7535);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3717:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3718:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3719:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart7572);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart7582); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3726:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3729:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3730:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3730:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3730:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3730:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3731:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3731:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3732:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart7628);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3748:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3748:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3748:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3749:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3749:1: (lv_ex_1_0= ruleRelationalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3750:3: lv_ex_1_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart7650);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3767:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3767:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3768:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3768:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3769:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart7677);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3793:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3794:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3795:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator7715);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator7726); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3802:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3805:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3806:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3806:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt58=1;
                }
                break;
            case 63:
                {
                alt58=2;
                }
                break;
            case 64:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3807:2: kw= '=='
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleEqualityOperator7764); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3814:2: kw= '<>'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleEqualityOperator7783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3821:2: kw= '!='
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleEqualityOperator7802); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3834:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3835:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3836:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression7842);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression7852); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3843:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3846:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3847:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3847:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3847:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3847:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3848:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3848:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3849:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression7898);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3865:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=65 && LA59_0<=68)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3866:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3866:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3867:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression7919);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3891:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3892:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3893:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart7956);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart7966); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3900:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3903:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3904:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3904:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3904:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3904:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3905:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3906:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart8012);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3922:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3923:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3923:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3924:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart8033);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3948:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3949:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3950:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8070);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator8081); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3957:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3960:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3961:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3961:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt60=1;
                }
                break;
            case 66:
                {
                alt60=2;
                }
                break;
            case 67:
                {
                alt60=3;
                }
                break;
            case 68:
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3962:2: kw= '>'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleRelationalOperator8119); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3969:2: kw= '<'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleRelationalOperator8138); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3976:2: kw= '>='
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleRelationalOperator8157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3983:2: kw= '<='
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleRelationalOperator8176); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3996:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3997:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:3998:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression8216);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression8226); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4005:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4008:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4009:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4009:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4009:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4009:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4010:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4010:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4011:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression8272);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4027:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=69 && LA61_0<=70)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4028:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4028:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4029:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression8293);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4053:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4054:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4055:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart8330);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart8340); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4062:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4065:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4066:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4066:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4066:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4066:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4067:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4067:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4068:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart8386);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4084:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4085:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4085:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4086:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart8407);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4110:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4111:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4112:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator8444);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator8455); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4119:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4122:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4123:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4123:1: (kw= '+' | kw= '-' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==69) ) {
                alt62=1;
            }
            else if ( (LA62_0==70) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4124:2: kw= '+'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleAdditiveOperator8493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4131:2: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleAdditiveOperator8512); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4144:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4145:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4146:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression8552);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression8562); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4153:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4156:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4157:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4157:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4157:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4157:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4158:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4158:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4159:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression8608);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4175:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=71 && LA63_0<=72)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4176:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4176:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4177:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression8629);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4201:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4202:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4203:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart8666);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart8676); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4210:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4213:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4214:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4214:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4214:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4214:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4215:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4215:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4216:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart8722);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4232:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4233:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4233:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4234:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart8743);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4258:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4259:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4260:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator8780);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator8791); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4267:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4270:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4271:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4271:1: (kw= '*' | kw= '/' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==71) ) {
                alt64=1;
            }
            else if ( (LA64_0==72) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4272:2: kw= '*'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleMultiplicativeOperator8829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4279:2: kw= '/'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator8848); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4292:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4293:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4294:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression8888);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression8898); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4301:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4304:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4305:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4305:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4305:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4305:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==70||LA65_0==73) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4306:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4306:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4307:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression8944);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4323:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4324:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4324:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4325:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression8966);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4349:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4350:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4351:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator9003);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator9014); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4358:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4361:28: ( (kw= 'not' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4362:1: (kw= 'not' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4362:1: (kw= 'not' | kw= '-' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==73) ) {
                alt66=1;
            }
            else if ( (LA66_0==70) ) {
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4363:2: kw= 'not'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleUnaryOperator9052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4370:2: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleUnaryOperator9071); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4383:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4384:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4385:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9111);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression9121); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4392:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4395:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt69=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==EOF||(LA69_1>=15 && LA69_1<=16)||(LA69_1>=18 && LA69_1<=19)||(LA69_1>=25 && LA69_1<=26)||(LA69_1>=34 && LA69_1<=35)||LA69_1==47||(LA69_1>=56 && LA69_1<=72)||(LA69_1>=74 && LA69_1<=76)||(LA69_1>=79 && LA69_1<=81)) ) {
                    alt69=2;
                }
                else if ( (LA69_1==24) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==EOF||(LA69_2>=15 && LA69_2<=16)||(LA69_2>=18 && LA69_2<=19)||(LA69_2>=25 && LA69_2<=26)||(LA69_2>=34 && LA69_2<=35)||LA69_2==47||(LA69_2>=56 && LA69_2<=72)||(LA69_2>=74 && LA69_2<=76)||(LA69_2>=79 && LA69_2<=81)) ) {
                    alt69=2;
                }
                else if ( (LA69_2==24) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA69_3 = input.LA(2);

                if ( (LA69_3==EOF||(LA69_3>=15 && LA69_3<=16)||(LA69_3>=18 && LA69_3<=19)||(LA69_3>=25 && LA69_3<=26)||(LA69_3>=34 && LA69_3<=35)||LA69_3==47||(LA69_3>=56 && LA69_3<=72)||(LA69_3>=74 && LA69_3<=76)||(LA69_3>=79 && LA69_3<=81)) ) {
                    alt69=2;
                }
                else if ( (LA69_3==24) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                int LA69_4 = input.LA(2);

                if ( (LA69_4==EOF||(LA69_4>=15 && LA69_4<=16)||(LA69_4>=18 && LA69_4<=19)||(LA69_4>=25 && LA69_4<=26)||(LA69_4>=34 && LA69_4<=35)||LA69_4==47||(LA69_4>=56 && LA69_4<=72)||(LA69_4>=74 && LA69_4<=76)||(LA69_4>=79 && LA69_4<=81)) ) {
                    alt69=2;
                }
                else if ( (LA69_4==24) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 4, input);

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
                alt69=2;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4396:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4397:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4397:1: (lv_call_0_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4398:3: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePostfixExpression9168);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4414:2: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==35) ) {
                            switch ( input.LA(2) ) {
                            case RULE_ID:
                                {
                                int LA67_4 = input.LA(3);

                                if ( (LA67_4==24) ) {
                                    alt67=1;
                                }


                                }
                                break;
                            case RULE_VERSION:
                                {
                                int LA67_5 = input.LA(3);

                                if ( (LA67_5==24) ) {
                                    alt67=1;
                                }


                                }
                                break;
                            case RULE_EXPONENT:
                                {
                                int LA67_6 = input.LA(3);

                                if ( (LA67_6==24) ) {
                                    alt67=1;
                                }


                                }
                                break;
                            case 53:
                                {
                                int LA67_7 = input.LA(3);

                                if ( (LA67_7==24) ) {
                                    alt67=1;
                                }


                                }
                                break;

                            }

                        }
                        else if ( ((LA67_0>=74 && LA67_0<=75)) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4415:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4415:1: (lv_fCalls_1_0= ruleCall )
                    	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4416:3: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCall_in_rulePostfixExpression9189);
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
                    	    break loop67;
                        }
                    } while (true);

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4432:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==35) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4433:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4433:1: (lv_access_2_0= ruleExpressionAccess )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4434:3: lv_access_2_0= ruleExpressionAccess
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getAccessExpressionAccessParserRuleCall_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpressionAccess_in_rulePostfixExpression9211);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4451:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4451:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4452:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4452:1: (lv_left_3_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4453:3: lv_left_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression9240);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4477:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4478:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4479:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall9276);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall9286); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4486:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4489:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4490:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4490:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt70=1;
                }
                break;
            case 74:
                {
                alt70=2;
                }
                break;
            case 75:
                {
                alt70=3;
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4490:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4490:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4490:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleCall9324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4494:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4495:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4495:1: (lv_call_1_0= ruleFeatureCall )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4496:3: lv_call_1_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getCallFeatureCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleCall9345);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4513:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4513:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4513:8: otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) )
                    {
                    otherlv_2=(Token)match(input,74,FOLLOW_74_in_ruleCall9365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4517:1: ( (lv_setOp_3_0= ruleSetOp ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4518:1: (lv_setOp_3_0= ruleSetOp )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4518:1: (lv_setOp_3_0= ruleSetOp )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4519:3: lv_setOp_3_0= ruleSetOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getSetOpSetOpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSetOp_in_ruleCall9386);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4536:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4536:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4536:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,75,FOLLOW_75_in_ruleCall9406); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4540:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4541:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4541:1: (lv_arrayEx_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4542:3: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleCall9427);
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

                    otherlv_6=(Token)match(input,76,FOLLOW_76_in_ruleCall9439); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4570:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4571:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4572:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall9476);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall9486); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4579:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4582:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4583:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4583:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4583:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4583:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4584:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4584:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4585:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleFeatureCall9532);
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleFeatureCall9544); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4605:1: ( (lv_param_2_0= ruleActualParameterList ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_NUMBER && LA71_0<=RULE_EXPONENT)||LA71_0==14||LA71_0==24||(LA71_0>=36 && LA71_0<=39)||LA71_0==53||LA71_0==55||LA71_0==70||LA71_0==73||(LA71_0>=77 && LA71_0<=78)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4606:1: (lv_param_2_0= ruleActualParameterList )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4606:1: (lv_param_2_0= ruleActualParameterList )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4607:3: lv_param_2_0= ruleActualParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getParamActualParameterListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleActualParameterList_in_ruleFeatureCall9565);
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

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleFeatureCall9578); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4635:1: entryRuleSetOp returns [EObject current=null] : iv_ruleSetOp= ruleSetOp EOF ;
    public final EObject entryRuleSetOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOp = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4636:2: (iv_ruleSetOp= ruleSetOp EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4637:2: iv_ruleSetOp= ruleSetOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetOpRule()); 
            }
            pushFollow(FOLLOW_ruleSetOp_in_entryRuleSetOp9614);
            iv_ruleSetOp=ruleSetOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetOp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetOp9624); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4644:1: ruleSetOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) ;
    public final EObject ruleSetOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_declEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4647:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4648:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4648:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4648:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4648:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4649:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4649:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4650:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleSetOp9670);
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

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSetOp9682); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4670:1: ( (lv_decl_2_0= ruleDeclarator ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4671:1: (lv_decl_2_0= ruleDeclarator )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4671:1: (lv_decl_2_0= ruleDeclarator )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4672:3: lv_decl_2_0= ruleDeclarator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarator_in_ruleSetOp9703);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4688:2: ( (lv_declEx_3_0= ruleExpression ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_NUMBER && LA72_0<=RULE_EXPONENT)||LA72_0==14||LA72_0==24||(LA72_0>=36 && LA72_0<=39)||LA72_0==53||LA72_0==55||LA72_0==70||LA72_0==73||(LA72_0>=77 && LA72_0<=78)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4689:1: (lv_declEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4689:1: (lv_declEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4690:3: lv_declEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclExExpressionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSetOp9724);
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

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSetOp9737); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4718:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4719:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4720:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator9773);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator9783); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4727:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4730:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4731:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4731:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4731:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4731:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4732:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4732:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4733:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator9829);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4749:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==16) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4749:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleDeclarator9842); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4753:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4754:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4754:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4755:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator9863);
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
            	    break loop73;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleDeclarator9877); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4783:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4784:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4785:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration9913);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration9923); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4792:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4795:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4796:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4796:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4796:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4796:2: ( (lv_type_0_0= ruleType ) )?
            int alt74=2;
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
                    alt74=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA74_2 = input.LA(2);

                    if ( ((LA74_2>=RULE_VERSION && LA74_2<=RULE_EXPONENT)||LA74_2==34||LA74_2==53) ) {
                        alt74=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA74_3 = input.LA(2);

                    if ( ((LA74_3>=RULE_VERSION && LA74_3<=RULE_EXPONENT)||LA74_3==34||LA74_3==53) ) {
                        alt74=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA74_4 = input.LA(2);

                    if ( ((LA74_4>=RULE_VERSION && LA74_4<=RULE_EXPONENT)||LA74_4==34||LA74_4==53) ) {
                        alt74=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA74_5 = input.LA(2);

                    if ( ((LA74_5>=RULE_VERSION && LA74_5<=RULE_EXPONENT)||LA74_5==34||LA74_5==53) ) {
                        alt74=1;
                    }
                    }
                    break;
            }

            switch (alt74) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4797:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4797:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4798:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration9969);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4814:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4815:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4815:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4816:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration9991);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4832:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==18) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4832:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleDeclaration10004); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4836:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4837:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4837:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4838:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration10025);
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
            	    break loop75;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4854:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==19) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4854:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleDeclaration10040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4858:1: ( (lv_init_5_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4859:1: (lv_init_5_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4859:1: (lv_init_5_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4860:3: lv_init_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getInitExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclaration10061);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4884:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4885:2: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4886:2: iv_ruleActualParameterList= ruleActualParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10099);
            iv_ruleActualParameterList=ruleActualParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleActualParameterList10109); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4893:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4896:28: ( ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4897:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4897:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4897:2: ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4897:2: ( (lv_param_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4898:1: (lv_param_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4898:1: (lv_param_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4899:3: lv_param_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList10155);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4915:2: (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==18) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4915:4: otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleActualParameterList10168); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4919:1: ( (lv_param_2_0= ruleExpression ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4920:1: (lv_param_2_0= ruleExpression )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4920:1: (lv_param_2_0= ruleExpression )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4921:3: lv_param_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleActualParameterList10189);
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
            	    break loop77;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4945:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4946:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4947:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionAccessRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess10227);
            iv_ruleExpressionAccess=ruleExpressionAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionAccess; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionAccess10237); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4954:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4957:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4958:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4958:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4958:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleExpressionAccess10274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4962:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4963:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4963:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4964:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionAccess10295);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4980:2: ( (lv_calls_2_0= ruleCall ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA78_4 = input.LA(3);

                        if ( (LA78_4==24) ) {
                            alt78=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA78_5 = input.LA(3);

                        if ( (LA78_5==24) ) {
                            alt78=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA78_6 = input.LA(3);

                        if ( (LA78_6==24) ) {
                            alt78=1;
                        }


                        }
                        break;
                    case 53:
                        {
                        int LA78_7 = input.LA(3);

                        if ( (LA78_7==24) ) {
                            alt78=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA78_0>=74 && LA78_0<=75)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4981:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4981:1: (lv_calls_2_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4982:3: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_ruleExpressionAccess10316);
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
            	    break loop78;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4998:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==35) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4999:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:4999:1: (lv_access_3_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5000:3: lv_access_3_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getAccessExpressionAccessParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess10338);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5024:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5025:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5026:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression10375);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression10385); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5033:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5036:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' ) )
            int alt80=4;
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
                alt80=1;
                }
                break;
            case 24:
                {
                alt80=2;
                }
                break;
            case 78:
                {
                alt80=3;
                }
                break;
            case 77:
                {
                alt80=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5037:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5038:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5038:1: (lv_lit_0_0= ruleLiteral )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5039:3: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression10432);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5056:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5056:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5056:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression10451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5060:1: ( (lv_ex_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5061:1: (lv_ex_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5061:1: (lv_ex_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5062:3: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression10472);
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression10484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5083:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5083:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5084:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5084:1: (lv_ifEx_4_0= ruleIfExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5085:3: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression10512);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5102:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5102:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')' )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5102:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refName_7_0= ruleIdentifier ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,77,FOLLOW_77_in_rulePrimaryExpression10531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_rulePrimaryExpression10543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5110:1: ( (lv_refName_7_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5111:1: (lv_refName_7_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5111:1: (lv_refName_7_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5112:3: lv_refName_7_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefNameIdentifierParserRuleCall_0_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_rulePrimaryExpression10564);
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

                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression10576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5132:3: ( (lv_calls_9_0= ruleCall ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==35) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA81_4 = input.LA(3);

                        if ( (LA81_4==24) ) {
                            alt81=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA81_5 = input.LA(3);

                        if ( (LA81_5==24) ) {
                            alt81=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA81_6 = input.LA(3);

                        if ( (LA81_6==24) ) {
                            alt81=1;
                        }


                        }
                        break;
                    case 53:
                        {
                        int LA81_7 = input.LA(3);

                        if ( (LA81_7==24) ) {
                            alt81=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA81_0>=74 && LA81_0<=75)) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5133:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5133:1: (lv_calls_9_0= ruleCall )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5134:3: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCall_in_rulePrimaryExpression10599);
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
            	    break loop81;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5150:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==35) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5151:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5151:1: (lv_access_10_0= ruleExpressionAccess )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5152:3: lv_access_10_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAccessExpressionAccessParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression10621);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5176:1: entryRuleCollectionInitializer returns [EObject current=null] : iv_ruleCollectionInitializer= ruleCollectionInitializer EOF ;
    public final EObject entryRuleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5177:2: (iv_ruleCollectionInitializer= ruleCollectionInitializer EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5178:2: iv_ruleCollectionInitializer= ruleCollectionInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer10658);
            iv_ruleCollectionInitializer=ruleCollectionInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionInitializer10668); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5185:1: ruleCollectionInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5188:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5189:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5189:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5189:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5189:2: ()
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5190:2: 
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5198:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_VERSION && LA83_0<=RULE_EXPONENT)||LA83_0==53) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5199:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5199:1: (lv_type_1_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5200:3: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer10726);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleCollectionInitializer10739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCollectionInitializerAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5220:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_NUMBER && LA84_0<=RULE_EXPONENT)||LA84_0==14||LA84_0==24||(LA84_0>=36 && LA84_0<=39)||LA84_0==53||LA84_0==70||LA84_0==73||(LA84_0>=77 && LA84_0<=78)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5221:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5221:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5222:3: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer10760);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCollectionInitializer10773); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5250:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5251:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5252:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange10809);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListOrRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListOrRange10819); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5259:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5262:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5263:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5263:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5263:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5263:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5264:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5264:1: (lv_list_0_0= ruleExpressionListEntry )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5265:3: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10865);
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

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5281:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==18) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5281:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleExpressionListOrRange10878); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5285:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5286:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5286:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5287:3: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10899);
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
    // $ANTLR end "ruleExpressionListOrRange"


    // $ANTLR start "entryRuleExpressionListEntry"
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5311:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5312:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5313:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListEntryRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry10937);
            iv_ruleExpressionListEntry=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListEntry; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionListEntry10947); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5320:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5323:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5324:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5325:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5325:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5326:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10994);
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

                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5342:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==35) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5342:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleExpressionListEntry11007); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5346:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5347:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5347:1: (lv_attrib_2_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5348:3: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11028);
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

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleExpressionListEntry11042); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5368:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            int alt88=2;
            alt88 = dfa88.predict(input);
            switch (alt88) {
                case 1 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5368:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5368:4: ( (lv_value_4_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5369:1: (lv_value_4_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5369:1: (lv_value_4_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5370:3: lv_value_4_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getValueLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11066);
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5387:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5387:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5388:1: (lv_collection_5_0= ruleCollectionInitializer )
                    {
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5388:1: (lv_collection_5_0= ruleCollectionInitializer )
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5389:3: lv_collection_5_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11093);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5413:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5414:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5415:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral11130);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral11140); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5422:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5425:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5426:1: ( (lv_val_0_0= ruleValue ) )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5426:1: ( (lv_val_0_0= ruleValue ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5427:1: (lv_val_0_0= ruleValue )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5427:1: (lv_val_0_0= ruleValue )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5428:3: lv_val_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValue_in_ruleLiteral11185);
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5452:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5453:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5454:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression11220);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression11230); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5461:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) ;
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
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5464:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5465:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5465:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5465:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_78_in_ruleIfExpression11267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5469:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5470:1: (lv_ifEx_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5470:1: (lv_ifEx_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5471:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11288);
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

            otherlv_2=(Token)match(input,79,FOLLOW_79_in_ruleIfExpression11300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5491:1: ( (lv_thenEx_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5492:1: (lv_thenEx_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5492:1: (lv_thenEx_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5493:3: lv_thenEx_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11321);
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

            otherlv_4=(Token)match(input,80,FOLLOW_80_in_ruleIfExpression11333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5513:1: ( (lv_elseEx_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5514:1: (lv_elseEx_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5514:1: (lv_elseEx_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5515:3: lv_elseEx_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression11354);
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

            otherlv_6=(Token)match(input,81,FOLLOW_81_in_ruleIfExpression11366); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5543:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5544:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5545:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier11403);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier11414); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5552:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5555:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5556:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5556:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
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
            case 53:
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
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5556:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier11454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5564:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier11480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5572:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier11506); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:5581:2: kw= 'version'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleIdentifier11530); if (state.failed) return current;
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

    // $ANTLR start synpred46_InternalIvml
    public final void synpred46_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1778:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1779:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1779:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1780:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred46_InternalIvml3470);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred46_InternalIvml

    // $ANTLR start synpred51_InternalIvml
    public final void synpred51_InternalIvml_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1860:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1861:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1861:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.ivml/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalIvml.g:1862:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred51_InternalIvml3635); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_InternalIvml

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
    public final boolean synpred51_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalIvml_fragment(); // can never throw exception
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
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA88 dfa88 = new DFA88(this);
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
    static final String DFA49_eotS =
        "\16\uffff";
    static final String DFA49_eofS =
        "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String DFA49_minS =
        "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA49_maxS =
        "\1\116\2\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA49_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String DFA49_specialS =
        "\16\uffff}>";
    static final String[] DFA49_transitionS = {
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
            return "3028:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA51_eotS =
        "\15\uffff";
    static final String DFA51_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA51_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA51_maxS =
        "\1\116\1\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA51_specialS =
        "\15\uffff}>";
    static final String[] DFA51_transitionS = {
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "3285:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA57_eotS =
        "\15\uffff";
    static final String DFA57_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA57_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA57_maxS =
        "\1\116\1\uffff\4\121\1\uffff\1\65\4\121\1\65";
    static final String DFA57_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA57_specialS =
        "\15\uffff}>";
    static final String[] DFA57_transitionS = {
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

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "3748:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String DFA87_eotS =
        "\14\uffff";
    static final String DFA87_eofS =
        "\1\uffff\4\5\3\uffff\4\5";
    static final String DFA87_minS =
        "\1\4\4\16\1\uffff\1\6\1\uffff\4\17";
    static final String DFA87_maxS =
        "\1\116\4\113\1\uffff\1\65\1\uffff\4\113";
    static final String DFA87_acceptS =
        "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA87_specialS =
        "\14\uffff}>";
    static final String[] DFA87_transitionS = {
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
            return "5324:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA88_eotS =
        "\15\uffff";
    static final String DFA88_eofS =
        "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String DFA88_minS =
        "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String DFA88_maxS =
        "\1\116\1\uffff\4\113\1\uffff\1\65\4\113\1\65";
    static final String DFA88_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String DFA88_specialS =
        "\15\uffff}>";
    static final String[] DFA88_transitionS = {
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

    static final short[] DFA88_eot = DFA.unpackEncodedString(DFA88_eotS);
    static final short[] DFA88_eof = DFA.unpackEncodedString(DFA88_eofS);
    static final char[] DFA88_min = DFA.unpackEncodedStringToUnsignedChars(DFA88_minS);
    static final char[] DFA88_max = DFA.unpackEncodedStringToUnsignedChars(DFA88_maxS);
    static final short[] DFA88_accept = DFA.unpackEncodedString(DFA88_acceptS);
    static final short[] DFA88_special = DFA.unpackEncodedString(DFA88_specialS);
    static final short[][] DFA88_transition;

    static {
        int numStates = DFA88_transitionS.length;
        DFA88_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA88_transition[i] = DFA.unpackEncodedString(DFA88_transitionS[i]);
        }
    }

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = DFA88_eot;
            this.eof = DFA88_eof;
            this.min = DFA88_min;
            this.max = DFA88_max;
            this.accept = DFA88_accept;
            this.special = DFA88_special;
            this.transition = DFA88_transition;
        }
        public String getDescription() {
            return "5368:3: ( ( (lv_value_4_0= ruleLogicalExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )";
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
    public static final BitSet FOLLOW_ruleExpression_in_ruleTypedefConstraint2173 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_18_in_ruleTypedefConstraint2186 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTypedefConstraint2207 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_25_in_ruleTypedefConstraint2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration2313 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2334 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleVariableDeclaration2347 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleVariableDeclaration2368 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleVariableDeclaration2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_entryRuleVariableDeclarationPart2418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationPart2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclarationPart2474 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclarationPart2487 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationPart2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType2546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBasicType2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBasicType2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBasicType2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBasicType2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBasicType2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType2796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleType2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleType2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_ruleType2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue2942 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3090 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3108 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3143 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName3161 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessName_in_entryRuleAccessName3235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessName3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAccessName3288 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAccessName3322 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue3359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleValue3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValue3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleValue3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleValue3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleValue3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleValue3565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleValue3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleValue3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDerivedType_in_entryRuleDerivedType3690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDerivedType3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleDerivedType3744 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_41_in_ruleDerivedType3781 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_42_in_ruleDerivedType3818 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDerivedType3844 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleDerivedType3865 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDerivedType3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotateTo_in_entryRuleAnnotateTo3913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotateTo3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleAnnotateTo3968 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_44_in_ruleAnnotateTo3997 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleAnnotateTo4034 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleVariableDeclarationPart_in_ruleAnnotateTo4055 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAnnotateTo4067 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAnnotateTo4088 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleAnnotateTo4101 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAnnotateTo4122 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleAnnotateTo4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeze_in_entryRuleFreeze4172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeze4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFreeze4219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFreeze4231 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_ruleFreeze4252 = new BitSet(new long[]{0x00200000000081C0L});
    public static final BitSet FOLLOW_15_in_ruleFreeze4265 = new BitSet(new long[]{0x0000400000010002L});
    public static final BitSet FOLLOW_46_in_ruleFreeze4278 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFreeze4290 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleFreeze4311 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleFreeze4323 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleFreeze4344 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFreeze4356 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFreeze4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreezeStatement_in_entryRuleFreezeStatement4409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreezeStatement4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFreezeStatement4465 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_ruleAccessName_in_ruleFreezeStatement4486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFreezeStatement4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEval_in_entryRuleEval4535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEval4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEval4582 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEval4594 = new BitSet(new long[]{0x00A100F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleEval_in_ruleEval4615 = new BitSet(new long[]{0x00A100F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleEval4637 = new BitSet(new long[]{0x00A000F00100C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_15_in_ruleEval4650 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleEval4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration4701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDeclaration4711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInterfaceDeclaration4748 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInterfaceDeclaration4769 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInterfaceDeclaration4781 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_ruleExport_in_ruleInterfaceDeclaration4802 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInterfaceDeclaration4815 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceDeclaration4828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport4866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleExport4913 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleExport4934 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleExport4947 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleExport4968 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleExport4982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStmt_in_entryRuleImportStmt5018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStmt5028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleImportStmt5065 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5086 = new BitSet(new long[]{0x0000000410010000L});
    public static final BitSet FOLLOW_34_in_ruleImportStmt5099 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImportStmt5120 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_28_in_ruleImportStmt5135 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleImportStmt5156 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleImportStmt5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConflictStmt_in_entryRuleConflictStmt5206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConflictStmt5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleConflictStmt5253 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleConflictStmt5274 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_28_in_ruleConflictStmt5287 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConflictStmt5308 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConflictStmt5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt5358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt5368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVersionStmt5405 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt5422 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVersionStmt5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefStatement_in_entryRuleOpDefStatement5475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefStatement5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpDefStatement5522 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefStatement5543 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefStatement5564 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleOpDefStatement5576 = new BitSet(new long[]{0x00200703E20001C0L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_ruleOpDefStatement5597 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpDefStatement5609 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOpDefStatement5621 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefStatement5642 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOpDefStatement5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameterList_in_entryRuleOpDefParameterList5690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameterList5700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5759 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleOpDefParameterList5772 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_ruleOpDefParameterList5793 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleOpDefParameter_in_entryRuleOpDefParameter5833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpDefParameter5843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleOpDefParameter5889 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleOpDefParameter5910 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleOpDefParameter5923 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOpDefParameter5944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement5982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement5992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement6038 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleExpressionStatement6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression6086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression6142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_ruleExpression6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpression6196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression6232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression6242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleLetExpression6279 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLetExpression6300 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLetExpression6321 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLetExpression6333 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression6354 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleLetExpression6366 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression6423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpression6479 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_ruleAssignmentExpression6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpressionPart_in_entryRuleAssignmentExpressionPart6537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpressionPart6547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpressionPart6593 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleAssignmentExpressionPart6615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleAssignmentExpressionPart6642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_entryRuleAssignmentOperator6680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentOperator6691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleAssignmentOperator6728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpression_in_entryRuleImplicationExpression6767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpression6777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpression6823 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_ruleImplicationExpression6844 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleImplicationExpressionPart_in_entryRuleImplicationExpressionPart6881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationExpressionPart6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_ruleImplicationExpressionPart6937 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleImplicationExpressionPart6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplicationOperator_in_entryRuleImplicationOperator6995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplicationOperator7006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleImplicationOperator7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleImplicationOperator7063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression7103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression7113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression7159 = new BitSet(new long[]{0x3800000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression7180 = new BitSet(new long[]{0x3800000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart7217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart7227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart7273 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator7331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleLogicalOperator7380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleLogicalOperator7399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleLogicalOperator7418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression7458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression7468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression7514 = new BitSet(new long[]{0xC000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression7535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart7572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart7582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart7628 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart7650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleEqualityExpressionPart7677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator7715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator7726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleEqualityOperator7764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleEqualityOperator7783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleEqualityOperator7802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression7842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression7898 = new BitSet(new long[]{0x0000000000000002L,0x000000000000001EL});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression7919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart7956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart7966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart8012 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart8033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator8070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator8081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleRelationalOperator8119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleRelationalOperator8138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRelationalOperator8157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator8176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression8216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression8272 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression8293 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart8330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart8340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart8386 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart8407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator8444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator8455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleAdditiveOperator8493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator8512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression8552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression8562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression8608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression8629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart8666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart8722 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart8743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator8780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplicativeOperator8829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator8848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression8888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression8898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression8944 = new BitSet(new long[]{0x002000F0010001F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression8966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator9003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator9014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleUnaryOperator9052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleUnaryOperator9071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression9111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression9121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePostfixExpression9168 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePostfixExpression9189 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePostfixExpression9211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression9240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall9276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall9286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCall9324 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleCall9345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleCall9365 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleSetOp_in_ruleCall9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleCall9406 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCall9427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCall9439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall9476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall9486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleFeatureCall9532 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCall9544 = new BitSet(new long[]{0x00A000F0030041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_ruleFeatureCall9565 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCall9578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetOp_in_entryRuleSetOp9614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetOp9624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleSetOp9670 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSetOp9682 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleSetOp9703 = new BitSet(new long[]{0x00A000F0030041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSetOp9724 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSetOp9737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator9773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator9783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator9829 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_16_in_ruleDeclarator9842 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator9863 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_47_in_ruleDeclarator9877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration9913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration9923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration9969 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration9991 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleDeclaration10004 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration10025 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_19_in_ruleDeclaration10040 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclaration10061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActualParameterList_in_entryRuleActualParameterList10099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActualParameterList10109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList10155 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleActualParameterList10168 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleActualParameterList10189 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_entryRuleExpressionAccess10227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionAccess10237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleExpressionAccess10274 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionAccess10295 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_ruleExpressionAccess10316 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_ruleExpressionAccess10338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression10375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression10385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression10432 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression10451 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression10472 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression10484 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression10512 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_77_in_rulePrimaryExpression10531 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryExpression10543 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rulePrimaryExpression10564 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression10576 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleCall_in_rulePrimaryExpression10599 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionAccess_in_rulePrimaryExpression10621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_entryRuleCollectionInitializer10658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionInitializer10668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCollectionInitializer10726 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCollectionInitializer10739 = new BitSet(new long[]{0x00A000F00100C1F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_ruleCollectionInitializer10760 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCollectionInitializer10773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListOrRange_in_entryRuleExpressionListOrRange10809 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListOrRange10819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10865 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleExpressionListOrRange10878 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_ruleExpressionListOrRange10899 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleExpressionListEntry_in_entryRuleExpressionListEntry10937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionListEntry10947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry10994 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_35_in_ruleExpressionListEntry11007 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionListEntry11028 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleExpressionListEntry11042 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpressionListEntry11066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionInitializer_in_ruleExpressionListEntry11093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral11130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral11140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleLiteral11185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression11220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression11230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleIfExpression11267 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11288 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleIfExpression11300 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleIfExpression11333 = new BitSet(new long[]{0x00A000F0010041F0L,0x0000000000006240L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression11354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleIfExpression11366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier11403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier11414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier11454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier11480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier11506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleIdentifier11530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred2_InternalIvml287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred46_InternalIvml3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred51_InternalIvml3635 = new BitSet(new long[]{0x0000000000000002L});

}