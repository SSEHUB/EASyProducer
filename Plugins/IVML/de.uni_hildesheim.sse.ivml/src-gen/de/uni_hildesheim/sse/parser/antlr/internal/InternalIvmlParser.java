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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'abstract'", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'::'", "'.'", "'true'", "'false'", "'self'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'attribute'", "'annotate'", "'freeze'", "'but'", "'|'", "'eval'", "'interface'", "'export'", "'import'", "'conflicts'", "'version'", "'def'", "'static'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'->'", "'['", "']'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
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
    public static final int T__82=82;
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
    public String getGrammarFileName() { return "InternalIvml.g"; }



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
    // InternalIvml.g:73:1: entryRuleVariabilityUnit returns [EObject current=null] : iv_ruleVariabilityUnit= ruleVariabilityUnit EOF ;
    public final EObject entryRuleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariabilityUnit = null;


        try {
            // InternalIvml.g:74:2: (iv_ruleVariabilityUnit= ruleVariabilityUnit EOF )
            // InternalIvml.g:75:2: iv_ruleVariabilityUnit= ruleVariabilityUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariabilityUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariabilityUnit=ruleVariabilityUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariabilityUnit; 
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
    // $ANTLR end "entryRuleVariabilityUnit"


    // $ANTLR start "ruleVariabilityUnit"
    // InternalIvml.g:82:1: ruleVariabilityUnit returns [EObject current=null] : ( () ( (lv_projects_1_0= ruleProject ) )* ) ;
    public final EObject ruleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_projects_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:85:28: ( ( () ( (lv_projects_1_0= ruleProject ) )* ) )
            // InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            {
            // InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            // InternalIvml.g:86:2: () ( (lv_projects_1_0= ruleProject ) )*
            {
            // InternalIvml.g:86:2: ()
            // InternalIvml.g:87:2: 
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

            // InternalIvml.g:95:2: ( (lv_projects_1_0= ruleProject ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    {
            	    // InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    // InternalIvml.g:97:3: lv_projects_1_0= ruleProject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariabilityUnitAccess().getProjectsProjectParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
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
            	              		"de.uni_hildesheim.sse.Ivml.Project");
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
    // InternalIvml.g:121:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalIvml.g:122:2: (iv_ruleProject= ruleProject EOF )
            // InternalIvml.g:123:2: iv_ruleProject= ruleProject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProject; 
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
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalIvml.g:130:1: ruleProject returns [EObject current=null] : (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) ;
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
            // InternalIvml.g:133:28: ( (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) )
            // InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            {
            // InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            // InternalIvml.g:134:3: otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
                  
            }
            // InternalIvml.g:138:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:140:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:160:1: ( (lv_version_3_0= ruleVersionStmt ) )?
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
                    // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    {
                    // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    // InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
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
                              		"de.uni_hildesheim.sse.Ivml.VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:178:3: ( (lv_imports_4_0= ruleImportStmt ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==51) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    {
            	    // InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    // InternalIvml.g:180:3: lv_imports_4_0= ruleImportStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getImportsImportStmtParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_6);
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
            	              		"de.uni_hildesheim.sse.Ivml.ImportStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalIvml.g:196:3: ( (lv_conflicts_5_0= ruleConflictStmt ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==52) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    {
            	    // InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    // InternalIvml.g:198:3: lv_conflicts_5_0= ruleConflictStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getConflictsConflictStmtParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_7);
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
            	              		"de.uni_hildesheim.sse.Ivml.ConflictStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalIvml.g:214:3: ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==49) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    {
            	    // InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    // InternalIvml.g:216:3: lv_interfaces_6_0= ruleInterfaceDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getInterfacesInterfaceDeclarationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_8);
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
            	              		"de.uni_hildesheim.sse.Ivml.InterfaceDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalIvml.g:232:3: ( (lv_contents_7_0= ruleProjectContents ) )
            // InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            {
            // InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            // InternalIvml.g:234:3: lv_contents_7_0= ruleProjectContents
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getContentsProjectContentsParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_9);
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
                      		"de.uni_hildesheim.sse.Ivml.ProjectContents");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // InternalIvml.g:254:1: (otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalIvml.g:254:3: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:266:1: entryRuleProjectContents returns [EObject current=null] : iv_ruleProjectContents= ruleProjectContents EOF ;
    public final EObject entryRuleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectContents = null;


        try {
            // InternalIvml.g:267:2: (iv_ruleProjectContents= ruleProjectContents EOF )
            // InternalIvml.g:268:2: iv_ruleProjectContents= ruleProjectContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectContentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProjectContents=ruleProjectContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProjectContents; 
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
    // $ANTLR end "entryRuleProjectContents"


    // $ANTLR start "ruleProjectContents"
    // InternalIvml.g:275:1: ruleProjectContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) ;
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
            // InternalIvml.g:278:28: ( ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) )
            // InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            {
            // InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            // InternalIvml.g:279:2: () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            {
            // InternalIvml.g:279:2: ()
            // InternalIvml.g:280:2: 
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

            // InternalIvml.g:288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            loop7:
            do {
                int alt7=9;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    {
            	    // InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    // InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    {
            	    // InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    // InternalIvml.g:290:3: lv_elements_1_0= ruleTypedef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsTypedefParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.Typedef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    // InternalIvml.g:309:3: lv_elements_2_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsVariableDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    {
            	    // InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    // InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    {
            	    // InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    // InternalIvml.g:328:3: lv_elements_3_0= ruleFreeze
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsFreezeParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.Freeze");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    // InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    {
            	    // InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    // InternalIvml.g:347:3: lv_elements_4_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsEvalParserRuleCall_1_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    // InternalIvml.g:366:3: lv_elements_5_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsExpressionStatementParserRuleCall_1_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    {
            	    // InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    // InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    {
            	    // InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    // InternalIvml.g:385:3: lv_elements_6_0= ruleAnnotateTo
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAnnotateToParserRuleCall_1_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.AnnotateTo");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    {
            	    // InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    // InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    {
            	    // InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    // InternalIvml.g:404:3: lv_elements_7_0= ruleOpDefStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsOpDefStatementParserRuleCall_1_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.OpDefStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    // InternalIvml.g:423:3: lv_elements_8_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAttrAssignmentParserRuleCall_1_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
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
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
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
    // InternalIvml.g:447:1: entryRuleTypedef returns [EObject current=null] : iv_ruleTypedef= ruleTypedef EOF ;
    public final EObject entryRuleTypedef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedef = null;


        try {
            // InternalIvml.g:448:2: (iv_ruleTypedef= ruleTypedef EOF )
            // InternalIvml.g:449:2: iv_ruleTypedef= ruleTypedef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedef=ruleTypedef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedef; 
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
    // $ANTLR end "entryRuleTypedef"


    // $ANTLR start "ruleTypedef"
    // InternalIvml.g:456:1: ruleTypedef returns [EObject current=null] : ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) ;
    public final EObject ruleTypedef() throws RecognitionException {
        EObject current = null;

        EObject lv_tEnum_0_0 = null;

        EObject lv_tCompound_1_0 = null;

        EObject lv_tMapping_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:459:28: ( ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) )
            // InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            {
            // InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
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
                    // InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    {
                    // InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    // InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    {
                    // InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    // InternalIvml.g:462:3: lv_tEnum_0_0= ruleTypedefEnum
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTEnumTypedefEnumParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.TypedefEnum");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    {
                    // InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    // InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    {
                    // InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    // InternalIvml.g:481:3: lv_tCompound_1_0= ruleTypedefCompound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTCompoundTypedefCompoundParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.TypedefCompound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    {
                    // InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    // InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    {
                    // InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    // InternalIvml.g:500:3: lv_tMapping_2_0= ruleTypedefMapping
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTMappingTypedefMappingParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.TypedefMapping");
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
    // InternalIvml.g:524:1: entryRuleTypedefEnum returns [EObject current=null] : iv_ruleTypedefEnum= ruleTypedefEnum EOF ;
    public final EObject entryRuleTypedefEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnum = null;


        try {
            // InternalIvml.g:525:2: (iv_ruleTypedefEnum= ruleTypedefEnum EOF )
            // InternalIvml.g:526:2: iv_ruleTypedefEnum= ruleTypedefEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefEnum=ruleTypedefEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnum; 
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
    // $ANTLR end "entryRuleTypedefEnum"


    // $ANTLR start "ruleTypedefEnum"
    // InternalIvml.g:533:1: ruleTypedefEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) ;
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
            // InternalIvml.g:536:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) )
            // InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            {
            // InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            // InternalIvml.g:537:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefEnumAccess().getEnumKeyword_0());
                  
            }
            // InternalIvml.g:541:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:543:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypedefEnumAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:563:1: ( (lv_literals_3_0= ruleTypedefEnumLiteral ) )
            // InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            {
            // InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            // InternalIvml.g:565:3: lv_literals_3_0= ruleTypedefEnumLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
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
                      		"de.uni_hildesheim.sse.Ivml.TypedefEnumLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:581:2: (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIvml.g:581:4: otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getTypedefEnumAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // InternalIvml.g:585:1: ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    // InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    {
            	    // InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    // InternalIvml.g:587:3: lv_literals_5_0= ruleTypedefEnumLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
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
            	              		"de.uni_hildesheim.sse.Ivml.TypedefEnumLiteral");
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

            otherlv_6=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTypedefEnumAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // InternalIvml.g:607:1: ( (lv_constraint_7_0= ruleTypedefConstraint ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    // InternalIvml.g:609:3: lv_constraint_7_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getConstraintTypedefConstraintParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"de.uni_hildesheim.sse.Ivml.TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:637:1: entryRuleTypedefEnumLiteral returns [EObject current=null] : iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF ;
    public final EObject entryRuleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnumLiteral = null;


        try {
            // InternalIvml.g:638:2: (iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF )
            // InternalIvml.g:639:2: iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefEnumLiteral=ruleTypedefEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnumLiteral; 
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
    // $ANTLR end "entryRuleTypedefEnumLiteral"


    // $ANTLR start "ruleTypedefEnumLiteral"
    // InternalIvml.g:646:1: ruleTypedefEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) ;
    public final EObject ruleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:649:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) )
            // InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            {
            // InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            // InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            {
            // InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:652:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:668:2: (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalIvml.g:668:4: otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedefEnumLiteralAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:672:1: ( (lv_value_2_0= ruleNumValue ) )
                    // InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    {
                    // InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    // InternalIvml.g:674:3: lv_value_2_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getValueNumValueParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.NumValue");
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
    // InternalIvml.g:698:1: entryRuleTypedefCompound returns [EObject current=null] : iv_ruleTypedefCompound= ruleTypedefCompound EOF ;
    public final EObject entryRuleTypedefCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefCompound = null;


        try {
            // InternalIvml.g:699:2: (iv_ruleTypedefCompound= ruleTypedefCompound EOF )
            // InternalIvml.g:700:2: iv_ruleTypedefCompound= ruleTypedefCompound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefCompoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefCompound=ruleTypedefCompound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefCompound; 
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
    // $ANTLR end "entryRuleTypedefCompound"


    // $ANTLR start "ruleTypedefCompound"
    // InternalIvml.g:707:1: ruleTypedefCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )* otherlv_10= '}' (otherlv_11= ';' )? ) ;
    public final EObject ruleTypedefCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_elements_8_0 = null;

        EObject lv_elements_9_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:710:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )* otherlv_10= '}' (otherlv_11= ';' )? ) )
            // InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )* otherlv_10= '}' (otherlv_11= ';' )? )
            {
            // InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )* otherlv_10= '}' (otherlv_11= ';' )? )
            // InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )* otherlv_10= '}' (otherlv_11= ';' )?
            {
            // InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    // InternalIvml.g:713:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,20,FOLLOW_17); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefCompoundAccess().getCompoundKeyword_1());
                  
            }
            // InternalIvml.g:730:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:732:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_18);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:748:2: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalIvml.g:748:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedefCompoundAccess().getRefinesKeyword_3_0());
                          
                    }
                    // InternalIvml.g:752:1: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    // InternalIvml.g:754:3: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTypedefCompoundAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:774:1: ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )*
            loop14:
            do {
                int alt14=5;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalIvml.g:774:2: ( (lv_elements_6_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:774:2: ( (lv_elements_6_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:775:1: (lv_elements_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:775:1: (lv_elements_6_0= ruleVariableDeclaration )
            	    // InternalIvml.g:776:3: lv_elements_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:793:6: ( (lv_elements_7_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:793:6: ( (lv_elements_7_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:794:1: (lv_elements_7_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:794:1: (lv_elements_7_0= ruleExpressionStatement )
            	    // InternalIvml.g:795:3: lv_elements_7_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:812:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:812:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:813:1: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:813:1: (lv_elements_8_0= ruleAttrAssignment )
            	    // InternalIvml.g:814:3: lv_elements_8_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsAttrAssignmentParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalIvml.g:831:6: ( (lv_elements_9_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:831:6: ( (lv_elements_9_0= ruleEval ) )
            	    // InternalIvml.g:832:1: (lv_elements_9_0= ruleEval )
            	    {
            	    // InternalIvml.g:832:1: (lv_elements_9_0= ruleEval )
            	    // InternalIvml.g:833:3: lv_elements_9_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsEvalParserRuleCall_5_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_elements_9_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_9_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
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

            otherlv_10=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getTypedefCompoundAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // InternalIvml.g:853:1: (otherlv_11= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==16) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalIvml.g:853:3: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_7());
                          
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
    // InternalIvml.g:865:1: entryRuleAttrAssignment returns [EObject current=null] : iv_ruleAttrAssignment= ruleAttrAssignment EOF ;
    public final EObject entryRuleAttrAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignment = null;


        try {
            // InternalIvml.g:866:2: (iv_ruleAttrAssignment= ruleAttrAssignment EOF )
            // InternalIvml.g:867:2: iv_ruleAttrAssignment= ruleAttrAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttrAssignment=ruleAttrAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignment; 
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
    // $ANTLR end "entryRuleAttrAssignment"


    // $ANTLR start "ruleAttrAssignment"
    // InternalIvml.g:874:1: ruleAttrAssignment returns [EObject current=null] : (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) ;
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
            // InternalIvml.g:877:28: ( (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) )
            // InternalIvml.g:878:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // InternalIvml.g:878:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            // InternalIvml.g:878:3: otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAssignmentAccess().getAssignKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:886:1: ( (lv_parts_2_0= ruleAttrAssignmentPart ) )
            // InternalIvml.g:887:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            {
            // InternalIvml.g:887:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            // InternalIvml.g:888:3: lv_parts_2_0= ruleAttrAssignmentPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
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
                      		"de.uni_hildesheim.sse.Ivml.AttrAssignmentPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:904:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==18) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalIvml.g:904:4: otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getAttrAssignmentAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalIvml.g:908:1: ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    // InternalIvml.g:909:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    {
            	    // InternalIvml.g:909:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    // InternalIvml.g:910:3: lv_parts_4_0= ruleAttrAssignmentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_21);
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
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignmentPart");
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

            otherlv_5=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAttrAssignmentAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAttrAssignmentAccess().getToKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,14,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAttrAssignmentAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // InternalIvml.g:938:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // InternalIvml.g:938:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:938:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:939:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:939:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    // InternalIvml.g:940:3: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:957:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:957:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:958:1: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:958:1: (lv_elements_9_0= ruleExpressionStatement )
            	    // InternalIvml.g:959:3: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:976:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:976:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:977:1: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:977:1: (lv_elements_10_0= ruleAttrAssignment )
            	    // InternalIvml.g:978:3: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsAttrAssignmentParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
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
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
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

            otherlv_11=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAttrAssignmentAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // InternalIvml.g:998:1: (otherlv_12= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==16) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalIvml.g:998:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1010:1: entryRuleAttrAssignmentPart returns [EObject current=null] : iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF ;
    public final EObject entryRuleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignmentPart = null;


        try {
            // InternalIvml.g:1011:2: (iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF )
            // InternalIvml.g:1012:2: iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttrAssignmentPart=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignmentPart; 
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
    // $ANTLR end "entryRuleAttrAssignmentPart"


    // $ANTLR start "ruleAttrAssignmentPart"
    // InternalIvml.g:1019:1: ruleAttrAssignmentPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) ;
    public final EObject ruleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1022:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) )
            // InternalIvml.g:1023:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            {
            // InternalIvml.g:1023:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            // InternalIvml.g:1023:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) )
            {
            // InternalIvml.g:1023:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1024:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1024:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1025:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentPartAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalIvml.g:1045:1: ( (lv_value_2_0= ruleLogicalExpression ) )
            // InternalIvml.g:1046:1: (lv_value_2_0= ruleLogicalExpression )
            {
            // InternalIvml.g:1046:1: (lv_value_2_0= ruleLogicalExpression )
            // InternalIvml.g:1047:3: lv_value_2_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getValueLogicalExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
                      		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
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
    // InternalIvml.g:1071:1: entryRuleTypedefMapping returns [EObject current=null] : iv_ruleTypedefMapping= ruleTypedefMapping EOF ;
    public final EObject entryRuleTypedefMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefMapping = null;


        try {
            // InternalIvml.g:1072:2: (iv_ruleTypedefMapping= ruleTypedefMapping EOF )
            // InternalIvml.g:1073:2: iv_ruleTypedefMapping= ruleTypedefMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefMapping=ruleTypedefMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefMapping; 
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
    // $ANTLR end "entryRuleTypedefMapping"


    // $ANTLR start "ruleTypedefMapping"
    // InternalIvml.g:1080:1: ruleTypedefMapping returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) ;
    public final EObject ruleTypedefMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newType_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_constraint_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1083:28: ( (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) )
            // InternalIvml.g:1084:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:1084:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            // InternalIvml.g:1084:3: otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefMappingAccess().getTypedefKeyword_0());
                  
            }
            // InternalIvml.g:1088:1: ( (lv_newType_1_0= ruleIdentifier ) )
            // InternalIvml.g:1089:1: (lv_newType_1_0= ruleIdentifier )
            {
            // InternalIvml.g:1089:1: (lv_newType_1_0= ruleIdentifier )
            // InternalIvml.g:1090:3: lv_newType_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getNewTypeIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1106:2: ( (lv_type_2_0= ruleType ) )
            // InternalIvml.g:1107:1: (lv_type_2_0= ruleType )
            {
            // InternalIvml.g:1107:1: (lv_type_2_0= ruleType )
            // InternalIvml.g:1108:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1124:2: ( (lv_constraint_3_0= ruleTypedefConstraint ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalIvml.g:1125:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:1125:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    // InternalIvml.g:1126:3: lv_constraint_3_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getConstraintTypedefConstraintParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"de.uni_hildesheim.sse.Ivml.TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1154:1: entryRuleTypedefConstraint returns [EObject current=null] : iv_ruleTypedefConstraint= ruleTypedefConstraint EOF ;
    public final EObject entryRuleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefConstraint = null;


        try {
            // InternalIvml.g:1155:2: (iv_ruleTypedefConstraint= ruleTypedefConstraint EOF )
            // InternalIvml.g:1156:2: iv_ruleTypedefConstraint= ruleTypedefConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefConstraint=ruleTypedefConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefConstraint; 
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
    // $ANTLR end "entryRuleTypedefConstraint"


    // $ANTLR start "ruleTypedefConstraint"
    // InternalIvml.g:1163:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1166:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalIvml.g:1167:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalIvml.g:1167:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalIvml.g:1167:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefConstraintAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefConstraintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:1175:1: ( (lv_expressions_2_0= ruleExpression ) )
            // InternalIvml.g:1176:1: (lv_expressions_2_0= ruleExpression )
            {
            // InternalIvml.g:1176:1: (lv_expressions_2_0= ruleExpression )
            // InternalIvml.g:1177:3: lv_expressions_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1205:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalIvml.g:1206:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalIvml.g:1207:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalIvml.g:1214:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1217:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' ) )
            // InternalIvml.g:1218:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            {
            // InternalIvml.g:1218:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';' )
            // InternalIvml.g:1218:2: ( (lv_type_0_0= ruleType ) ) ( (lv_decls_1_0= ruleVariableDeclarationPart ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )* otherlv_4= ';'
            {
            // InternalIvml.g:1218:2: ( (lv_type_0_0= ruleType ) )
            // InternalIvml.g:1219:1: (lv_type_0_0= ruleType )
            {
            // InternalIvml.g:1219:1: (lv_type_0_0= ruleType )
            // InternalIvml.g:1220:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1236:2: ( (lv_decls_1_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:1237:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:1237:1: (lv_decls_1_0= ruleVariableDeclarationPart )
            // InternalIvml.g:1238:3: lv_decls_1_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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
                      		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1254:2: (otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==18) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalIvml.g:1254:4: otherlv_2= ',' ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:1258:1: ( (lv_decls_3_0= ruleVariableDeclarationPart ) )
            	    // InternalIvml.g:1259:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    {
            	    // InternalIvml.g:1259:1: (lv_decls_3_0= ruleVariableDeclarationPart )
            	    // InternalIvml.g:1260:3: lv_decls_3_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
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

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1288:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // InternalIvml.g:1289:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // InternalIvml.g:1290:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclarationPart=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclarationPart; 
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
    // $ANTLR end "entryRuleVariableDeclarationPart"


    // $ANTLR start "ruleVariableDeclarationPart"
    // InternalIvml.g:1297:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1300:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:1301:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:1301:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // InternalIvml.g:1301:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:1301:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1302:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1302:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1303:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1319:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIvml.g:1319:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:1323:1: ( (lv_default_2_0= ruleExpression ) )
                    // InternalIvml.g:1324:1: (lv_default_2_0= ruleExpression )
                    {
                    // InternalIvml.g:1324:1: (lv_default_2_0= ruleExpression )
                    // InternalIvml.g:1325:3: lv_default_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getDefaultExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
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
    // InternalIvml.g:1349:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalIvml.g:1350:2: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalIvml.g:1351:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
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
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalIvml.g:1358:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1361:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) )
            // InternalIvml.g:1362:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            {
            // InternalIvml.g:1362:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
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
                    // InternalIvml.g:1362:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // InternalIvml.g:1362:2: ( (lv_type_0_0= 'Integer' ) )
                    // InternalIvml.g:1363:1: (lv_type_0_0= 'Integer' )
                    {
                    // InternalIvml.g:1363:1: (lv_type_0_0= 'Integer' )
                    // InternalIvml.g:1364:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1378:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // InternalIvml.g:1378:6: ( (lv_type_1_0= 'Real' ) )
                    // InternalIvml.g:1379:1: (lv_type_1_0= 'Real' )
                    {
                    // InternalIvml.g:1379:1: (lv_type_1_0= 'Real' )
                    // InternalIvml.g:1380:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1394:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // InternalIvml.g:1394:6: ( (lv_type_2_0= 'Boolean' ) )
                    // InternalIvml.g:1395:1: (lv_type_2_0= 'Boolean' )
                    {
                    // InternalIvml.g:1395:1: (lv_type_2_0= 'Boolean' )
                    // InternalIvml.g:1396:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1410:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // InternalIvml.g:1410:6: ( (lv_type_3_0= 'String' ) )
                    // InternalIvml.g:1411:1: (lv_type_3_0= 'String' )
                    {
                    // InternalIvml.g:1411:1: (lv_type_3_0= 'String' )
                    // InternalIvml.g:1412:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1426:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // InternalIvml.g:1426:6: ( (lv_type_4_0= 'Constraint' ) )
                    // InternalIvml.g:1427:1: (lv_type_4_0= 'Constraint' )
                    {
                    // InternalIvml.g:1427:1: (lv_type_4_0= 'Constraint' )
                    // InternalIvml.g:1428:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1449:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalIvml.g:1450:2: (iv_ruleType= ruleType EOF )
            // InternalIvml.g:1451:2: iv_ruleType= ruleType EOF
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
    // InternalIvml.g:1458:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1461:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // InternalIvml.g:1462:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // InternalIvml.g:1462:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
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
                    // InternalIvml.g:1462:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // InternalIvml.g:1462:2: ( (lv_type_0_0= ruleBasicType ) )
                    // InternalIvml.g:1463:1: (lv_type_0_0= ruleBasicType )
                    {
                    // InternalIvml.g:1463:1: (lv_type_0_0= ruleBasicType )
                    // InternalIvml.g:1464:3: lv_type_0_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeBasicTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.BasicType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1481:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1481:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:1482:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1482:1: (lv_id_1_0= ruleQualifiedName )
                    // InternalIvml.g:1483:3: lv_id_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getIdQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:1500:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // InternalIvml.g:1500:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // InternalIvml.g:1501:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // InternalIvml.g:1501:1: (lv_derived_2_0= ruleDerivedType )
                    // InternalIvml.g:1502:3: lv_derived_2_0= ruleDerivedType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getDerivedDerivedTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.DerivedType");
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
    // InternalIvml.g:1526:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalIvml.g:1527:2: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalIvml.g:1528:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalIvml.g:1535:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1538:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalIvml.g:1539:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalIvml.g:1539:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalIvml.g:1540:1: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalIvml.g:1540:1: (lv_val_0_0= RULE_NUMBER )
            // InternalIvml.g:1541:3: lv_val_0_0= RULE_NUMBER
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
                      		"de.uni_hildesheim.sse.Ivml.NUMBER");
              	    
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
    // InternalIvml.g:1565:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalIvml.g:1566:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalIvml.g:1567:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalIvml.g:1574:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1577:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // InternalIvml.g:1578:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // InternalIvml.g:1578:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // InternalIvml.g:1578:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // InternalIvml.g:1578:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
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
                    // InternalIvml.g:1578:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // InternalIvml.g:1578:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // InternalIvml.g:1579:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:1579:1: (lv_qName_0_0= ruleIdentifier )
                    // InternalIvml.g:1580:3: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_30);
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
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:1596:2: ( (lv_qName_1_0= '::' ) )
                    // InternalIvml.g:1597:1: (lv_qName_1_0= '::' )
                    {
                    // InternalIvml.g:1597:1: (lv_qName_1_0= '::' )
                    // InternalIvml.g:1598:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
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

                    // InternalIvml.g:1611:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
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
                    	    // InternalIvml.g:1611:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // InternalIvml.g:1611:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // InternalIvml.g:1612:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:1612:1: (lv_qName_2_0= ruleIdentifier )
                    	    // InternalIvml.g:1613:3: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_30);
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
                    	              		"de.uni_hildesheim.sse.Ivml.Identifier");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // InternalIvml.g:1629:2: ( (lv_qName_3_0= '::' ) )
                    	    // InternalIvml.g:1630:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // InternalIvml.g:1630:1: (lv_qName_3_0= '::' )
                    	    // InternalIvml.g:1631:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
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

            // InternalIvml.g:1644:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // InternalIvml.g:1645:1: (lv_qName_4_0= ruleIdentifier )
            {
            // InternalIvml.g:1645:1: (lv_qName_4_0= ruleIdentifier )
            // InternalIvml.g:1646:3: lv_qName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
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
    // InternalIvml.g:1670:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // InternalIvml.g:1671:2: (iv_ruleAccessName= ruleAccessName EOF )
            // InternalIvml.g:1672:2: iv_ruleAccessName= ruleAccessName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccessName=ruleAccessName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessName; 
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
    // $ANTLR end "entryRuleAccessName"


    // $ANTLR start "ruleAccessName"
    // InternalIvml.g:1679:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1682:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // InternalIvml.g:1683:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // InternalIvml.g:1683:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
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
            	    // InternalIvml.g:1683:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // InternalIvml.g:1683:2: ( (lv_aName_0_0= '.' ) )
            	    // InternalIvml.g:1684:1: (lv_aName_0_0= '.' )
            	    {
            	    // InternalIvml.g:1684:1: (lv_aName_0_0= '.' )
            	    // InternalIvml.g:1685:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
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

            	    // InternalIvml.g:1698:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // InternalIvml.g:1699:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:1699:1: (lv_aName_1_0= ruleIdentifier )
            	    // InternalIvml.g:1700:3: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_31);
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
            	              		"de.uni_hildesheim.sse.Ivml.Identifier");
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
    // InternalIvml.g:1724:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalIvml.g:1725:2: (iv_ruleValue= ruleValue EOF )
            // InternalIvml.g:1726:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalIvml.g:1733:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) ;
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
            // InternalIvml.g:1736:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) )
            // InternalIvml.g:1737:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            {
            // InternalIvml.g:1737:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
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

                if ( (synpred46_InternalIvml()) ) {
                    alt28=3;
                }
                else if ( (synpred51_InternalIvml()) ) {
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
                    // InternalIvml.g:1737:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalIvml.g:1737:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalIvml.g:1738:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalIvml.g:1738:1: (lv_nValue_0_0= ruleNumValue )
                    // InternalIvml.g:1739:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.NumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1756:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalIvml.g:1756:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalIvml.g:1757:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalIvml.g:1757:1: (lv_sValue_1_0= RULE_STRING )
                    // InternalIvml.g:1758:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
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
                              		"de.uni_hildesheim.sse.Ivml.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:1775:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1775:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalIvml.g:1776:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1776:1: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalIvml.g:1777:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:1794:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalIvml.g:1794:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalIvml.g:1795:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalIvml.g:1795:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalIvml.g:1796:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalIvml.g:1796:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
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
                            // InternalIvml.g:1797:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
                            // InternalIvml.g:1809:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1825:6: ( (lv_self_4_0= 'self' ) )
                    {
                    // InternalIvml.g:1825:6: ( (lv_self_4_0= 'self' ) )
                    // InternalIvml.g:1826:1: (lv_self_4_0= 'self' )
                    {
                    // InternalIvml.g:1826:1: (lv_self_4_0= 'self' )
                    // InternalIvml.g:1827:3: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1841:6: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // InternalIvml.g:1841:6: ( (lv_nullValue_5_0= 'null' ) )
                    // InternalIvml.g:1842:1: (lv_nullValue_5_0= 'null' )
                    {
                    // InternalIvml.g:1842:1: (lv_nullValue_5_0= 'null' )
                    // InternalIvml.g:1843:3: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1857:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    {
                    // InternalIvml.g:1857:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    // InternalIvml.g:1857:7: ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION )
                    {
                    // InternalIvml.g:1863:1: (lv_version_6_0= RULE_VERSION )
                    // InternalIvml.g:1864:3: lv_version_6_0= RULE_VERSION
                    {
                    lv_version_6_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
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
                              		"de.uni_hildesheim.sse.Ivml.VERSION");
                      	    
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
    // InternalIvml.g:1888:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // InternalIvml.g:1889:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // InternalIvml.g:1890:2: iv_ruleDerivedType= ruleDerivedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerivedTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDerivedType=ruleDerivedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDerivedType; 
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
    // $ANTLR end "entryRuleDerivedType"


    // $ANTLR start "ruleDerivedType"
    // InternalIvml.g:1897:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
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
            // InternalIvml.g:1900:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // InternalIvml.g:1901:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // InternalIvml.g:1901:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // InternalIvml.g:1901:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // InternalIvml.g:1901:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
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
                    // InternalIvml.g:1901:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // InternalIvml.g:1901:3: ( (lv_op_0_0= 'setOf' ) )
                    // InternalIvml.g:1902:1: (lv_op_0_0= 'setOf' )
                    {
                    // InternalIvml.g:1902:1: (lv_op_0_0= 'setOf' )
                    // InternalIvml.g:1903:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,40,FOLLOW_20); if (state.failed) return current;
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
                    // InternalIvml.g:1917:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // InternalIvml.g:1917:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // InternalIvml.g:1918:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // InternalIvml.g:1918:1: (lv_op_1_0= 'sequenceOf' )
                    // InternalIvml.g:1919:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,41,FOLLOW_20); if (state.failed) return current;
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
                    // InternalIvml.g:1933:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // InternalIvml.g:1933:6: ( (lv_op_2_0= 'refTo' ) )
                    // InternalIvml.g:1934:1: (lv_op_2_0= 'refTo' )
                    {
                    // InternalIvml.g:1934:1: (lv_op_2_0= 'refTo' )
                    // InternalIvml.g:1935:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,42,FOLLOW_20); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:1952:1: ( (lv_type_4_0= ruleType ) )
            // InternalIvml.g:1953:1: (lv_type_4_0= ruleType )
            {
            // InternalIvml.g:1953:1: (lv_type_4_0= ruleType )
            // InternalIvml.g:1954:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1982:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // InternalIvml.g:1983:2: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // InternalIvml.g:1984:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotateToRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotateTo=ruleAnnotateTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotateTo; 
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
    // $ANTLR end "entryRuleAnnotateTo"


    // $ANTLR start "ruleAnnotateTo"
    // InternalIvml.g:1991:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) ;
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
            // InternalIvml.g:1994:28: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) )
            // InternalIvml.g:1995:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            {
            // InternalIvml.g:1995:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            // InternalIvml.g:1995:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';'
            {
            // InternalIvml.g:1995:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // InternalIvml.g:1996:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // InternalIvml.g:1996:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // InternalIvml.g:1997:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // InternalIvml.g:1997:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
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
                    // InternalIvml.g:1998:3: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,43,FOLLOW_26); if (state.failed) return current;
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
                    // InternalIvml.g:2010:8: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,44,FOLLOW_26); if (state.failed) return current;
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

            // InternalIvml.g:2025:2: ( (lv_annotationType_1_0= ruleType ) )
            // InternalIvml.g:2026:1: (lv_annotationType_1_0= ruleType )
            {
            // InternalIvml.g:2026:1: (lv_annotationType_1_0= ruleType )
            // InternalIvml.g:2027:3: lv_annotationType_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2043:2: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:2044:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:2044:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:2045:3: lv_annotationDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationDeclVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
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
                      		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAnnotateToAccess().getToKeyword_3());
                  
            }
            // InternalIvml.g:2065:1: ( (lv_names_4_0= ruleIdentifier ) )
            // InternalIvml.g:2066:1: (lv_names_4_0= ruleIdentifier )
            {
            // InternalIvml.g:2066:1: (lv_names_4_0= ruleIdentifier )
            // InternalIvml.g:2067:3: lv_names_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2083:2: (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalIvml.g:2083:4: otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAnnotateToAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // InternalIvml.g:2087:1: ( (lv_names_6_0= ruleIdentifier ) )
            	    // InternalIvml.g:2088:1: (lv_names_6_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:2088:1: (lv_names_6_0= ruleIdentifier )
            	    // InternalIvml.g:2089:3: lv_names_6_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	              		"de.uni_hildesheim.sse.Ivml.Identifier");
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

            otherlv_7=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2117:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // InternalIvml.g:2118:2: (iv_ruleFreeze= ruleFreeze EOF )
            // InternalIvml.g:2119:2: iv_ruleFreeze= ruleFreeze EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFreeze=ruleFreeze();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreeze; 
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
    // $ANTLR end "entryRuleFreeze"


    // $ANTLR start "ruleFreeze"
    // InternalIvml.g:2126:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
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
            // InternalIvml.g:2129:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // InternalIvml.g:2130:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // InternalIvml.g:2130:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // InternalIvml.g:2130:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalIvml.g:2138:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
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
            	    // InternalIvml.g:2139:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // InternalIvml.g:2139:1: (lv_names_2_0= ruleFreezeStatement )
            	    // InternalIvml.g:2140:3: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
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
            	              		"de.uni_hildesheim.sse.Ivml.FreezeStatement");
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

            otherlv_3=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // InternalIvml.g:2160:1: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalIvml.g:2160:3: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // InternalIvml.g:2168:1: ( (lv_id_6_0= ruleIdentifier ) )
                    // InternalIvml.g:2169:1: (lv_id_6_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2169:1: (lv_id_6_0= ruleIdentifier )
                    // InternalIvml.g:2170:3: lv_id_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getIdIdentifierParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_34);
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
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,47,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                          
                    }
                    // InternalIvml.g:2190:1: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // InternalIvml.g:2191:1: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:2191:1: (lv_ex_8_0= ruleLogicalExpression )
                    // InternalIvml.g:2192:3: lv_ex_8_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getExLogicalExpressionParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                              		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,25,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFreezeAccess().getRightParenthesisKeyword_4_5());
                          
                    }

                    }
                    break;

            }

            // InternalIvml.g:2212:3: (otherlv_10= ';' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalIvml.g:2212:5: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2224:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // InternalIvml.g:2225:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // InternalIvml.g:2226:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFreezeStatement=ruleFreezeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeStatement; 
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
    // $ANTLR end "entryRuleFreezeStatement"


    // $ANTLR start "ruleFreezeStatement"
    // InternalIvml.g:2233:1: ruleFreezeStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2236:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) )
            // InternalIvml.g:2237:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            {
            // InternalIvml.g:2237:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            // InternalIvml.g:2237:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';'
            {
            // InternalIvml.g:2237:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalIvml.g:2238:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalIvml.g:2238:1: (lv_name_0_0= ruleQualifiedName )
            // InternalIvml.g:2239:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_35);
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
                      		"de.uni_hildesheim.sse.Ivml.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2255:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalIvml.g:2256:1: (lv_access_1_0= ruleAccessName )
                    {
                    // InternalIvml.g:2256:1: (lv_access_1_0= ruleAccessName )
                    // InternalIvml.g:2257:3: lv_access_1_0= ruleAccessName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"de.uni_hildesheim.sse.Ivml.AccessName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2285:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // InternalIvml.g:2286:2: (iv_ruleEval= ruleEval EOF )
            // InternalIvml.g:2287:2: iv_ruleEval= ruleEval EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEval=ruleEval();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEval; 
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
    // $ANTLR end "entryRuleEval"


    // $ANTLR start "ruleEval"
    // InternalIvml.g:2294:1: ruleEval returns [EObject current=null] : (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // InternalIvml.g:2297:28: ( (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? ) )
            // InternalIvml.g:2298:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // InternalIvml.g:2298:1: (otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )? )
            // InternalIvml.g:2298:3: otherlv_0= 'eval' otherlv_1= '{' ( (lv_nested_2_0= ruleEval ) )* ( (lv_statements_3_0= ruleExpressionStatement ) )+ otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEvalAccess().getEvalKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalIvml.g:2306:1: ( (lv_nested_2_0= ruleEval ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==48) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalIvml.g:2307:1: (lv_nested_2_0= ruleEval )
            	    {
            	    // InternalIvml.g:2307:1: (lv_nested_2_0= ruleEval )
            	    // InternalIvml.g:2308:3: lv_nested_2_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
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
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalIvml.g:2324:3: ( (lv_statements_3_0= ruleExpressionStatement ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_NUMBER && LA37_0<=RULE_EXPONENT)||LA37_0==14||LA37_0==24||(LA37_0>=36 && LA37_0<=39)||LA37_0==53||LA37_0==56||LA37_0==71||LA37_0==74||(LA37_0>=78 && LA37_0<=79)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalIvml.g:2325:1: (lv_statements_3_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:2325:1: (lv_statements_3_0= ruleExpressionStatement )
            	    // InternalIvml.g:2326:3: lv_statements_3_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
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
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
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

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:2346:1: (otherlv_5= ';' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalIvml.g:2346:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2358:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // InternalIvml.g:2359:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // InternalIvml.g:2360:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
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
    // $ANTLR end "entryRuleInterfaceDeclaration"


    // $ANTLR start "ruleInterfaceDeclaration"
    // InternalIvml.g:2367:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // InternalIvml.g:2370:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // InternalIvml.g:2371:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // InternalIvml.g:2371:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // InternalIvml.g:2371:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // InternalIvml.g:2375:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2376:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2376:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2377:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:2397:1: ( (lv_exports_3_0= ruleExport ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==50) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalIvml.g:2398:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // InternalIvml.g:2398:1: (lv_exports_3_0= ruleExport )
            	    // InternalIvml.g:2399:3: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
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
            	              		"de.uni_hildesheim.sse.Ivml.Export");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:2419:1: (otherlv_5= ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalIvml.g:2419:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2431:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // InternalIvml.g:2432:2: (iv_ruleExport= ruleExport EOF )
            // InternalIvml.g:2433:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
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
    // $ANTLR end "entryRuleExport"


    // $ANTLR start "ruleExport"
    // InternalIvml.g:2440:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2443:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // InternalIvml.g:2444:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // InternalIvml.g:2444:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // InternalIvml.g:2444:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // InternalIvml.g:2448:1: ( (lv_names_1_0= ruleQualifiedName ) )
            // InternalIvml.g:2449:1: (lv_names_1_0= ruleQualifiedName )
            {
            // InternalIvml.g:2449:1: (lv_names_1_0= ruleQualifiedName )
            // InternalIvml.g:2450:3: lv_names_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
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
                      		"de.uni_hildesheim.sse.Ivml.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2466:2: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==18) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalIvml.g:2466:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:2470:1: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // InternalIvml.g:2471:1: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // InternalIvml.g:2471:1: (lv_names_3_0= ruleQualifiedName )
            	    // InternalIvml.g:2472:3: lv_names_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
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

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2500:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // InternalIvml.g:2501:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // InternalIvml.g:2502:2: iv_ruleImportStmt= ruleImportStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportStmt=ruleImportStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStmt; 
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
    // $ANTLR end "entryRuleImportStmt"


    // $ANTLR start "ruleImportStmt"
    // InternalIvml.g:2509:1: ruleImportStmt returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) ;
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
            // InternalIvml.g:2512:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) )
            // InternalIvml.g:2513:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            {
            // InternalIvml.g:2513:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            // InternalIvml.g:2513:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0());
                  
            }
            // InternalIvml.g:2517:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2518:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2518:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2519:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2535:2: (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalIvml.g:2535:4: otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2539:1: ( (lv_interface_3_0= ruleIdentifier ) )
                    // InternalIvml.g:2540:1: (lv_interface_3_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2540:1: (lv_interface_3_0= ruleIdentifier )
                    // InternalIvml.g:2541:3: lv_interface_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
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
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalIvml.g:2557:4: (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==28) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalIvml.g:2557:6: otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImportStmtAccess().getWithKeyword_3_0());
                          
                    }
                    // InternalIvml.g:2561:1: ( (lv_restriction_5_0= ruleExpression ) )
                    // InternalIvml.g:2562:1: (lv_restriction_5_0= ruleExpression )
                    {
                    // InternalIvml.g:2562:1: (lv_restriction_5_0= ruleExpression )
                    // InternalIvml.g:2563:3: lv_restriction_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getRestrictionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2591:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // InternalIvml.g:2592:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // InternalIvml.g:2593:2: iv_ruleConflictStmt= ruleConflictStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConflictStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConflictStmt=ruleConflictStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConflictStmt; 
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
    // $ANTLR end "entryRuleConflictStmt"


    // $ANTLR start "ruleConflictStmt"
    // InternalIvml.g:2600:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2603:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // InternalIvml.g:2604:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:2604:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // InternalIvml.g:2604:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // InternalIvml.g:2608:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2609:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2609:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2610:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConflictStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2626:2: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalIvml.g:2626:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2630:1: ( (lv_restriction_3_0= ruleExpression ) )
                    // InternalIvml.g:2631:1: (lv_restriction_3_0= ruleExpression )
                    {
                    // InternalIvml.g:2631:1: (lv_restriction_3_0= ruleExpression )
                    // InternalIvml.g:2632:3: lv_restriction_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getRestrictionExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2660:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalIvml.g:2661:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalIvml.g:2662:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalIvml.g:2669:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:2672:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalIvml.g:2673:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalIvml.g:2673:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalIvml.g:2673:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // InternalIvml.g:2677:1: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalIvml.g:2678:1: (lv_version_1_0= RULE_VERSION )
            {
            // InternalIvml.g:2678:1: (lv_version_1_0= RULE_VERSION )
            // InternalIvml.g:2679:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_14); if (state.failed) return current;
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
                      		"de.uni_hildesheim.sse.Ivml.VERSION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:2707:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // InternalIvml.g:2708:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // InternalIvml.g:2709:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefStatement=ruleOpDefStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefStatement; 
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
    // $ANTLR end "entryRuleOpDefStatement"


    // $ANTLR start "ruleOpDefStatement"
    // InternalIvml.g:2716:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
    public final EObject ruleOpDefStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_result_2_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_param_5_0 = null;

        EObject lv_impl_8_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2719:28: ( (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalIvml.g:2720:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalIvml.g:2720:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalIvml.g:2720:3: otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // InternalIvml.g:2724:1: ( (lv_static_1_0= 'static' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==55) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalIvml.g:2725:1: (lv_static_1_0= 'static' )
                    {
                    // InternalIvml.g:2725:1: (lv_static_1_0= 'static' )
                    // InternalIvml.g:2726:3: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,55,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_static_1_0, grammarAccess.getOpDefStatementAccess().getStaticStaticKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOpDefStatementRule());
                      	        }
                             		setWithLastConsumed(current, "static", lv_static_1_0, "static");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:2739:3: ( (lv_result_2_0= ruleType ) )
            // InternalIvml.g:2740:1: (lv_result_2_0= ruleType )
            {
            // InternalIvml.g:2740:1: (lv_result_2_0= ruleType )
            // InternalIvml.g:2741:3: lv_result_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_result_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"result",
                      		lv_result_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2757:2: ( (lv_id_3_0= ruleIdentifier ) )
            // InternalIvml.g:2758:1: (lv_id_3_0= ruleIdentifier )
            {
            // InternalIvml.g:2758:1: (lv_id_3_0= ruleIdentifier )
            // InternalIvml.g:2759:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_20);
            lv_id_3_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_4());
                  
            }
            // InternalIvml.g:2779:1: ( (lv_param_5_0= ruleOpDefParameterList ) )
            // InternalIvml.g:2780:1: (lv_param_5_0= ruleOpDefParameterList )
            {
            // InternalIvml.g:2780:1: (lv_param_5_0= ruleOpDefParameterList )
            // InternalIvml.g:2781:3: lv_param_5_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
            lv_param_5_0=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"param",
                      		lv_param_5_0, 
                      		"de.uni_hildesheim.sse.Ivml.OpDefParameterList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_6());
                  
            }
            otherlv_7=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_7());
                  
            }
            // InternalIvml.g:2805:1: ( (lv_impl_8_0= ruleExpression ) )
            // InternalIvml.g:2806:1: (lv_impl_8_0= ruleExpression )
            {
            // InternalIvml.g:2806:1: (lv_impl_8_0= ruleExpression )
            // InternalIvml.g:2807:3: lv_impl_8_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_14);
            lv_impl_8_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"impl",
                      		lv_impl_8_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getOpDefStatementAccess().getSemicolonKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // InternalIvml.g:2835:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // InternalIvml.g:2836:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // InternalIvml.g:2837:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefParameterList=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameterList; 
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
    // $ANTLR end "entryRuleOpDefParameterList"


    // $ANTLR start "ruleOpDefParameterList"
    // InternalIvml.g:2844:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2847:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // InternalIvml.g:2848:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // InternalIvml.g:2848:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // InternalIvml.g:2848:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // InternalIvml.g:2848:2: ()
            // InternalIvml.g:2849:2: 
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

            // InternalIvml.g:2857:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_VERSION && LA47_0<=RULE_EXPONENT)||(LA47_0>=29 && LA47_0<=33)||(LA47_0>=40 && LA47_0<=42)||LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalIvml.g:2857:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // InternalIvml.g:2857:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // InternalIvml.g:2858:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // InternalIvml.g:2858:1: (lv_list_1_0= ruleOpDefParameter )
                    // InternalIvml.g:2859:3: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
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
                              		"de.uni_hildesheim.sse.Ivml.OpDefParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:2875:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==18) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalIvml.g:2875:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // InternalIvml.g:2879:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // InternalIvml.g:2880:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // InternalIvml.g:2880:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // InternalIvml.g:2881:3: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
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
                    	              		"de.uni_hildesheim.sse.Ivml.OpDefParameter");
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
    // InternalIvml.g:2905:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // InternalIvml.g:2906:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // InternalIvml.g:2907:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefParameter=ruleOpDefParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameter; 
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
    // $ANTLR end "entryRuleOpDefParameter"


    // $ANTLR start "ruleOpDefParameter"
    // InternalIvml.g:2914:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2917:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:2918:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:2918:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // InternalIvml.g:2918:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:2918:2: ( (lv_type_0_0= ruleType ) )
            // InternalIvml.g:2919:1: (lv_type_0_0= ruleType )
            {
            // InternalIvml.g:2919:1: (lv_type_0_0= ruleType )
            // InternalIvml.g:2920:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2936:2: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:2937:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2937:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:2938:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2954:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==19) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalIvml.g:2954:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2958:1: ( (lv_val_3_0= ruleExpression ) )
                    // InternalIvml.g:2959:1: (lv_val_3_0= ruleExpression )
                    {
                    // InternalIvml.g:2959:1: (lv_val_3_0= ruleExpression )
                    // InternalIvml.g:2960:3: lv_val_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getValExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
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
    // InternalIvml.g:2984:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalIvml.g:2985:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalIvml.g:2986:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalIvml.g:2993:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2996:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalIvml.g:2997:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalIvml.g:2997:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalIvml.g:2997:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalIvml.g:2997:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalIvml.g:2998:1: (lv_expr_0_0= ruleExpression )
            {
            // InternalIvml.g:2998:1: (lv_expr_0_0= ruleExpression )
            // InternalIvml.g:2999:3: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_14);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3027:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalIvml.g:3028:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalIvml.g:3029:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalIvml.g:3036:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3039:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3040:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3040:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt49=3;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // InternalIvml.g:3040:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // InternalIvml.g:3040:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // InternalIvml.g:3041:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // InternalIvml.g:3041:1: (lv_let_0_0= ruleLetExpression )
                    // InternalIvml.g:3042:3: lv_let_0_0= ruleLetExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLetLetExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.LetExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3059:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:3059:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // InternalIvml.g:3060:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:3060:1: (lv_expr_1_0= ruleImplicationExpression )
                    // InternalIvml.g:3061:3: lv_expr_1_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprImplicationExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.ImplicationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:3078:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3078:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3079:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3079:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3080:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCollectionCollectionInitializerParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.CollectionInitializer");
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
    // InternalIvml.g:3104:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // InternalIvml.g:3105:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // InternalIvml.g:3106:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpression; 
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
    // $ANTLR end "entryRuleLetExpression"


    // $ANTLR start "ruleLetExpression"
    // InternalIvml.g:3113:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) ;
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
            // InternalIvml.g:3116:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) ) )
            // InternalIvml.g:3117:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            {
            // InternalIvml.g:3117:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) ) )
            // InternalIvml.g:3117:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // InternalIvml.g:3121:1: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:3122:1: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:3122:1: (lv_type_1_0= ruleType )
            // InternalIvml.g:3123:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3139:2: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:3140:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:3140:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:3141:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalIvml.g:3161:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // InternalIvml.g:3162:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // InternalIvml.g:3162:1: (lv_valueExpr_4_0= ruleExpression )
            // InternalIvml.g:3163:3: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_44);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,57,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // InternalIvml.g:3183:1: ( (lv_subExpr_6_0= ruleExpression ) )
            // InternalIvml.g:3184:1: (lv_subExpr_6_0= ruleExpression )
            {
            // InternalIvml.g:3184:1: (lv_subExpr_6_0= ruleExpression )
            // InternalIvml.g:3185:3: lv_subExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
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
    // InternalIvml.g:3209:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalIvml.g:3210:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalIvml.g:3211:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
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
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalIvml.g:3218:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3221:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // InternalIvml.g:3222:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // InternalIvml.g:3222:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // InternalIvml.g:3222:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // InternalIvml.g:3222:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // InternalIvml.g:3223:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // InternalIvml.g:3223:1: (lv_left_0_0= ruleLogicalExpression )
            // InternalIvml.g:3224:3: lv_left_0_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftLogicalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
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
                      		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3240:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==19) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalIvml.g:3241:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // InternalIvml.g:3241:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // InternalIvml.g:3242:3: lv_right_1_0= ruleAssignmentExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightAssignmentExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.AssignmentExpressionPart");
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
    // InternalIvml.g:3266:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // InternalIvml.g:3267:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // InternalIvml.g:3268:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpressionPart=ruleAssignmentExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpressionPart; 
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
    // $ANTLR end "entryRuleAssignmentExpressionPart"


    // $ANTLR start "ruleAssignmentExpressionPart"
    // InternalIvml.g:3275:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3278:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:3279:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:3279:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3279:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3279:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // InternalIvml.g:3280:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // InternalIvml.g:3280:1: (lv_op_0_0= ruleAssignmentOperator )
            // InternalIvml.g:3281:3: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.Ivml.AssignmentOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3297:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalIvml.g:3297:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // InternalIvml.g:3297:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // InternalIvml.g:3298:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:3298:1: (lv_ex_1_0= ruleLogicalExpression )
                    // InternalIvml.g:3299:3: lv_ex_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getExLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3316:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3316:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3317:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3317:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3318:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.CollectionInitializer");
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
    // InternalIvml.g:3342:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // InternalIvml.g:3343:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalIvml.g:3344:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
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
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // InternalIvml.g:3351:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3354:28: (kw= '=' )
            // InternalIvml.g:3356:2: kw= '='
            {
            kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3369:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // InternalIvml.g:3370:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // InternalIvml.g:3371:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationExpression=ruleImplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpression; 
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
    // $ANTLR end "entryRuleImplicationExpression"


    // $ANTLR start "ruleImplicationExpression"
    // InternalIvml.g:3378:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3381:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // InternalIvml.g:3382:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // InternalIvml.g:3382:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // InternalIvml.g:3382:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // InternalIvml.g:3382:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3383:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3383:1: (lv_left_0_0= ruleAssignmentExpression )
            // InternalIvml.g:3384:3: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_45);
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
                      		"de.uni_hildesheim.sse.Ivml.AssignmentExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3400:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=58 && LA52_0<=59)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalIvml.g:3401:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // InternalIvml.g:3401:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // InternalIvml.g:3402:3: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_45);
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
            	              		"de.uni_hildesheim.sse.Ivml.ImplicationExpressionPart");
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
    // InternalIvml.g:3426:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // InternalIvml.g:3427:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // InternalIvml.g:3428:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationExpressionPart=ruleImplicationExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpressionPart; 
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
    // $ANTLR end "entryRuleImplicationExpressionPart"


    // $ANTLR start "ruleImplicationExpressionPart"
    // InternalIvml.g:3435:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3438:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // InternalIvml.g:3439:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // InternalIvml.g:3439:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // InternalIvml.g:3439:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // InternalIvml.g:3439:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // InternalIvml.g:3440:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // InternalIvml.g:3440:1: (lv_op_0_0= ruleImplicationOperator )
            // InternalIvml.g:3441:3: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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
                      		"de.uni_hildesheim.sse.Ivml.ImplicationOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3457:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3458:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3458:1: (lv_ex_1_0= ruleAssignmentExpression )
            // InternalIvml.g:3459:3: lv_ex_1_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
                      		"de.uni_hildesheim.sse.Ivml.AssignmentExpression");
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
    // InternalIvml.g:3483:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // InternalIvml.g:3484:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // InternalIvml.g:3485:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationOperator=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationOperator.getText(); 
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
    // $ANTLR end "entryRuleImplicationOperator"


    // $ANTLR start "ruleImplicationOperator"
    // InternalIvml.g:3492:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3495:28: ( (kw= 'implies' | kw= 'iff' ) )
            // InternalIvml.g:3496:1: (kw= 'implies' | kw= 'iff' )
            {
            // InternalIvml.g:3496:1: (kw= 'implies' | kw= 'iff' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==58) ) {
                alt53=1;
            }
            else if ( (LA53_0==59) ) {
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
                    // InternalIvml.g:3497:2: kw= 'implies'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3504:2: kw= 'iff'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3517:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalIvml.g:3518:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalIvml.g:3519:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalIvml.g:3526:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3529:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalIvml.g:3530:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalIvml.g:3530:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalIvml.g:3530:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalIvml.g:3530:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalIvml.g:3531:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3531:1: (lv_left_0_0= ruleEqualityExpression )
            // InternalIvml.g:3532:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
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
                      		"de.uni_hildesheim.sse.Ivml.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3548:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=60 && LA54_0<=62)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalIvml.g:3549:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalIvml.g:3549:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalIvml.g:3550:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_46);
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
            	              		"de.uni_hildesheim.sse.Ivml.LogicalExpressionPart");
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
    // InternalIvml.g:3574:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalIvml.g:3575:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalIvml.g:3576:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalIvml.g:3583:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3586:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalIvml.g:3587:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalIvml.g:3587:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalIvml.g:3587:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalIvml.g:3587:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalIvml.g:3588:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalIvml.g:3588:1: (lv_op_0_0= ruleLogicalOperator )
            // InternalIvml.g:3589:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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
                      		"de.uni_hildesheim.sse.Ivml.LogicalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3605:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalIvml.g:3606:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3606:1: (lv_ex_1_0= ruleEqualityExpression )
            // InternalIvml.g:3607:3: lv_ex_1_0= ruleEqualityExpression
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
                      		"de.uni_hildesheim.sse.Ivml.EqualityExpression");
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
    // InternalIvml.g:3631:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalIvml.g:3632:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalIvml.g:3633:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalIvml.g:3640:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3643:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // InternalIvml.g:3644:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // InternalIvml.g:3644:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt55=1;
                }
                break;
            case 61:
                {
                alt55=2;
                }
                break;
            case 62:
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
                    // InternalIvml.g:3645:2: kw= 'and'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3652:2: kw= 'or'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3659:2: kw= 'xor'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3672:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalIvml.g:3673:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalIvml.g:3674:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalIvml.g:3681:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3684:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalIvml.g:3685:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalIvml.g:3685:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalIvml.g:3685:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalIvml.g:3685:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalIvml.g:3686:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalIvml.g:3686:1: (lv_left_0_0= ruleRelationalExpression )
            // InternalIvml.g:3687:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
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
                      		"de.uni_hildesheim.sse.Ivml.RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3703:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=63 && LA56_0<=65)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalIvml.g:3704:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalIvml.g:3704:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalIvml.g:3705:3: lv_right_1_0= ruleEqualityExpressionPart
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
                              		"de.uni_hildesheim.sse.Ivml.EqualityExpressionPart");
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
    // InternalIvml.g:3729:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalIvml.g:3730:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalIvml.g:3731:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalIvml.g:3738:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3741:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:3742:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:3742:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3742:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3742:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalIvml.g:3743:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalIvml.g:3743:1: (lv_op_0_0= ruleEqualityOperator )
            // InternalIvml.g:3744:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.Ivml.EqualityOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3760:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // InternalIvml.g:3760:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // InternalIvml.g:3760:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // InternalIvml.g:3761:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // InternalIvml.g:3761:1: (lv_ex_1_0= ruleRelationalExpression )
                    // InternalIvml.g:3762:3: lv_ex_1_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0_0()); 
                      	    
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
                              		"de.uni_hildesheim.sse.Ivml.RelationalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3779:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3779:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3780:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3780:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3781:3: lv_collection_2_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.CollectionInitializer");
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
    // InternalIvml.g:3805:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalIvml.g:3806:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalIvml.g:3807:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalIvml.g:3814:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3817:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalIvml.g:3818:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalIvml.g:3818:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt58=1;
                }
                break;
            case 64:
                {
                alt58=2;
                }
                break;
            case 65:
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
                    // InternalIvml.g:3819:2: kw= '=='
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3826:2: kw= '<>'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3833:2: kw= '!='
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3846:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalIvml.g:3847:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalIvml.g:3848:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalIvml.g:3855:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3858:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // InternalIvml.g:3859:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // InternalIvml.g:3859:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // InternalIvml.g:3859:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // InternalIvml.g:3859:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalIvml.g:3860:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:3860:1: (lv_left_0_0= ruleAdditiveExpression )
            // InternalIvml.g:3861:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_48);
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
                      		"de.uni_hildesheim.sse.Ivml.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3877:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=66 && LA59_0<=69)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalIvml.g:3878:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalIvml.g:3878:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalIvml.g:3879:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.RelationalExpressionPart");
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
    // InternalIvml.g:3903:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalIvml.g:3904:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalIvml.g:3905:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalIvml.g:3912:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3915:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalIvml.g:3916:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalIvml.g:3916:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalIvml.g:3916:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalIvml.g:3916:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalIvml.g:3917:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalIvml.g:3917:1: (lv_op_0_0= ruleRelationalOperator )
            // InternalIvml.g:3918:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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
                      		"de.uni_hildesheim.sse.Ivml.RelationalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3934:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalIvml.g:3935:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:3935:1: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalIvml.g:3936:3: lv_ex_1_0= ruleAdditiveExpression
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
                      		"de.uni_hildesheim.sse.Ivml.AdditiveExpression");
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
    // InternalIvml.g:3960:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalIvml.g:3961:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalIvml.g:3962:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalIvml.g:3969:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3972:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalIvml.g:3973:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalIvml.g:3973:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt60=1;
                }
                break;
            case 67:
                {
                alt60=2;
                }
                break;
            case 68:
                {
                alt60=3;
                }
                break;
            case 69:
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
                    // InternalIvml.g:3974:2: kw= '>'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3981:2: kw= '<'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3988:2: kw= '>='
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalIvml.g:3995:2: kw= '<='
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4008:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalIvml.g:4009:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalIvml.g:4010:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalIvml.g:4017:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4020:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalIvml.g:4021:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalIvml.g:4021:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalIvml.g:4021:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalIvml.g:4021:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4022:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4022:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4023:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_49);
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
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4039:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=70 && LA61_0<=71)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalIvml.g:4040:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalIvml.g:4040:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalIvml.g:4041:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_49);
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
            	              		"de.uni_hildesheim.sse.Ivml.AdditiveExpressionPart");
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
    // InternalIvml.g:4065:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalIvml.g:4066:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalIvml.g:4067:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalIvml.g:4074:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4077:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalIvml.g:4078:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalIvml.g:4078:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalIvml.g:4078:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalIvml.g:4078:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalIvml.g:4079:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalIvml.g:4079:1: (lv_op_0_0= ruleAdditiveOperator )
            // InternalIvml.g:4080:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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
                      		"de.uni_hildesheim.sse.Ivml.AdditiveOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4096:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4097:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4097:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4098:3: lv_ex_1_0= ruleMultiplicativeExpression
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
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpression");
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
    // InternalIvml.g:4122:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalIvml.g:4123:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalIvml.g:4124:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalIvml.g:4131:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4134:28: ( (kw= '+' | kw= '-' ) )
            // InternalIvml.g:4135:1: (kw= '+' | kw= '-' )
            {
            // InternalIvml.g:4135:1: (kw= '+' | kw= '-' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==70) ) {
                alt62=1;
            }
            else if ( (LA62_0==71) ) {
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
                    // InternalIvml.g:4136:2: kw= '+'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4143:2: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4156:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalIvml.g:4157:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalIvml.g:4158:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalIvml.g:4165:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4168:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalIvml.g:4169:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalIvml.g:4169:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalIvml.g:4169:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalIvml.g:4169:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalIvml.g:4170:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4170:1: (lv_left_0_0= ruleUnaryExpression )
            // InternalIvml.g:4171:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
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
                      		"de.uni_hildesheim.sse.Ivml.UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4187:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=72 && LA63_0<=73)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalIvml.g:4188:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalIvml.g:4188:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalIvml.g:4189:3: lv_right_1_0= ruleMultiplicativeExpressionPart
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
                              		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpressionPart");
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
    // InternalIvml.g:4213:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalIvml.g:4214:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalIvml.g:4215:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalIvml.g:4222:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4225:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalIvml.g:4226:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalIvml.g:4226:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalIvml.g:4226:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalIvml.g:4226:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalIvml.g:4227:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalIvml.g:4227:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalIvml.g:4228:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
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
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4244:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalIvml.g:4245:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4245:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalIvml.g:4246:3: lv_expr_1_0= ruleUnaryExpression
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
                      		"de.uni_hildesheim.sse.Ivml.UnaryExpression");
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
    // InternalIvml.g:4270:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalIvml.g:4271:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalIvml.g:4272:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalIvml.g:4279:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4282:28: ( (kw= '*' | kw= '/' ) )
            // InternalIvml.g:4283:1: (kw= '*' | kw= '/' )
            {
            // InternalIvml.g:4283:1: (kw= '*' | kw= '/' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==72) ) {
                alt64=1;
            }
            else if ( (LA64_0==73) ) {
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
                    // InternalIvml.g:4284:2: kw= '*'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4291:2: kw= '/'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4304:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalIvml.g:4305:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalIvml.g:4306:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalIvml.g:4313:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4316:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalIvml.g:4317:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalIvml.g:4317:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalIvml.g:4317:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalIvml.g:4317:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==71||LA65_0==74) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalIvml.g:4318:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalIvml.g:4318:1: (lv_op_0_0= ruleUnaryOperator )
                    // InternalIvml.g:4319:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_25);
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
                              		"de.uni_hildesheim.sse.Ivml.UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:4335:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalIvml.g:4336:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalIvml.g:4336:1: (lv_expr_1_0= rulePostfixExpression )
            // InternalIvml.g:4337:3: lv_expr_1_0= rulePostfixExpression
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
                      		"de.uni_hildesheim.sse.Ivml.PostfixExpression");
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
    // InternalIvml.g:4361:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalIvml.g:4362:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalIvml.g:4363:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalIvml.g:4370:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4373:28: ( (kw= 'not' | kw= '-' ) )
            // InternalIvml.g:4374:1: (kw= 'not' | kw= '-' )
            {
            // InternalIvml.g:4374:1: (kw= 'not' | kw= '-' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==74) ) {
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
                    // InternalIvml.g:4375:2: kw= 'not'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4382:2: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4395:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalIvml.g:4396:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalIvml.g:4397:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalIvml.g:4404:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4407:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // InternalIvml.g:4408:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // InternalIvml.g:4408:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt69=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==EOF||(LA69_1>=15 && LA69_1<=16)||(LA69_1>=18 && LA69_1<=19)||(LA69_1>=25 && LA69_1<=26)||(LA69_1>=34 && LA69_1<=35)||LA69_1==47||(LA69_1>=57 && LA69_1<=73)||(LA69_1>=75 && LA69_1<=77)||(LA69_1>=80 && LA69_1<=82)) ) {
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

                if ( (LA69_2==EOF||(LA69_2>=15 && LA69_2<=16)||(LA69_2>=18 && LA69_2<=19)||(LA69_2>=25 && LA69_2<=26)||(LA69_2>=34 && LA69_2<=35)||LA69_2==47||(LA69_2>=57 && LA69_2<=73)||(LA69_2>=75 && LA69_2<=77)||(LA69_2>=80 && LA69_2<=82)) ) {
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

                if ( (LA69_3==EOF||(LA69_3>=15 && LA69_3<=16)||(LA69_3>=18 && LA69_3<=19)||(LA69_3>=25 && LA69_3<=26)||(LA69_3>=34 && LA69_3<=35)||LA69_3==47||(LA69_3>=57 && LA69_3<=73)||(LA69_3>=75 && LA69_3<=77)||(LA69_3>=80 && LA69_3<=82)) ) {
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

                if ( (LA69_4==EOF||(LA69_4>=15 && LA69_4<=16)||(LA69_4>=18 && LA69_4<=19)||(LA69_4>=25 && LA69_4<=26)||(LA69_4>=34 && LA69_4<=35)||LA69_4==47||(LA69_4>=57 && LA69_4<=73)||(LA69_4>=75 && LA69_4<=77)||(LA69_4>=80 && LA69_4<=82)) ) {
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
            case 78:
            case 79:
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
                    // InternalIvml.g:4408:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // InternalIvml.g:4408:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // InternalIvml.g:4408:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // InternalIvml.g:4408:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // InternalIvml.g:4409:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4409:1: (lv_call_0_0= ruleFeatureCall )
                    // InternalIvml.g:4410:3: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
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
                              		"de.uni_hildesheim.sse.Ivml.FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:4426:2: ( (lv_fCalls_1_0= ruleCall ) )*
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
                        else if ( ((LA67_0>=75 && LA67_0<=76)) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalIvml.g:4427:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // InternalIvml.g:4427:1: (lv_fCalls_1_0= ruleCall )
                    	    // InternalIvml.g:4428:3: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_51);
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
                    	              		"de.uni_hildesheim.sse.Ivml.Call");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    // InternalIvml.g:4444:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==35) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalIvml.g:4445:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // InternalIvml.g:4445:1: (lv_access_2_0= ruleExpressionAccess )
                            // InternalIvml.g:4446:3: lv_access_2_0= ruleExpressionAccess
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getAccessExpressionAccessParserRuleCall_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
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
                                      		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
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
                    // InternalIvml.g:4463:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // InternalIvml.g:4463:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // InternalIvml.g:4464:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // InternalIvml.g:4464:1: (lv_left_3_0= rulePrimaryExpression )
                    // InternalIvml.g:4465:3: lv_left_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.PrimaryExpression");
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
    // InternalIvml.g:4489:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalIvml.g:4490:2: (iv_ruleCall= ruleCall EOF )
            // InternalIvml.g:4491:2: iv_ruleCall= ruleCall EOF
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
    // InternalIvml.g:4498:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
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
            // InternalIvml.g:4501:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // InternalIvml.g:4502:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // InternalIvml.g:4502:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt70=1;
                }
                break;
            case 75:
                {
                alt70=2;
                }
                break;
            case 76:
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
                    // InternalIvml.g:4502:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // InternalIvml.g:4502:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // InternalIvml.g:4502:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // InternalIvml.g:4506:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // InternalIvml.g:4507:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4507:1: (lv_call_1_0= ruleFeatureCall )
                    // InternalIvml.g:4508:3: lv_call_1_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getCallFeatureCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:4525:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    {
                    // InternalIvml.g:4525:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    // InternalIvml.g:4525:8: otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) )
                    {
                    otherlv_2=(Token)match(input,75,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:4529:1: ( (lv_setOp_3_0= ruleSetOp ) )
                    // InternalIvml.g:4530:1: (lv_setOp_3_0= ruleSetOp )
                    {
                    // InternalIvml.g:4530:1: (lv_setOp_3_0= ruleSetOp )
                    // InternalIvml.g:4531:3: lv_setOp_3_0= ruleSetOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getSetOpSetOpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.SetOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:4548:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // InternalIvml.g:4548:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // InternalIvml.g:4548:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalIvml.g:4552:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // InternalIvml.g:4553:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // InternalIvml.g:4553:1: (lv_arrayEx_5_0= ruleExpression )
                    // InternalIvml.g:4554:3: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_52);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4582:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalIvml.g:4583:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalIvml.g:4584:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
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
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalIvml.g:4591:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4594:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) )
            // InternalIvml.g:4595:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            {
            // InternalIvml.g:4595:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            // InternalIvml.g:4595:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')'
            {
            // InternalIvml.g:4595:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:4596:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:4596:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:4597:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_20);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:4617:1: ( (lv_param_2_0= ruleActualParameterList ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_NUMBER && LA71_0<=RULE_EXPONENT)||LA71_0==14||LA71_0==24||(LA71_0>=36 && LA71_0<=39)||LA71_0==53||LA71_0==56||LA71_0==71||LA71_0==74||(LA71_0>=78 && LA71_0<=79)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalIvml.g:4618:1: (lv_param_2_0= ruleActualParameterList )
                    {
                    // InternalIvml.g:4618:1: (lv_param_2_0= ruleActualParameterList )
                    // InternalIvml.g:4619:3: lv_param_2_0= ruleActualParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getParamActualParameterListParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                              		"de.uni_hildesheim.sse.Ivml.ActualParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4647:1: entryRuleSetOp returns [EObject current=null] : iv_ruleSetOp= ruleSetOp EOF ;
    public final EObject entryRuleSetOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOp = null;


        try {
            // InternalIvml.g:4648:2: (iv_ruleSetOp= ruleSetOp EOF )
            // InternalIvml.g:4649:2: iv_ruleSetOp= ruleSetOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetOp=ruleSetOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetOp; 
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
    // $ANTLR end "entryRuleSetOp"


    // $ANTLR start "ruleSetOp"
    // InternalIvml.g:4656:1: ruleSetOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) ;
    public final EObject ruleSetOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_declEx_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4659:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' ) )
            // InternalIvml.g:4660:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            {
            // InternalIvml.g:4660:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')' )
            // InternalIvml.g:4660:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) ) ( (lv_declEx_3_0= ruleExpression ) )? otherlv_4= ')'
            {
            // InternalIvml.g:4660:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:4661:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:4661:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:4662:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_20);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:4682:1: ( (lv_decl_2_0= ruleDeclarator ) )
            // InternalIvml.g:4683:1: (lv_decl_2_0= ruleDeclarator )
            {
            // InternalIvml.g:4683:1: (lv_decl_2_0= ruleDeclarator )
            // InternalIvml.g:4684:3: lv_decl_2_0= ruleDeclarator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_53);
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
                      		"de.uni_hildesheim.sse.Ivml.Declarator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4700:2: ( (lv_declEx_3_0= ruleExpression ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_NUMBER && LA72_0<=RULE_EXPONENT)||LA72_0==14||LA72_0==24||(LA72_0>=36 && LA72_0<=39)||LA72_0==53||LA72_0==56||LA72_0==71||LA72_0==74||(LA72_0>=78 && LA72_0<=79)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalIvml.g:4701:1: (lv_declEx_3_0= ruleExpression )
                    {
                    // InternalIvml.g:4701:1: (lv_declEx_3_0= ruleExpression )
                    // InternalIvml.g:4702:3: lv_declEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclExExpressionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4730:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalIvml.g:4731:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalIvml.g:4732:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalIvml.g:4739:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4742:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalIvml.g:4743:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalIvml.g:4743:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalIvml.g:4743:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalIvml.g:4743:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalIvml.g:4744:1: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalIvml.g:4744:1: (lv_decl_0_0= ruleDeclaration )
            // InternalIvml.g:4745:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_54);
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
                      		"de.uni_hildesheim.sse.Ivml.Declaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4761:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==16) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalIvml.g:4761:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:4765:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalIvml.g:4766:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalIvml.g:4766:1: (lv_decl_2_0= ruleDeclaration )
            	    // InternalIvml.g:4767:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_54);
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
            	              		"de.uni_hildesheim.sse.Ivml.Declaration");
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

            otherlv_3=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4795:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalIvml.g:4796:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalIvml.g:4797:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalIvml.g:4804:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
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
            // InternalIvml.g:4807:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:4808:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:4808:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // InternalIvml.g:4808:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:4808:2: ( (lv_type_0_0= ruleType ) )?
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
                    // InternalIvml.g:4809:1: (lv_type_0_0= ruleType )
                    {
                    // InternalIvml.g:4809:1: (lv_type_0_0= ruleType )
                    // InternalIvml.g:4810:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_4);
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
                              		"de.uni_hildesheim.sse.Ivml.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:4826:3: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:4827:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:4827:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:4828:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_55);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4844:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==18) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalIvml.g:4844:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:4848:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // InternalIvml.g:4849:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:4849:1: (lv_id_3_0= ruleIdentifier )
            	    // InternalIvml.g:4850:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_55);
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
            	              		"de.uni_hildesheim.sse.Ivml.Identifier");
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

            // InternalIvml.g:4866:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==19) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalIvml.g:4866:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalIvml.g:4870:1: ( (lv_init_5_0= ruleExpression ) )
                    // InternalIvml.g:4871:1: (lv_init_5_0= ruleExpression )
                    {
                    // InternalIvml.g:4871:1: (lv_init_5_0= ruleExpression )
                    // InternalIvml.g:4872:3: lv_init_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getInitExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
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
    // InternalIvml.g:4896:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // InternalIvml.g:4897:2: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // InternalIvml.g:4898:2: iv_ruleActualParameterList= ruleActualParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActualParameterList=ruleActualParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualParameterList; 
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
    // $ANTLR end "entryRuleActualParameterList"


    // $ANTLR start "ruleActualParameterList"
    // InternalIvml.g:4905:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4908:28: ( ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) )
            // InternalIvml.g:4909:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            {
            // InternalIvml.g:4909:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            // InternalIvml.g:4909:2: ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            {
            // InternalIvml.g:4909:2: ( (lv_param_0_0= ruleExpression ) )
            // InternalIvml.g:4910:1: (lv_param_0_0= ruleExpression )
            {
            // InternalIvml.g:4910:1: (lv_param_0_0= ruleExpression )
            // InternalIvml.g:4911:3: lv_param_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4927:2: (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==18) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalIvml.g:4927:4: otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:4931:1: ( (lv_param_2_0= ruleExpression ) )
            	    // InternalIvml.g:4932:1: (lv_param_2_0= ruleExpression )
            	    {
            	    // InternalIvml.g:4932:1: (lv_param_2_0= ruleExpression )
            	    // InternalIvml.g:4933:3: lv_param_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualParameterListAccess().getParamExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
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
            	              		"de.uni_hildesheim.sse.Ivml.Expression");
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
    // InternalIvml.g:4957:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // InternalIvml.g:4958:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // InternalIvml.g:4959:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionAccess=ruleExpressionAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionAccess; 
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
    // $ANTLR end "entryRuleExpressionAccess"


    // $ANTLR start "ruleExpressionAccess"
    // InternalIvml.g:4966:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4969:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:4970:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:4970:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:4970:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // InternalIvml.g:4974:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:4975:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:4975:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:4976:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4992:2: ( (lv_calls_2_0= ruleCall ) )*
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
                else if ( ((LA78_0>=75 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalIvml.g:4993:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // InternalIvml.g:4993:1: (lv_calls_2_0= ruleCall )
            	    // InternalIvml.g:4994:3: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
            	              		"de.uni_hildesheim.sse.Ivml.Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // InternalIvml.g:5010:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==35) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalIvml.g:5011:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5011:1: (lv_access_3_0= ruleExpressionAccess )
                    // InternalIvml.g:5012:3: lv_access_3_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getAccessExpressionAccessParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
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
    // InternalIvml.g:5036:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalIvml.g:5037:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalIvml.g:5038:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalIvml.g:5045:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
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
            // InternalIvml.g:5048:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5049:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5049:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5049:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // InternalIvml.g:5049:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) )
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
            case 79:
                {
                alt80=3;
                }
                break;
            case 78:
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
                    // InternalIvml.g:5049:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // InternalIvml.g:5049:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // InternalIvml.g:5050:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // InternalIvml.g:5050:1: (lv_lit_0_0= ruleLiteral )
                    // InternalIvml.g:5051:3: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
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
                              		"de.uni_hildesheim.sse.Ivml.Literal");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:5068:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalIvml.g:5068:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalIvml.g:5068:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // InternalIvml.g:5072:1: ( (lv_ex_2_0= ruleExpression ) )
                    // InternalIvml.g:5073:1: (lv_ex_2_0= ruleExpression )
                    {
                    // InternalIvml.g:5073:1: (lv_ex_2_0= ruleExpression )
                    // InternalIvml.g:5074:3: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:5095:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // InternalIvml.g:5095:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // InternalIvml.g:5096:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // InternalIvml.g:5096:1: (lv_ifEx_4_0= ruleIfExpression )
                    // InternalIvml.g:5097:3: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
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
                              		"de.uni_hildesheim.sse.Ivml.IfExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:5114:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalIvml.g:5114:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalIvml.g:5114:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,78,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // InternalIvml.g:5122:1: ( (lv_refEx_7_0= ruleExpression ) )
                    // InternalIvml.g:5123:1: (lv_refEx_7_0= ruleExpression )
                    {
                    // InternalIvml.g:5123:1: (lv_refEx_7_0= ruleExpression )
                    // InternalIvml.g:5124:3: lv_refEx_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefExExpressionParserRuleCall_0_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
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
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                          
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:5144:3: ( (lv_calls_9_0= ruleCall ) )*
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
                else if ( ((LA81_0>=75 && LA81_0<=76)) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalIvml.g:5145:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // InternalIvml.g:5145:1: (lv_calls_9_0= ruleCall )
            	    // InternalIvml.g:5146:3: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
            	              		"de.uni_hildesheim.sse.Ivml.Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            // InternalIvml.g:5162:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==35) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalIvml.g:5163:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5163:1: (lv_access_10_0= ruleExpressionAccess )
                    // InternalIvml.g:5164:3: lv_access_10_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAccessExpressionAccessParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
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
    // InternalIvml.g:5188:1: entryRuleCollectionInitializer returns [EObject current=null] : iv_ruleCollectionInitializer= ruleCollectionInitializer EOF ;
    public final EObject entryRuleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionInitializer = null;


        try {
            // InternalIvml.g:5189:2: (iv_ruleCollectionInitializer= ruleCollectionInitializer EOF )
            // InternalIvml.g:5190:2: iv_ruleCollectionInitializer= ruleCollectionInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionInitializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectionInitializer=ruleCollectionInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionInitializer; 
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
    // $ANTLR end "entryRuleCollectionInitializer"


    // $ANTLR start "ruleCollectionInitializer"
    // InternalIvml.g:5197:1: ruleCollectionInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5200:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // InternalIvml.g:5201:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // InternalIvml.g:5201:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // InternalIvml.g:5201:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // InternalIvml.g:5201:2: ()
            // InternalIvml.g:5202:2: 
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

            // InternalIvml.g:5210:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_VERSION && LA83_0<=RULE_EXPONENT)||LA83_0==53) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalIvml.g:5211:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:5211:1: (lv_type_1_0= ruleQualifiedName )
                    // InternalIvml.g:5212:3: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
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
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,14,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCollectionInitializerAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:5232:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_NUMBER && LA84_0<=RULE_EXPONENT)||LA84_0==14||LA84_0==24||(LA84_0>=36 && LA84_0<=39)||LA84_0==53||LA84_0==71||LA84_0==74||(LA84_0>=78 && LA84_0<=79)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalIvml.g:5233:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // InternalIvml.g:5233:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // InternalIvml.g:5234:3: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
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
                              		"de.uni_hildesheim.sse.Ivml.ExpressionListOrRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:5262:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // InternalIvml.g:5263:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // InternalIvml.g:5264:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListOrRange; 
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
    // $ANTLR end "entryRuleExpressionListOrRange"


    // $ANTLR start "ruleExpressionListOrRange"
    // InternalIvml.g:5271:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5274:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // InternalIvml.g:5275:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // InternalIvml.g:5275:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // InternalIvml.g:5275:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // InternalIvml.g:5275:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // InternalIvml.g:5276:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // InternalIvml.g:5276:1: (lv_list_0_0= ruleExpressionListEntry )
            // InternalIvml.g:5277:3: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
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
                      		"de.uni_hildesheim.sse.Ivml.ExpressionListEntry");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5293:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==18) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalIvml.g:5293:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5297:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // InternalIvml.g:5298:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // InternalIvml.g:5298:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // InternalIvml.g:5299:3: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
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
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionListEntry");
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
    // InternalIvml.g:5323:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // InternalIvml.g:5324:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // InternalIvml.g:5325:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionListEntry=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListEntry; 
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
    // $ANTLR end "entryRuleExpressionListEntry"


    // $ANTLR start "ruleExpressionListEntry"
    // InternalIvml.g:5332:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) ;
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
            // InternalIvml.g:5335:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:5336:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:5336:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:5336:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:5336:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalIvml.g:5336:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // InternalIvml.g:5336:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5337:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5337:1: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5338:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_56);
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
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:5354:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==35) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalIvml.g:5354:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // InternalIvml.g:5358:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // InternalIvml.g:5359:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // InternalIvml.g:5359:1: (lv_attrib_2_0= ruleIdentifier )
                            // InternalIvml.g:5360:3: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_24);
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
                                      		"de.uni_hildesheim.sse.Ivml.Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // InternalIvml.g:5380:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            int alt88=2;
            alt88 = dfa88.predict(input);
            switch (alt88) {
                case 1 :
                    // InternalIvml.g:5380:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:5380:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    // InternalIvml.g:5381:1: (lv_value_4_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:5381:1: (lv_value_4_0= ruleImplicationExpression )
                    // InternalIvml.g:5382:3: lv_value_4_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getValueImplicationExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleImplicationExpression();

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
                              		"de.uni_hildesheim.sse.Ivml.ImplicationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:5399:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:5399:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:5400:1: (lv_collection_5_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:5400:1: (lv_collection_5_0= ruleCollectionInitializer )
                    // InternalIvml.g:5401:3: lv_collection_5_0= ruleCollectionInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getCollectionCollectionInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
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
                              		"de.uni_hildesheim.sse.Ivml.CollectionInitializer");
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
    // InternalIvml.g:5425:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalIvml.g:5426:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalIvml.g:5427:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalIvml.g:5434:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5437:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // InternalIvml.g:5438:1: ( (lv_val_0_0= ruleValue ) )
            {
            // InternalIvml.g:5438:1: ( (lv_val_0_0= ruleValue ) )
            // InternalIvml.g:5439:1: (lv_val_0_0= ruleValue )
            {
            // InternalIvml.g:5439:1: (lv_val_0_0= ruleValue )
            // InternalIvml.g:5440:3: lv_val_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
                      		"de.uni_hildesheim.sse.Ivml.Value");
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
    // InternalIvml.g:5464:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalIvml.g:5465:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalIvml.g:5466:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalIvml.g:5473:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) ;
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
            // InternalIvml.g:5476:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' ) )
            // InternalIvml.g:5477:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            {
            // InternalIvml.g:5477:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            // InternalIvml.g:5477:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // InternalIvml.g:5481:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // InternalIvml.g:5482:1: (lv_ifEx_1_0= ruleExpression )
            {
            // InternalIvml.g:5482:1: (lv_ifEx_1_0= ruleExpression )
            // InternalIvml.g:5483:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_57);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,80,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // InternalIvml.g:5503:1: ( (lv_thenEx_3_0= ruleExpression ) )
            // InternalIvml.g:5504:1: (lv_thenEx_3_0= ruleExpression )
            {
            // InternalIvml.g:5504:1: (lv_thenEx_3_0= ruleExpression )
            // InternalIvml.g:5505:3: lv_thenEx_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_58);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,81,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // InternalIvml.g:5525:1: ( (lv_elseEx_5_0= ruleExpression ) )
            // InternalIvml.g:5526:1: (lv_elseEx_5_0= ruleExpression )
            {
            // InternalIvml.g:5526:1: (lv_elseEx_5_0= ruleExpression )
            // InternalIvml.g:5527:3: lv_elseEx_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
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
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:5555:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalIvml.g:5556:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalIvml.g:5557:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalIvml.g:5564:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:5567:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalIvml.g:5568:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalIvml.g:5568:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
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
                    // InternalIvml.g:5568:6: this_ID_0= RULE_ID
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
                    // InternalIvml.g:5576:10: this_VERSION_1= RULE_VERSION
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
                    // InternalIvml.g:5584:10: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalIvml.g:5593:2: kw= 'version'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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


        // InternalIvml.g:161:1: ( (lv_version_3_0= ruleVersionStmt ) )
        // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        {
        // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        // InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
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


        // InternalIvml.g:1775:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalIvml.g:1775:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalIvml.g:1775:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalIvml.g:1776:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalIvml.g:1776:1: (lv_qValue_2_0= ruleQualifiedName )
        // InternalIvml.g:1777:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
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
        // InternalIvml.g:1857:7: ( ( RULE_VERSION ) )
        // InternalIvml.g:1858:1: ( RULE_VERSION )
        {
        // InternalIvml.g:1858:1: ( RULE_VERSION )
        // InternalIvml.g:1859:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_InternalIvml

    // $ANTLR start synpred119_InternalIvml
    public final void synpred119_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;


        // InternalIvml.g:5336:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )
        // InternalIvml.g:5336:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
        {
        // InternalIvml.g:5336:3: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5337:1: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5337:1: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5338:3: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_56);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalIvml.g:5354:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( (LA95_0==35) ) {
            alt95=1;
        }
        switch (alt95) {
            case 1 :
                // InternalIvml.g:5354:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                {
                otherlv_1=(Token)match(input,35,FOLLOW_4); if (state.failed) return ;
                // InternalIvml.g:5358:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                // InternalIvml.g:5359:1: (lv_attrib_2_0= ruleIdentifier )
                {
                // InternalIvml.g:5359:1: (lv_attrib_2_0= ruleIdentifier )
                // InternalIvml.g:5360:3: lv_attrib_2_0= ruleIdentifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_24);
                lv_attrib_2_0=ruleIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_InternalIvml

    // Delegated rules

    public final boolean synpred119_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA88 dfa88 = new DFA88(this);
    static final String dfa_1s = "\24\uffff";
    static final String dfa_2s = "\1\1\23\uffff";
    static final String dfa_3s = "\1\4\3\uffff\4\6\6\uffff\6\6";
    static final String dfa_4s = "\1\117\3\uffff\4\114\6\uffff\1\65\4\114\1\65";
    static final String dfa_5s = "\1\uffff\1\11\1\1\1\2\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\6\uffff";
    static final String dfa_6s = "\24\uffff}>";
    static final String[] dfa_7s = {
            "\2\12\1\5\1\4\1\6\5\uffff\1\12\1\1\1\uffff\1\2\2\uffff\2\2\1\uffff\1\15\1\12\2\uffff\1\2\1\uffff\5\3\2\uffff\4\12\3\3\2\13\1\10\2\uffff\1\11\4\uffff\1\7\1\14\1\uffff\1\12\16\uffff\1\12\2\uffff\1\12\3\uffff\2\12",
            "",
            "",
            "",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\11\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\17\1\21\54\uffff\1\22",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\16\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\1\20\1\17\1\21\54\uffff\1\22"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
    }
    static final String dfa_8s = "\20\uffff";
    static final String dfa_9s = "\1\4\2\uffff\4\6\3\uffff\6\6";
    static final String dfa_10s = "\1\117\2\uffff\4\114\3\uffff\1\65\4\114\1\65";
    static final String dfa_11s = "\1\uffff\1\5\1\1\4\uffff\1\2\1\3\1\4\6\uffff";
    static final String dfa_12s = "\20\uffff}>";
    static final String[] dfa_13s = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\5\2\2\uffff\4\7\3\2\5\uffff\1\11\4\uffff\1\6\2\uffff\1\7\16\uffff\1\7\2\uffff\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "",
            "\1\14\1\13\1\15\54\uffff\1\16",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\1\14\1\13\1\15\54\uffff\1\16"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 774:1: ( ( (lv_elements_6_0= ruleVariableDeclaration ) ) | ( (lv_elements_7_0= ruleExpressionStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) | ( (lv_elements_9_0= ruleEval ) ) )*";
        }
    }
    static final String dfa_14s = "\17\uffff";
    static final String dfa_15s = "\1\4\2\uffff\4\6\2\uffff\6\6";
    static final String dfa_16s = "\1\117\2\uffff\4\114\2\uffff\1\65\4\114\1\65";
    static final String dfa_17s = "\1\uffff\1\4\1\1\4\uffff\1\2\1\3\6\uffff";
    static final String dfa_18s = "\17\uffff}>";
    static final String[] dfa_19s = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\5\2\2\uffff\4\7\3\2\12\uffff\1\6\2\uffff\1\7\16\uffff\1\7\2\uffff\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\11\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "\1\13\1\12\1\14\54\uffff\1\15",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\16\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\1\13\1\12\1\14\54\uffff\1\15"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()+ loopback of 938:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+";
        }
    }
    static final String dfa_20s = "\16\uffff";
    static final String dfa_21s = "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String dfa_22s = "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_23s = "\1\117\2\uffff\4\122\1\uffff\1\65\4\122\1\65";
    static final String dfa_24s = "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String dfa_25s = "\16\uffff}>";
    static final String[] dfa_26s = {
            "\2\2\1\4\1\3\1\5\5\uffff\1\7\11\uffff\1\2\13\uffff\4\2\15\uffff\1\6\2\uffff\1\1\16\uffff\1\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\7\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "",
            "\1\12\1\11\1\13\54\uffff\1\14",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\7\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\12\1\11\1\13\54\uffff\1\14"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "3040:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String dfa_27s = "\15\uffff";
    static final String dfa_28s = "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String dfa_29s = "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_30s = "\1\117\1\uffff\4\122\1\uffff\1\65\4\122\1\65";
    static final String dfa_31s = "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String dfa_32s = "\15\uffff}>";
    static final String[] dfa_33s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "3297:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String[] dfa_34s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\7\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\7\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "3760:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String dfa_35s = "\22\uffff";
    static final String dfa_36s = "\1\4\4\0\15\uffff";
    static final String dfa_37s = "\1\117\4\0\15\uffff";
    static final String dfa_38s = "\5\uffff\1\2\13\uffff\1\1";
    static final String dfa_39s = "\1\uffff\1\0\1\1\1\2\1\3\15\uffff}>";
    static final String[] dfa_40s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\13\uffff\4\5\15\uffff\1\4\21\uffff\1\5\2\uffff\1\5\3\uffff\2\5",
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
            ""
    };

    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "5336:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_2 = input.LA(1);

                         
                        int index87_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index87_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA87_3 = input.LA(1);

                         
                        int index87_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index87_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA87_4 = input.LA(1);

                         
                        int index87_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index87_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_41s = "\1\117\1\uffff\4\114\1\uffff\1\65\4\114\1\65";
    static final String[] dfa_42s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\13\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\11\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\11\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\11\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\11\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "",
            "\1\11\1\10\1\12\54\uffff\1\13",
            "\1\6\1\1\2\uffff\2\1\16\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\16\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\16\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\16\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\11\1\10\1\12\54\uffff\1\13"
    };
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[][] dfa_42 = unpackEncodedStringArray(dfa_42s);

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_41;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_42;
        }
        public String getDescription() {
            return "5380:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00200000000001C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x017B3FF3E9B2C1F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x01733FF3E9B2C1F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x01633FF3E9B2C1F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x01613FF3E9B241F2L,0x000000000000C480L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x01613FF3E9B2C1F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x01613FF3E9B241F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x002000F0010001F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00200703E00001C0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x012000F0010041F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00200000000081C0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000400000010002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x012100F0010041F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x012000F00100C1F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000410010000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00A00703E00001C0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00200703E20001C0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x7000000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000800000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x012000F0030041F0L,0x000000000000C480L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000800080000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});

}