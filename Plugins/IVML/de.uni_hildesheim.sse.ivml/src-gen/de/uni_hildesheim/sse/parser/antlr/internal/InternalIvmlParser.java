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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'abstract'", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'const'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'::'", "'.'", "'true'", "'false'", "'self'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'attribute'", "'annotate'", "'freeze'", "'but'", "'|'", "'eval'", "'interface'", "'export'", "'import'", "'conflicts'", "'version'", "'def'", "'static'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'->'", "'['", "']'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
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
    public static final int T__83=83;
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

            if ( (LA2_0==54) ) {
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

                if ( (LA3_0==52) ) {
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

                if ( (LA4_0==53) ) {
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

                if ( (LA5_0==50) ) {
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
    // InternalIvml.g:1214:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject lv_decls_2_0 = null;

        EObject lv_decls_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1217:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) )
            // InternalIvml.g:1218:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            {
            // InternalIvml.g:1218:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            // InternalIvml.g:1218:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';'
            {
            // InternalIvml.g:1218:2: ( (lv_const_0_0= 'const' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalIvml.g:1219:1: (lv_const_0_0= 'const' )
                    {
                    // InternalIvml.g:1219:1: (lv_const_0_0= 'const' )
                    // InternalIvml.g:1220:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,29,FOLLOW_26); if (state.failed) return current;
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

            // InternalIvml.g:1233:3: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:1234:1: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:1234:1: (lv_type_1_0= ruleType )
            // InternalIvml.g:1235:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
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
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1251:2: ( (lv_decls_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:1252:1: (lv_decls_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:1252:1: (lv_decls_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:1253:3: lv_decls_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_decls_2_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"decls",
                      		lv_decls_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1269:2: (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==18) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalIvml.g:1269:4: otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalIvml.g:1273:1: ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    // InternalIvml.g:1274:1: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    {
            	    // InternalIvml.g:1274:1: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    // InternalIvml.g:1275:3: lv_decls_4_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_decls_4_0=ruleVariableDeclarationPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decls",
            	              		lv_decls_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
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

            otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleVariableDeclarationPart"
    // InternalIvml.g:1303:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // InternalIvml.g:1304:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // InternalIvml.g:1305:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
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
    // InternalIvml.g:1312:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1315:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:1316:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:1316:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // InternalIvml.g:1316:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:1316:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1317:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1317:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1318:3: lv_name_0_0= ruleIdentifier
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

            // InternalIvml.g:1334:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalIvml.g:1334:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:1338:1: ( (lv_default_2_0= ruleExpression ) )
                    // InternalIvml.g:1339:1: (lv_default_2_0= ruleExpression )
                    {
                    // InternalIvml.g:1339:1: (lv_default_2_0= ruleExpression )
                    // InternalIvml.g:1340:3: lv_default_2_0= ruleExpression
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
    // InternalIvml.g:1364:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalIvml.g:1365:2: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalIvml.g:1366:2: iv_ruleBasicType= ruleBasicType EOF
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
    // InternalIvml.g:1373:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1376:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) ) )
            // InternalIvml.g:1377:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            {
            // InternalIvml.g:1377:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt23=1;
                }
                break;
            case 31:
                {
                alt23=2;
                }
                break;
            case 32:
                {
                alt23=3;
                }
                break;
            case 33:
                {
                alt23=4;
                }
                break;
            case 34:
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
                    // InternalIvml.g:1377:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // InternalIvml.g:1377:2: ( (lv_type_0_0= 'Integer' ) )
                    // InternalIvml.g:1378:1: (lv_type_0_0= 'Integer' )
                    {
                    // InternalIvml.g:1378:1: (lv_type_0_0= 'Integer' )
                    // InternalIvml.g:1379:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1393:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // InternalIvml.g:1393:6: ( (lv_type_1_0= 'Real' ) )
                    // InternalIvml.g:1394:1: (lv_type_1_0= 'Real' )
                    {
                    // InternalIvml.g:1394:1: (lv_type_1_0= 'Real' )
                    // InternalIvml.g:1395:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1409:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // InternalIvml.g:1409:6: ( (lv_type_2_0= 'Boolean' ) )
                    // InternalIvml.g:1410:1: (lv_type_2_0= 'Boolean' )
                    {
                    // InternalIvml.g:1410:1: (lv_type_2_0= 'Boolean' )
                    // InternalIvml.g:1411:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1425:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // InternalIvml.g:1425:6: ( (lv_type_3_0= 'String' ) )
                    // InternalIvml.g:1426:1: (lv_type_3_0= 'String' )
                    {
                    // InternalIvml.g:1426:1: (lv_type_3_0= 'String' )
                    // InternalIvml.g:1427:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1441:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // InternalIvml.g:1441:6: ( (lv_type_4_0= 'Constraint' ) )
                    // InternalIvml.g:1442:1: (lv_type_4_0= 'Constraint' )
                    {
                    // InternalIvml.g:1442:1: (lv_type_4_0= 'Constraint' )
                    // InternalIvml.g:1443:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:1464:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalIvml.g:1465:2: (iv_ruleType= ruleType EOF )
            // InternalIvml.g:1466:2: iv_ruleType= ruleType EOF
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
    // InternalIvml.g:1473:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1476:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // InternalIvml.g:1477:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // InternalIvml.g:1477:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt24=1;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 54:
                {
                alt24=2;
                }
                break;
            case 41:
            case 42:
            case 43:
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
                    // InternalIvml.g:1477:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // InternalIvml.g:1477:2: ( (lv_type_0_0= ruleBasicType ) )
                    // InternalIvml.g:1478:1: (lv_type_0_0= ruleBasicType )
                    {
                    // InternalIvml.g:1478:1: (lv_type_0_0= ruleBasicType )
                    // InternalIvml.g:1479:3: lv_type_0_0= ruleBasicType
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
                    // InternalIvml.g:1496:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1496:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:1497:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1497:1: (lv_id_1_0= ruleQualifiedName )
                    // InternalIvml.g:1498:3: lv_id_1_0= ruleQualifiedName
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
                    // InternalIvml.g:1515:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // InternalIvml.g:1515:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // InternalIvml.g:1516:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // InternalIvml.g:1516:1: (lv_derived_2_0= ruleDerivedType )
                    // InternalIvml.g:1517:3: lv_derived_2_0= ruleDerivedType
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
    // InternalIvml.g:1541:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalIvml.g:1542:2: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalIvml.g:1543:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalIvml.g:1550:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1553:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalIvml.g:1554:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalIvml.g:1554:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalIvml.g:1555:1: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalIvml.g:1555:1: (lv_val_0_0= RULE_NUMBER )
            // InternalIvml.g:1556:3: lv_val_0_0= RULE_NUMBER
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
    // InternalIvml.g:1580:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalIvml.g:1581:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalIvml.g:1582:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalIvml.g:1589:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1592:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // InternalIvml.g:1593:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // InternalIvml.g:1593:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // InternalIvml.g:1593:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // InternalIvml.g:1593:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
            int alt26=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==35) ) {
                        alt26=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA26_2 = input.LA(2);

                    if ( (LA26_2==35) ) {
                        alt26=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA26_3 = input.LA(2);

                    if ( (LA26_3==35) ) {
                        alt26=1;
                    }
                    }
                    break;
                case 54:
                    {
                    int LA26_4 = input.LA(2);

                    if ( (LA26_4==35) ) {
                        alt26=1;
                    }
                    }
                    break;
            }

            switch (alt26) {
                case 1 :
                    // InternalIvml.g:1593:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // InternalIvml.g:1593:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // InternalIvml.g:1594:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:1594:1: (lv_qName_0_0= ruleIdentifier )
                    // InternalIvml.g:1595:3: lv_qName_0_0= ruleIdentifier
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

                    // InternalIvml.g:1611:2: ( (lv_qName_1_0= '::' ) )
                    // InternalIvml.g:1612:1: (lv_qName_1_0= '::' )
                    {
                    // InternalIvml.g:1612:1: (lv_qName_1_0= '::' )
                    // InternalIvml.g:1613:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
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

                    // InternalIvml.g:1626:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA25_1 = input.LA(2);

                            if ( (LA25_1==35) ) {
                                alt25=1;
                            }


                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA25_2 = input.LA(2);

                            if ( (LA25_2==35) ) {
                                alt25=1;
                            }


                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA25_3 = input.LA(2);

                            if ( (LA25_3==35) ) {
                                alt25=1;
                            }


                            }
                            break;
                        case 54:
                            {
                            int LA25_4 = input.LA(2);

                            if ( (LA25_4==35) ) {
                                alt25=1;
                            }


                            }
                            break;

                        }

                        switch (alt25) {
                    	case 1 :
                    	    // InternalIvml.g:1626:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // InternalIvml.g:1626:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // InternalIvml.g:1627:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:1627:1: (lv_qName_2_0= ruleIdentifier )
                    	    // InternalIvml.g:1628:3: lv_qName_2_0= ruleIdentifier
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

                    	    // InternalIvml.g:1644:2: ( (lv_qName_3_0= '::' ) )
                    	    // InternalIvml.g:1645:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // InternalIvml.g:1645:1: (lv_qName_3_0= '::' )
                    	    // InternalIvml.g:1646:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
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

            // InternalIvml.g:1659:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // InternalIvml.g:1660:1: (lv_qName_4_0= ruleIdentifier )
            {
            // InternalIvml.g:1660:1: (lv_qName_4_0= ruleIdentifier )
            // InternalIvml.g:1661:3: lv_qName_4_0= ruleIdentifier
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
    // InternalIvml.g:1685:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // InternalIvml.g:1686:2: (iv_ruleAccessName= ruleAccessName EOF )
            // InternalIvml.g:1687:2: iv_ruleAccessName= ruleAccessName EOF
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
    // InternalIvml.g:1694:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1697:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // InternalIvml.g:1698:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // InternalIvml.g:1698:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==36) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalIvml.g:1698:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // InternalIvml.g:1698:2: ( (lv_aName_0_0= '.' ) )
            	    // InternalIvml.g:1699:1: (lv_aName_0_0= '.' )
            	    {
            	    // InternalIvml.g:1699:1: (lv_aName_0_0= '.' )
            	    // InternalIvml.g:1700:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
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

            	    // InternalIvml.g:1713:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // InternalIvml.g:1714:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:1714:1: (lv_aName_1_0= ruleIdentifier )
            	    // InternalIvml.g:1715:3: lv_aName_1_0= ruleIdentifier
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
    // InternalIvml.g:1739:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalIvml.g:1740:2: (iv_ruleValue= ruleValue EOF )
            // InternalIvml.g:1741:2: iv_ruleValue= ruleValue EOF
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
    // InternalIvml.g:1748:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) ;
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
            // InternalIvml.g:1751:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) ) )
            // InternalIvml.g:1752:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
            {
            // InternalIvml.g:1752:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) ) )
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
            case 54:
                {
                alt29=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred47_InternalIvml()) ) {
                    alt29=3;
                }
                else if ( (synpred52_InternalIvml()) ) {
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
            case 37:
            case 38:
                {
                alt29=4;
                }
                break;
            case 39:
                {
                alt29=5;
                }
                break;
            case 40:
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
                    // InternalIvml.g:1752:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalIvml.g:1752:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalIvml.g:1753:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalIvml.g:1753:1: (lv_nValue_0_0= ruleNumValue )
                    // InternalIvml.g:1754:3: lv_nValue_0_0= ruleNumValue
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
                    // InternalIvml.g:1771:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalIvml.g:1771:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalIvml.g:1772:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalIvml.g:1772:1: (lv_sValue_1_0= RULE_STRING )
                    // InternalIvml.g:1773:3: lv_sValue_1_0= RULE_STRING
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
                    // InternalIvml.g:1790:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1790:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalIvml.g:1791:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1791:1: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalIvml.g:1792:3: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalIvml.g:1809:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalIvml.g:1809:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalIvml.g:1810:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalIvml.g:1810:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalIvml.g:1811:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalIvml.g:1811:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==37) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==38) ) {
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
                            // InternalIvml.g:1812:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                            // InternalIvml.g:1824:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1840:6: ( (lv_self_4_0= 'self' ) )
                    {
                    // InternalIvml.g:1840:6: ( (lv_self_4_0= 'self' ) )
                    // InternalIvml.g:1841:1: (lv_self_4_0= 'self' )
                    {
                    // InternalIvml.g:1841:1: (lv_self_4_0= 'self' )
                    // InternalIvml.g:1842:3: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1856:6: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // InternalIvml.g:1856:6: ( (lv_nullValue_5_0= 'null' ) )
                    // InternalIvml.g:1857:1: (lv_nullValue_5_0= 'null' )
                    {
                    // InternalIvml.g:1857:1: (lv_nullValue_5_0= 'null' )
                    // InternalIvml.g:1858:3: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1872:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    {
                    // InternalIvml.g:1872:6: ( ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION ) )
                    // InternalIvml.g:1872:7: ( ( RULE_VERSION ) )=> (lv_version_6_0= RULE_VERSION )
                    {
                    // InternalIvml.g:1878:1: (lv_version_6_0= RULE_VERSION )
                    // InternalIvml.g:1879:3: lv_version_6_0= RULE_VERSION
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
    // InternalIvml.g:1903:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // InternalIvml.g:1904:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // InternalIvml.g:1905:2: iv_ruleDerivedType= ruleDerivedType EOF
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
    // InternalIvml.g:1912:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
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
            // InternalIvml.g:1915:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // InternalIvml.g:1916:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // InternalIvml.g:1916:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // InternalIvml.g:1916:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // InternalIvml.g:1916:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt30=1;
                }
                break;
            case 42:
                {
                alt30=2;
                }
                break;
            case 43:
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
                    // InternalIvml.g:1916:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // InternalIvml.g:1916:3: ( (lv_op_0_0= 'setOf' ) )
                    // InternalIvml.g:1917:1: (lv_op_0_0= 'setOf' )
                    {
                    // InternalIvml.g:1917:1: (lv_op_0_0= 'setOf' )
                    // InternalIvml.g:1918:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,41,FOLLOW_20); if (state.failed) return current;
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
                    // InternalIvml.g:1932:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // InternalIvml.g:1932:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // InternalIvml.g:1933:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // InternalIvml.g:1933:1: (lv_op_1_0= 'sequenceOf' )
                    // InternalIvml.g:1934:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,42,FOLLOW_20); if (state.failed) return current;
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
                    // InternalIvml.g:1948:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // InternalIvml.g:1948:6: ( (lv_op_2_0= 'refTo' ) )
                    // InternalIvml.g:1949:1: (lv_op_2_0= 'refTo' )
                    {
                    // InternalIvml.g:1949:1: (lv_op_2_0= 'refTo' )
                    // InternalIvml.g:1950:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,43,FOLLOW_20); if (state.failed) return current;
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
            // InternalIvml.g:1967:1: ( (lv_type_4_0= ruleType ) )
            // InternalIvml.g:1968:1: (lv_type_4_0= ruleType )
            {
            // InternalIvml.g:1968:1: (lv_type_4_0= ruleType )
            // InternalIvml.g:1969:3: lv_type_4_0= ruleType
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
    // InternalIvml.g:1997:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // InternalIvml.g:1998:2: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // InternalIvml.g:1999:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
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
    // InternalIvml.g:2006:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) ;
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
            // InternalIvml.g:2009:28: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' ) )
            // InternalIvml.g:2010:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            {
            // InternalIvml.g:2010:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';' )
            // InternalIvml.g:2010:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( (lv_names_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )* otherlv_7= ';'
            {
            // InternalIvml.g:2010:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // InternalIvml.g:2011:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // InternalIvml.g:2011:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // InternalIvml.g:2012:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // InternalIvml.g:2012:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            else if ( (LA31_0==45) ) {
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
                    // InternalIvml.g:2013:3: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,44,FOLLOW_26); if (state.failed) return current;
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
                    // InternalIvml.g:2025:8: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,45,FOLLOW_26); if (state.failed) return current;
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

            // InternalIvml.g:2040:2: ( (lv_annotationType_1_0= ruleType ) )
            // InternalIvml.g:2041:1: (lv_annotationType_1_0= ruleType )
            {
            // InternalIvml.g:2041:1: (lv_annotationType_1_0= ruleType )
            // InternalIvml.g:2042:3: lv_annotationType_1_0= ruleType
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

            // InternalIvml.g:2058:2: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:2059:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:2059:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:2060:3: lv_annotationDecl_2_0= ruleVariableDeclarationPart
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
            // InternalIvml.g:2080:1: ( (lv_names_4_0= ruleIdentifier ) )
            // InternalIvml.g:2081:1: (lv_names_4_0= ruleIdentifier )
            {
            // InternalIvml.g:2081:1: (lv_names_4_0= ruleIdentifier )
            // InternalIvml.g:2082:3: lv_names_4_0= ruleIdentifier
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

            // InternalIvml.g:2098:2: (otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==18) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalIvml.g:2098:4: otherlv_5= ',' ( (lv_names_6_0= ruleIdentifier ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAnnotateToAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // InternalIvml.g:2102:1: ( (lv_names_6_0= ruleIdentifier ) )
            	    // InternalIvml.g:2103:1: (lv_names_6_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:2103:1: (lv_names_6_0= ruleIdentifier )
            	    // InternalIvml.g:2104:3: lv_names_6_0= ruleIdentifier
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
            	    break loop32;
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
    // InternalIvml.g:2132:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // InternalIvml.g:2133:2: (iv_ruleFreeze= ruleFreeze EOF )
            // InternalIvml.g:2134:2: iv_ruleFreeze= ruleFreeze EOF
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
    // InternalIvml.g:2141:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
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
            // InternalIvml.g:2144:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // InternalIvml.g:2145:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // InternalIvml.g:2145:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // InternalIvml.g:2145:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalIvml.g:2153:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_VERSION && LA33_0<=RULE_EXPONENT)||LA33_0==54) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalIvml.g:2154:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // InternalIvml.g:2154:1: (lv_names_2_0= ruleFreezeStatement )
            	    // InternalIvml.g:2155:3: lv_names_2_0= ruleFreezeStatement
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
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // InternalIvml.g:2175:1: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalIvml.g:2175:3: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // InternalIvml.g:2183:1: ( (lv_id_6_0= ruleIdentifier ) )
                    // InternalIvml.g:2184:1: (lv_id_6_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2184:1: (lv_id_6_0= ruleIdentifier )
                    // InternalIvml.g:2185:3: lv_id_6_0= ruleIdentifier
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

                    otherlv_7=(Token)match(input,48,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                          
                    }
                    // InternalIvml.g:2205:1: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // InternalIvml.g:2206:1: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:2206:1: (lv_ex_8_0= ruleLogicalExpression )
                    // InternalIvml.g:2207:3: lv_ex_8_0= ruleLogicalExpression
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

            // InternalIvml.g:2227:3: (otherlv_10= ';' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalIvml.g:2227:5: otherlv_10= ';'
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
    // InternalIvml.g:2239:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // InternalIvml.g:2240:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // InternalIvml.g:2241:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
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
    // InternalIvml.g:2248:1: ruleFreezeStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_access_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2251:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' ) )
            // InternalIvml.g:2252:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            {
            // InternalIvml.g:2252:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';' )
            // InternalIvml.g:2252:2: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_access_1_0= ruleAccessName ) )? otherlv_2= ';'
            {
            // InternalIvml.g:2252:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalIvml.g:2253:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalIvml.g:2253:1: (lv_name_0_0= ruleQualifiedName )
            // InternalIvml.g:2254:3: lv_name_0_0= ruleQualifiedName
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

            // InternalIvml.g:2270:2: ( (lv_access_1_0= ruleAccessName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==36) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalIvml.g:2271:1: (lv_access_1_0= ruleAccessName )
                    {
                    // InternalIvml.g:2271:1: (lv_access_1_0= ruleAccessName )
                    // InternalIvml.g:2272:3: lv_access_1_0= ruleAccessName
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
    // InternalIvml.g:2300:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // InternalIvml.g:2301:2: (iv_ruleEval= ruleEval EOF )
            // InternalIvml.g:2302:2: iv_ruleEval= ruleEval EOF
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
    // InternalIvml.g:2309:1: ruleEval returns [EObject current=null] : ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) ;
    public final EObject ruleEval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_nested_3_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2312:28: ( ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) )
            // InternalIvml.g:2313:1: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            {
            // InternalIvml.g:2313:1: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            // InternalIvml.g:2313:2: () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )?
            {
            // InternalIvml.g:2313:2: ()
            // InternalIvml.g:2314:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEvalAccess().getEvalAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,49,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getEvalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,14,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:2330:1: ( (lv_nested_3_0= ruleEval ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==49) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalIvml.g:2331:1: (lv_nested_3_0= ruleEval )
            	    {
            	    // InternalIvml.g:2331:1: (lv_nested_3_0= ruleEval )
            	    // InternalIvml.g:2332:3: lv_nested_3_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_nested_3_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nested",
            	              		lv_nested_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // InternalIvml.g:2348:3: ( (lv_statements_4_0= ruleExpressionStatement ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_NUMBER && LA38_0<=RULE_EXPONENT)||LA38_0==14||LA38_0==24||(LA38_0>=37 && LA38_0<=40)||LA38_0==54||LA38_0==57||LA38_0==72||LA38_0==75||(LA38_0>=79 && LA38_0<=80)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalIvml.g:2349:1: (lv_statements_4_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:2349:1: (lv_statements_4_0= ruleExpressionStatement )
            	    // InternalIvml.g:2350:3: lv_statements_4_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_statements_4_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // InternalIvml.g:2370:1: (otherlv_6= ';' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==16) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalIvml.g:2370:3: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getEvalAccess().getSemicolonKeyword_6());
                          
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
    // InternalIvml.g:2382:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // InternalIvml.g:2383:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // InternalIvml.g:2384:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
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
    // InternalIvml.g:2391:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // InternalIvml.g:2394:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // InternalIvml.g:2395:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // InternalIvml.g:2395:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // InternalIvml.g:2395:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // InternalIvml.g:2399:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2400:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2400:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2401:3: lv_name_1_0= ruleIdentifier
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
            // InternalIvml.g:2421:1: ( (lv_exports_3_0= ruleExport ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==51) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalIvml.g:2422:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // InternalIvml.g:2422:1: (lv_exports_3_0= ruleExport )
            	    // InternalIvml.g:2423:3: lv_exports_3_0= ruleExport
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
            	    break loop40;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:2443:1: (otherlv_5= ';' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==16) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalIvml.g:2443:3: otherlv_5= ';'
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
    // InternalIvml.g:2455:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // InternalIvml.g:2456:2: (iv_ruleExport= ruleExport EOF )
            // InternalIvml.g:2457:2: iv_ruleExport= ruleExport EOF
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
    // InternalIvml.g:2464:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2467:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // InternalIvml.g:2468:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // InternalIvml.g:2468:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // InternalIvml.g:2468:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // InternalIvml.g:2472:1: ( (lv_names_1_0= ruleQualifiedName ) )
            // InternalIvml.g:2473:1: (lv_names_1_0= ruleQualifiedName )
            {
            // InternalIvml.g:2473:1: (lv_names_1_0= ruleQualifiedName )
            // InternalIvml.g:2474:3: lv_names_1_0= ruleQualifiedName
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

            // InternalIvml.g:2490:2: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==18) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalIvml.g:2490:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:2494:1: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // InternalIvml.g:2495:1: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // InternalIvml.g:2495:1: (lv_names_3_0= ruleQualifiedName )
            	    // InternalIvml.g:2496:3: lv_names_3_0= ruleQualifiedName
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
            	    break loop42;
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
    // InternalIvml.g:2524:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // InternalIvml.g:2525:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // InternalIvml.g:2526:2: iv_ruleImportStmt= ruleImportStmt EOF
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
    // InternalIvml.g:2533:1: ruleImportStmt returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) ;
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
            // InternalIvml.g:2536:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' ) )
            // InternalIvml.g:2537:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            {
            // InternalIvml.g:2537:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            // InternalIvml.g:2537:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )? (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0());
                  
            }
            // InternalIvml.g:2541:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2542:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2542:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2543:3: lv_name_1_0= ruleIdentifier
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

            // InternalIvml.g:2559:2: (otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==35) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalIvml.g:2559:4: otherlv_2= '::' ( (lv_interface_3_0= ruleIdentifier ) )
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2563:1: ( (lv_interface_3_0= ruleIdentifier ) )
                    // InternalIvml.g:2564:1: (lv_interface_3_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2564:1: (lv_interface_3_0= ruleIdentifier )
                    // InternalIvml.g:2565:3: lv_interface_3_0= ruleIdentifier
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

            // InternalIvml.g:2581:4: (otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalIvml.g:2581:6: otherlv_4= 'with' ( (lv_restriction_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImportStmtAccess().getWithKeyword_3_0());
                          
                    }
                    // InternalIvml.g:2585:1: ( (lv_restriction_5_0= ruleExpression ) )
                    // InternalIvml.g:2586:1: (lv_restriction_5_0= ruleExpression )
                    {
                    // InternalIvml.g:2586:1: (lv_restriction_5_0= ruleExpression )
                    // InternalIvml.g:2587:3: lv_restriction_5_0= ruleExpression
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
    // InternalIvml.g:2615:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // InternalIvml.g:2616:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // InternalIvml.g:2617:2: iv_ruleConflictStmt= ruleConflictStmt EOF
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
    // InternalIvml.g:2624:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2627:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // InternalIvml.g:2628:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:2628:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // InternalIvml.g:2628:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // InternalIvml.g:2632:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2633:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2633:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2634:3: lv_name_1_0= ruleIdentifier
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

            // InternalIvml.g:2650:2: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==28) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalIvml.g:2650:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2654:1: ( (lv_restriction_3_0= ruleExpression ) )
                    // InternalIvml.g:2655:1: (lv_restriction_3_0= ruleExpression )
                    {
                    // InternalIvml.g:2655:1: (lv_restriction_3_0= ruleExpression )
                    // InternalIvml.g:2656:3: lv_restriction_3_0= ruleExpression
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
    // InternalIvml.g:2684:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalIvml.g:2685:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalIvml.g:2686:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalIvml.g:2693:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:2696:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalIvml.g:2697:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalIvml.g:2697:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalIvml.g:2697:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // InternalIvml.g:2701:1: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalIvml.g:2702:1: (lv_version_1_0= RULE_VERSION )
            {
            // InternalIvml.g:2702:1: (lv_version_1_0= RULE_VERSION )
            // InternalIvml.g:2703:3: lv_version_1_0= RULE_VERSION
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
    // InternalIvml.g:2731:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // InternalIvml.g:2732:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // InternalIvml.g:2733:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
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
    // InternalIvml.g:2740:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) ) ;
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

        EObject lv_block_10_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2743:28: ( (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) ) )
            // InternalIvml.g:2744:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) )
            {
            // InternalIvml.g:2744:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:2744:3: otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // InternalIvml.g:2748:1: ( (lv_static_1_0= 'static' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==56) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalIvml.g:2749:1: (lv_static_1_0= 'static' )
                    {
                    // InternalIvml.g:2749:1: (lv_static_1_0= 'static' )
                    // InternalIvml.g:2750:3: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,56,FOLLOW_26); if (state.failed) return current;
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

            // InternalIvml.g:2763:3: ( (lv_result_2_0= ruleType ) )
            // InternalIvml.g:2764:1: (lv_result_2_0= ruleType )
            {
            // InternalIvml.g:2764:1: (lv_result_2_0= ruleType )
            // InternalIvml.g:2765:3: lv_result_2_0= ruleType
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

            // InternalIvml.g:2781:2: ( (lv_id_3_0= ruleIdentifier ) )
            // InternalIvml.g:2782:1: (lv_id_3_0= ruleIdentifier )
            {
            // InternalIvml.g:2782:1: (lv_id_3_0= ruleIdentifier )
            // InternalIvml.g:2783:3: lv_id_3_0= ruleIdentifier
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
            // InternalIvml.g:2803:1: ( (lv_param_5_0= ruleOpDefParameterList ) )
            // InternalIvml.g:2804:1: (lv_param_5_0= ruleOpDefParameterList )
            {
            // InternalIvml.g:2804:1: (lv_param_5_0= ruleOpDefParameterList )
            // InternalIvml.g:2805:3: lv_param_5_0= ruleOpDefParameterList
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
            // InternalIvml.g:2829:1: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // InternalIvml.g:2829:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
                    {
                    // InternalIvml.g:2829:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
                    // InternalIvml.g:2829:3: ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';'
                    {
                    // InternalIvml.g:2829:3: ( (lv_impl_8_0= ruleExpression ) )
                    // InternalIvml.g:2830:1: (lv_impl_8_0= ruleExpression )
                    {
                    // InternalIvml.g:2830:1: (lv_impl_8_0= ruleExpression )
                    // InternalIvml.g:2831:3: lv_impl_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_8_0_0_0()); 
                      	    
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

                          	newLeafNode(otherlv_9, grammarAccess.getOpDefStatementAccess().getSemicolonKeyword_8_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2852:6: ( (lv_block_10_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:2852:6: ( (lv_block_10_0= ruleBlockExpression ) )
                    // InternalIvml.g:2853:1: (lv_block_10_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:2853:1: (lv_block_10_0= ruleBlockExpression )
                    // InternalIvml.g:2854:3: lv_block_10_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getBlockBlockExpressionParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_10_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_10_0, 
                              		"de.uni_hildesheim.sse.Ivml.BlockExpression");
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
    // $ANTLR end "ruleOpDefStatement"


    // $ANTLR start "entryRuleOpDefParameterList"
    // InternalIvml.g:2878:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // InternalIvml.g:2879:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // InternalIvml.g:2880:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
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
    // InternalIvml.g:2887:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2890:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // InternalIvml.g:2891:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // InternalIvml.g:2891:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // InternalIvml.g:2891:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // InternalIvml.g:2891:2: ()
            // InternalIvml.g:2892:2: 
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

            // InternalIvml.g:2900:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_VERSION && LA49_0<=RULE_EXPONENT)||(LA49_0>=30 && LA49_0<=34)||(LA49_0>=41 && LA49_0<=43)||LA49_0==54) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalIvml.g:2900:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // InternalIvml.g:2900:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // InternalIvml.g:2901:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // InternalIvml.g:2901:1: (lv_list_1_0= ruleOpDefParameter )
                    // InternalIvml.g:2902:3: lv_list_1_0= ruleOpDefParameter
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

                    // InternalIvml.g:2918:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==18) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalIvml.g:2918:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // InternalIvml.g:2922:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // InternalIvml.g:2923:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // InternalIvml.g:2923:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // InternalIvml.g:2924:3: lv_list_3_0= ruleOpDefParameter
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
                    	    break loop48;
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
    // InternalIvml.g:2948:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // InternalIvml.g:2949:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // InternalIvml.g:2950:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
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
    // InternalIvml.g:2957:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2960:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:2961:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:2961:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // InternalIvml.g:2961:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:2961:2: ( (lv_type_0_0= ruleType ) )
            // InternalIvml.g:2962:1: (lv_type_0_0= ruleType )
            {
            // InternalIvml.g:2962:1: (lv_type_0_0= ruleType )
            // InternalIvml.g:2963:3: lv_type_0_0= ruleType
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

            // InternalIvml.g:2979:2: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:2980:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2980:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:2981:3: lv_id_1_0= ruleIdentifier
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

            // InternalIvml.g:2997:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==19) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalIvml.g:2997:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // InternalIvml.g:3001:1: ( (lv_val_3_0= ruleExpression ) )
                    // InternalIvml.g:3002:1: (lv_val_3_0= ruleExpression )
                    {
                    // InternalIvml.g:3002:1: (lv_val_3_0= ruleExpression )
                    // InternalIvml.g:3003:3: lv_val_3_0= ruleExpression
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
    // InternalIvml.g:3027:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalIvml.g:3028:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalIvml.g:3029:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalIvml.g:3036:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3039:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalIvml.g:3040:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalIvml.g:3040:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalIvml.g:3040:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalIvml.g:3040:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalIvml.g:3041:1: (lv_expr_0_0= ruleExpression )
            {
            // InternalIvml.g:3041:1: (lv_expr_0_0= ruleExpression )
            // InternalIvml.g:3042:3: lv_expr_0_0= ruleExpression
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
    // InternalIvml.g:3070:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalIvml.g:3071:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalIvml.g:3072:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalIvml.g:3079:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3082:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3083:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3083:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt51=3;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalIvml.g:3083:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // InternalIvml.g:3083:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // InternalIvml.g:3084:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // InternalIvml.g:3084:1: (lv_let_0_0= ruleLetExpression )
                    // InternalIvml.g:3085:3: lv_let_0_0= ruleLetExpression
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
                    // InternalIvml.g:3102:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:3102:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // InternalIvml.g:3103:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:3103:1: (lv_expr_1_0= ruleImplicationExpression )
                    // InternalIvml.g:3104:3: lv_expr_1_0= ruleImplicationExpression
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
                    // InternalIvml.g:3121:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3121:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3122:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3122:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3123:3: lv_collection_2_0= ruleCollectionInitializer
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
    // InternalIvml.g:3147:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // InternalIvml.g:3148:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // InternalIvml.g:3149:2: iv_ruleLetExpression= ruleLetExpression EOF
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
    // InternalIvml.g:3156:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) ;
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
            // InternalIvml.g:3159:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) )
            // InternalIvml.g:3160:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            {
            // InternalIvml.g:3160:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            // InternalIvml.g:3160:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // InternalIvml.g:3164:1: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:3165:1: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:3165:1: (lv_type_1_0= ruleType )
            // InternalIvml.g:3166:3: lv_type_1_0= ruleType
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

            // InternalIvml.g:3182:2: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:3183:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:3183:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:3184:3: lv_name_2_0= ruleIdentifier
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
            // InternalIvml.g:3204:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // InternalIvml.g:3205:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // InternalIvml.g:3205:1: (lv_valueExpr_4_0= ruleExpression )
            // InternalIvml.g:3206:3: lv_valueExpr_4_0= ruleExpression
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

            otherlv_5=(Token)match(input,58,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // InternalIvml.g:3226:1: ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            // InternalIvml.g:3227:1: (lv_subExpr_6_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:3227:1: (lv_subExpr_6_0= ruleOptBlockExpression )
            // InternalIvml.g:3228:3: lv_subExpr_6_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprOptBlockExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_subExpr_6_0=ruleOptBlockExpression();

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
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
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


    // $ANTLR start "entryRuleOptBlockExpression"
    // InternalIvml.g:3252:1: entryRuleOptBlockExpression returns [EObject current=null] : iv_ruleOptBlockExpression= ruleOptBlockExpression EOF ;
    public final EObject entryRuleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptBlockExpression = null;


        try {
            // InternalIvml.g:3253:2: (iv_ruleOptBlockExpression= ruleOptBlockExpression EOF )
            // InternalIvml.g:3254:2: iv_ruleOptBlockExpression= ruleOptBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptBlockExpression=ruleOptBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptBlockExpression; 
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
    // $ANTLR end "entryRuleOptBlockExpression"


    // $ANTLR start "ruleOptBlockExpression"
    // InternalIvml.g:3261:1: ruleOptBlockExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3264:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:3265:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            {
            // InternalIvml.g:3265:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalIvml.g:3265:2: ( (lv_expr_0_0= ruleExpression ) )
                    {
                    // InternalIvml.g:3265:2: ( (lv_expr_0_0= ruleExpression ) )
                    // InternalIvml.g:3266:1: (lv_expr_0_0= ruleExpression )
                    {
                    // InternalIvml.g:3266:1: (lv_expr_0_0= ruleExpression )
                    // InternalIvml.g:3267:3: lv_expr_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getExprExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_0_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOptBlockExpressionRule());
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


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3284:6: ( (lv_block_1_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:3284:6: ( (lv_block_1_0= ruleBlockExpression ) )
                    // InternalIvml.g:3285:1: (lv_block_1_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:3285:1: (lv_block_1_0= ruleBlockExpression )
                    // InternalIvml.g:3286:3: lv_block_1_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getBlockBlockExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_1_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOptBlockExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.BlockExpression");
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
    // $ANTLR end "ruleOptBlockExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalIvml.g:3310:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalIvml.g:3311:2: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalIvml.g:3312:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
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
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalIvml.g:3319:1: ruleBlockExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exprs_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3322:28: ( (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) )
            // InternalIvml.g:3323:1: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            {
            // InternalIvml.g:3323:1: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            // InternalIvml.g:3323:3: otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // InternalIvml.g:3327:1: ( (lv_exprs_1_0= ruleExpressionStatement ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=RULE_NUMBER && LA53_0<=RULE_EXPONENT)||LA53_0==14||LA53_0==24||(LA53_0>=37 && LA53_0<=40)||LA53_0==54||LA53_0==57||LA53_0==72||LA53_0==75||(LA53_0>=79 && LA53_0<=80)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalIvml.g:3328:1: (lv_exprs_1_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:3328:1: (lv_exprs_1_0= ruleExpressionStatement )
            	    // InternalIvml.g:3329:3: lv_exprs_1_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBlockExpressionAccess().getExprsExpressionStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_exprs_1_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exprs",
            	              		lv_exprs_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_2=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalIvml.g:3357:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalIvml.g:3358:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalIvml.g:3359:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalIvml.g:3366:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3369:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // InternalIvml.g:3370:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // InternalIvml.g:3370:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // InternalIvml.g:3370:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // InternalIvml.g:3370:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // InternalIvml.g:3371:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // InternalIvml.g:3371:1: (lv_left_0_0= ruleLogicalExpression )
            // InternalIvml.g:3372:3: lv_left_0_0= ruleLogicalExpression
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

            // InternalIvml.g:3388:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==19) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalIvml.g:3389:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // InternalIvml.g:3389:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // InternalIvml.g:3390:3: lv_right_1_0= ruleAssignmentExpressionPart
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
    // InternalIvml.g:3414:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // InternalIvml.g:3415:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // InternalIvml.g:3416:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
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
    // InternalIvml.g:3423:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3426:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:3427:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:3427:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3427:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3427:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // InternalIvml.g:3428:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // InternalIvml.g:3428:1: (lv_op_0_0= ruleAssignmentOperator )
            // InternalIvml.g:3429:3: lv_op_0_0= ruleAssignmentOperator
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

            // InternalIvml.g:3445:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalIvml.g:3445:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // InternalIvml.g:3445:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // InternalIvml.g:3446:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:3446:1: (lv_ex_1_0= ruleLogicalExpression )
                    // InternalIvml.g:3447:3: lv_ex_1_0= ruleLogicalExpression
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
                    // InternalIvml.g:3464:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3464:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3465:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3465:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3466:3: lv_collection_2_0= ruleCollectionInitializer
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
    // InternalIvml.g:3490:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // InternalIvml.g:3491:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalIvml.g:3492:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
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
    // InternalIvml.g:3499:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3502:28: (kw= '=' )
            // InternalIvml.g:3504:2: kw= '='
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
    // InternalIvml.g:3517:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // InternalIvml.g:3518:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // InternalIvml.g:3519:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
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
    // InternalIvml.g:3526:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3529:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // InternalIvml.g:3530:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // InternalIvml.g:3530:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // InternalIvml.g:3530:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // InternalIvml.g:3530:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3531:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3531:1: (lv_left_0_0= ruleAssignmentExpression )
            // InternalIvml.g:3532:3: lv_left_0_0= ruleAssignmentExpression
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

            // InternalIvml.g:3548:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=59 && LA56_0<=60)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalIvml.g:3549:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // InternalIvml.g:3549:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // InternalIvml.g:3550:3: lv_right_1_0= ruleImplicationExpressionPart
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
    // InternalIvml.g:3574:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // InternalIvml.g:3575:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // InternalIvml.g:3576:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
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
    // InternalIvml.g:3583:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3586:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // InternalIvml.g:3587:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // InternalIvml.g:3587:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // InternalIvml.g:3587:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // InternalIvml.g:3587:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // InternalIvml.g:3588:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // InternalIvml.g:3588:1: (lv_op_0_0= ruleImplicationOperator )
            // InternalIvml.g:3589:3: lv_op_0_0= ruleImplicationOperator
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

            // InternalIvml.g:3605:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3606:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3606:1: (lv_ex_1_0= ruleAssignmentExpression )
            // InternalIvml.g:3607:3: lv_ex_1_0= ruleAssignmentExpression
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
    // InternalIvml.g:3631:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // InternalIvml.g:3632:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // InternalIvml.g:3633:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
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
    // InternalIvml.g:3640:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3643:28: ( (kw= 'implies' | kw= 'iff' ) )
            // InternalIvml.g:3644:1: (kw= 'implies' | kw= 'iff' )
            {
            // InternalIvml.g:3644:1: (kw= 'implies' | kw= 'iff' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==59) ) {
                alt57=1;
            }
            else if ( (LA57_0==60) ) {
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
                    // InternalIvml.g:3645:2: kw= 'implies'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3652:2: kw= 'iff'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3665:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalIvml.g:3666:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalIvml.g:3667:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalIvml.g:3674:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3677:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalIvml.g:3678:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalIvml.g:3678:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalIvml.g:3678:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalIvml.g:3678:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalIvml.g:3679:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3679:1: (lv_left_0_0= ruleEqualityExpression )
            // InternalIvml.g:3680:3: lv_left_0_0= ruleEqualityExpression
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

            // InternalIvml.g:3696:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=61 && LA58_0<=63)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalIvml.g:3697:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalIvml.g:3697:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalIvml.g:3698:3: lv_right_1_0= ruleLogicalExpressionPart
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
    // InternalIvml.g:3722:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalIvml.g:3723:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalIvml.g:3724:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalIvml.g:3731:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3734:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalIvml.g:3735:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalIvml.g:3735:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalIvml.g:3735:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalIvml.g:3735:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalIvml.g:3736:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalIvml.g:3736:1: (lv_op_0_0= ruleLogicalOperator )
            // InternalIvml.g:3737:3: lv_op_0_0= ruleLogicalOperator
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

            // InternalIvml.g:3753:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalIvml.g:3754:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3754:1: (lv_ex_1_0= ruleEqualityExpression )
            // InternalIvml.g:3755:3: lv_ex_1_0= ruleEqualityExpression
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
    // InternalIvml.g:3779:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalIvml.g:3780:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalIvml.g:3781:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalIvml.g:3788:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3791:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // InternalIvml.g:3792:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // InternalIvml.g:3792:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt59=1;
                }
                break;
            case 62:
                {
                alt59=2;
                }
                break;
            case 63:
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
                    // InternalIvml.g:3793:2: kw= 'and'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3800:2: kw= 'or'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3807:2: kw= 'xor'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3820:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalIvml.g:3821:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalIvml.g:3822:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalIvml.g:3829:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3832:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalIvml.g:3833:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalIvml.g:3833:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalIvml.g:3833:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalIvml.g:3833:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalIvml.g:3834:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalIvml.g:3834:1: (lv_left_0_0= ruleRelationalExpression )
            // InternalIvml.g:3835:3: lv_left_0_0= ruleRelationalExpression
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

            // InternalIvml.g:3851:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=64 && LA60_0<=66)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalIvml.g:3852:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalIvml.g:3852:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalIvml.g:3853:3: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalIvml.g:3877:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalIvml.g:3878:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalIvml.g:3879:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalIvml.g:3886:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_collection_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3889:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:3890:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:3890:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:3890:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:3890:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalIvml.g:3891:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalIvml.g:3891:1: (lv_op_0_0= ruleEqualityOperator )
            // InternalIvml.g:3892:3: lv_op_0_0= ruleEqualityOperator
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

            // InternalIvml.g:3908:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalIvml.g:3908:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // InternalIvml.g:3908:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // InternalIvml.g:3909:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // InternalIvml.g:3909:1: (lv_ex_1_0= ruleRelationalExpression )
                    // InternalIvml.g:3910:3: lv_ex_1_0= ruleRelationalExpression
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
                    // InternalIvml.g:3927:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:3927:6: ( (lv_collection_2_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:3928:1: (lv_collection_2_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:3928:1: (lv_collection_2_0= ruleCollectionInitializer )
                    // InternalIvml.g:3929:3: lv_collection_2_0= ruleCollectionInitializer
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
    // InternalIvml.g:3953:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalIvml.g:3954:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalIvml.g:3955:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalIvml.g:3962:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3965:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalIvml.g:3966:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalIvml.g:3966:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt62=1;
                }
                break;
            case 65:
                {
                alt62=2;
                }
                break;
            case 66:
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
                    // InternalIvml.g:3967:2: kw= '=='
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3974:2: kw= '<>'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3981:2: kw= '!='
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3994:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalIvml.g:3995:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalIvml.g:3996:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalIvml.g:4003:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4006:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // InternalIvml.g:4007:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // InternalIvml.g:4007:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // InternalIvml.g:4007:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // InternalIvml.g:4007:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4008:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4008:1: (lv_left_0_0= ruleAdditiveExpression )
            // InternalIvml.g:4009:3: lv_left_0_0= ruleAdditiveExpression
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

            // InternalIvml.g:4025:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=67 && LA63_0<=70)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalIvml.g:4026:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalIvml.g:4026:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalIvml.g:4027:3: lv_right_1_0= ruleRelationalExpressionPart
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
    // InternalIvml.g:4051:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalIvml.g:4052:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalIvml.g:4053:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalIvml.g:4060:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4063:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalIvml.g:4064:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalIvml.g:4064:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalIvml.g:4064:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalIvml.g:4064:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalIvml.g:4065:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalIvml.g:4065:1: (lv_op_0_0= ruleRelationalOperator )
            // InternalIvml.g:4066:3: lv_op_0_0= ruleRelationalOperator
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

            // InternalIvml.g:4082:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4083:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4083:1: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalIvml.g:4084:3: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalIvml.g:4108:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalIvml.g:4109:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalIvml.g:4110:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalIvml.g:4117:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4120:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalIvml.g:4121:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalIvml.g:4121:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt64=1;
                }
                break;
            case 68:
                {
                alt64=2;
                }
                break;
            case 69:
                {
                alt64=3;
                }
                break;
            case 70:
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
                    // InternalIvml.g:4122:2: kw= '>'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4129:2: kw= '<'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4136:2: kw= '>='
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalIvml.g:4143:2: kw= '<='
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4156:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalIvml.g:4157:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalIvml.g:4158:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalIvml.g:4165:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4168:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalIvml.g:4169:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalIvml.g:4169:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalIvml.g:4169:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalIvml.g:4169:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4170:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4170:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4171:3: lv_left_0_0= ruleMultiplicativeExpression
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

            // InternalIvml.g:4187:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=71 && LA65_0<=72)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalIvml.g:4188:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalIvml.g:4188:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalIvml.g:4189:3: lv_right_1_0= ruleAdditiveExpressionPart
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
    // InternalIvml.g:4213:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalIvml.g:4214:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalIvml.g:4215:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalIvml.g:4222:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4225:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalIvml.g:4226:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalIvml.g:4226:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalIvml.g:4226:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalIvml.g:4226:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalIvml.g:4227:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalIvml.g:4227:1: (lv_op_0_0= ruleAdditiveOperator )
            // InternalIvml.g:4228:3: lv_op_0_0= ruleAdditiveOperator
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

            // InternalIvml.g:4244:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4245:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4245:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4246:3: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalIvml.g:4270:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalIvml.g:4271:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalIvml.g:4272:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalIvml.g:4279:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4282:28: ( (kw= '+' | kw= '-' ) )
            // InternalIvml.g:4283:1: (kw= '+' | kw= '-' )
            {
            // InternalIvml.g:4283:1: (kw= '+' | kw= '-' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==71) ) {
                alt66=1;
            }
            else if ( (LA66_0==72) ) {
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
                    // InternalIvml.g:4284:2: kw= '+'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4291:2: kw= '-'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4304:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalIvml.g:4305:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalIvml.g:4306:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalIvml.g:4313:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4316:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalIvml.g:4317:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalIvml.g:4317:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalIvml.g:4317:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalIvml.g:4317:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalIvml.g:4318:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4318:1: (lv_left_0_0= ruleUnaryExpression )
            // InternalIvml.g:4319:3: lv_left_0_0= ruleUnaryExpression
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

            // InternalIvml.g:4335:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=73 && LA67_0<=74)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalIvml.g:4336:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalIvml.g:4336:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalIvml.g:4337:3: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalIvml.g:4361:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalIvml.g:4362:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalIvml.g:4363:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalIvml.g:4370:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4373:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalIvml.g:4374:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalIvml.g:4374:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalIvml.g:4374:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalIvml.g:4374:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalIvml.g:4375:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalIvml.g:4375:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalIvml.g:4376:3: lv_op_0_0= ruleMultiplicativeOperator
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

            // InternalIvml.g:4392:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalIvml.g:4393:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4393:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalIvml.g:4394:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalIvml.g:4418:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalIvml.g:4419:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalIvml.g:4420:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalIvml.g:4427:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4430:28: ( (kw= '*' | kw= '/' ) )
            // InternalIvml.g:4431:1: (kw= '*' | kw= '/' )
            {
            // InternalIvml.g:4431:1: (kw= '*' | kw= '/' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==73) ) {
                alt68=1;
            }
            else if ( (LA68_0==74) ) {
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
                    // InternalIvml.g:4432:2: kw= '*'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4439:2: kw= '/'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4452:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalIvml.g:4453:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalIvml.g:4454:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalIvml.g:4461:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4464:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalIvml.g:4465:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalIvml.g:4465:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalIvml.g:4465:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalIvml.g:4465:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==72||LA69_0==75) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalIvml.g:4466:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalIvml.g:4466:1: (lv_op_0_0= ruleUnaryOperator )
                    // InternalIvml.g:4467:3: lv_op_0_0= ruleUnaryOperator
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

            // InternalIvml.g:4483:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalIvml.g:4484:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalIvml.g:4484:1: (lv_expr_1_0= rulePostfixExpression )
            // InternalIvml.g:4485:3: lv_expr_1_0= rulePostfixExpression
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
    // InternalIvml.g:4509:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalIvml.g:4510:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalIvml.g:4511:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalIvml.g:4518:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4521:28: ( (kw= 'not' | kw= '-' ) )
            // InternalIvml.g:4522:1: (kw= 'not' | kw= '-' )
            {
            // InternalIvml.g:4522:1: (kw= 'not' | kw= '-' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==75) ) {
                alt70=1;
            }
            else if ( (LA70_0==72) ) {
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
                    // InternalIvml.g:4523:2: kw= 'not'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4530:2: kw= '-'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4543:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalIvml.g:4544:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalIvml.g:4545:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalIvml.g:4552:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4555:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // InternalIvml.g:4556:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // InternalIvml.g:4556:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt73=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==EOF||(LA73_1>=15 && LA73_1<=16)||(LA73_1>=18 && LA73_1<=19)||(LA73_1>=25 && LA73_1<=26)||(LA73_1>=35 && LA73_1<=36)||LA73_1==48||(LA73_1>=58 && LA73_1<=74)||(LA73_1>=76 && LA73_1<=78)||(LA73_1>=81 && LA73_1<=83)) ) {
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

                if ( (LA73_2==EOF||(LA73_2>=15 && LA73_2<=16)||(LA73_2>=18 && LA73_2<=19)||(LA73_2>=25 && LA73_2<=26)||(LA73_2>=35 && LA73_2<=36)||LA73_2==48||(LA73_2>=58 && LA73_2<=74)||(LA73_2>=76 && LA73_2<=78)||(LA73_2>=81 && LA73_2<=83)) ) {
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

                if ( (LA73_3==EOF||(LA73_3>=15 && LA73_3<=16)||(LA73_3>=18 && LA73_3<=19)||(LA73_3>=25 && LA73_3<=26)||(LA73_3>=35 && LA73_3<=36)||LA73_3==48||(LA73_3>=58 && LA73_3<=74)||(LA73_3>=76 && LA73_3<=78)||(LA73_3>=81 && LA73_3<=83)) ) {
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
            case 54:
                {
                int LA73_4 = input.LA(2);

                if ( (LA73_4==24) ) {
                    alt73=1;
                }
                else if ( (LA73_4==EOF||(LA73_4>=15 && LA73_4<=16)||(LA73_4>=18 && LA73_4<=19)||(LA73_4>=25 && LA73_4<=26)||(LA73_4>=35 && LA73_4<=36)||LA73_4==48||(LA73_4>=58 && LA73_4<=74)||(LA73_4>=76 && LA73_4<=78)||(LA73_4>=81 && LA73_4<=83)) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_NUMBER:
            case RULE_STRING:
            case 24:
            case 37:
            case 38:
            case 39:
            case 40:
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
                    // InternalIvml.g:4556:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // InternalIvml.g:4556:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // InternalIvml.g:4556:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // InternalIvml.g:4556:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // InternalIvml.g:4557:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4557:1: (lv_call_0_0= ruleFeatureCall )
                    // InternalIvml.g:4558:3: lv_call_0_0= ruleFeatureCall
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

                    // InternalIvml.g:4574:2: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==36) ) {
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
                            case 54:
                                {
                                int LA71_7 = input.LA(3);

                                if ( (LA71_7==24) ) {
                                    alt71=1;
                                }


                                }
                                break;

                            }

                        }
                        else if ( ((LA71_0>=76 && LA71_0<=77)) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalIvml.g:4575:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // InternalIvml.g:4575:1: (lv_fCalls_1_0= ruleCall )
                    	    // InternalIvml.g:4576:3: lv_fCalls_1_0= ruleCall
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
                    	    break loop71;
                        }
                    } while (true);

                    // InternalIvml.g:4592:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==36) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalIvml.g:4593:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // InternalIvml.g:4593:1: (lv_access_2_0= ruleExpressionAccess )
                            // InternalIvml.g:4594:3: lv_access_2_0= ruleExpressionAccess
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
                    // InternalIvml.g:4611:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // InternalIvml.g:4611:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // InternalIvml.g:4612:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // InternalIvml.g:4612:1: (lv_left_3_0= rulePrimaryExpression )
                    // InternalIvml.g:4613:3: lv_left_3_0= rulePrimaryExpression
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
    // InternalIvml.g:4637:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalIvml.g:4638:2: (iv_ruleCall= ruleCall EOF )
            // InternalIvml.g:4639:2: iv_ruleCall= ruleCall EOF
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
    // InternalIvml.g:4646:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
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
            // InternalIvml.g:4649:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // InternalIvml.g:4650:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // InternalIvml.g:4650:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt74=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt74=1;
                }
                break;
            case 76:
                {
                alt74=2;
                }
                break;
            case 77:
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
                    // InternalIvml.g:4650:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // InternalIvml.g:4650:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // InternalIvml.g:4650:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // InternalIvml.g:4654:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // InternalIvml.g:4655:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4655:1: (lv_call_1_0= ruleFeatureCall )
                    // InternalIvml.g:4656:3: lv_call_1_0= ruleFeatureCall
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
                    // InternalIvml.g:4673:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    {
                    // InternalIvml.g:4673:6: (otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) ) )
                    // InternalIvml.g:4673:8: otherlv_2= '->' ( (lv_setOp_3_0= ruleSetOp ) )
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:4677:1: ( (lv_setOp_3_0= ruleSetOp ) )
                    // InternalIvml.g:4678:1: (lv_setOp_3_0= ruleSetOp )
                    {
                    // InternalIvml.g:4678:1: (lv_setOp_3_0= ruleSetOp )
                    // InternalIvml.g:4679:3: lv_setOp_3_0= ruleSetOp
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
                    // InternalIvml.g:4696:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // InternalIvml.g:4696:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // InternalIvml.g:4696:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,77,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalIvml.g:4700:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // InternalIvml.g:4701:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // InternalIvml.g:4701:1: (lv_arrayEx_5_0= ruleExpression )
                    // InternalIvml.g:4702:3: lv_arrayEx_5_0= ruleExpression
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

                    otherlv_6=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4730:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalIvml.g:4731:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalIvml.g:4732:2: iv_ruleFeatureCall= ruleFeatureCall EOF
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
    // InternalIvml.g:4739:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4742:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' ) )
            // InternalIvml.g:4743:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            {
            // InternalIvml.g:4743:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')' )
            // InternalIvml.g:4743:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_param_2_0= ruleActualParameterList ) )? otherlv_3= ')'
            {
            // InternalIvml.g:4743:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:4744:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:4744:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:4745:3: lv_name_0_0= ruleIdentifier
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
            // InternalIvml.g:4765:1: ( (lv_param_2_0= ruleActualParameterList ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_NUMBER && LA75_0<=RULE_EXPONENT)||LA75_0==14||LA75_0==24||(LA75_0>=37 && LA75_0<=40)||LA75_0==54||LA75_0==57||LA75_0==72||LA75_0==75||(LA75_0>=79 && LA75_0<=80)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalIvml.g:4766:1: (lv_param_2_0= ruleActualParameterList )
                    {
                    // InternalIvml.g:4766:1: (lv_param_2_0= ruleActualParameterList )
                    // InternalIvml.g:4767:3: lv_param_2_0= ruleActualParameterList
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
    // InternalIvml.g:4795:1: entryRuleSetOp returns [EObject current=null] : iv_ruleSetOp= ruleSetOp EOF ;
    public final EObject entryRuleSetOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOp = null;


        try {
            // InternalIvml.g:4796:2: (iv_ruleSetOp= ruleSetOp EOF )
            // InternalIvml.g:4797:2: iv_ruleSetOp= ruleSetOp EOF
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
    // InternalIvml.g:4804:1: ruleSetOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_declEx_3_0= ruleActualParameterList ) )? otherlv_4= ')' ) ;
    public final EObject ruleSetOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_declEx_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4807:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_declEx_3_0= ruleActualParameterList ) )? otherlv_4= ')' ) )
            // InternalIvml.g:4808:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_declEx_3_0= ruleActualParameterList ) )? otherlv_4= ')' )
            {
            // InternalIvml.g:4808:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_declEx_3_0= ruleActualParameterList ) )? otherlv_4= ')' )
            // InternalIvml.g:4808:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_declEx_3_0= ruleActualParameterList ) )? otherlv_4= ')'
            {
            // InternalIvml.g:4808:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:4809:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:4809:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:4810:3: lv_name_0_0= ruleIdentifier
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

            otherlv_1=(Token)match(input,24,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:4830:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt76=2;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalIvml.g:4831:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalIvml.g:4831:1: (lv_decl_2_0= ruleDeclarator )
                    // InternalIvml.g:4832:3: lv_decl_2_0= ruleDeclarator
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
                    break;

            }

            // InternalIvml.g:4848:3: ( (lv_declEx_3_0= ruleActualParameterList ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_NUMBER && LA77_0<=RULE_EXPONENT)||LA77_0==14||LA77_0==24||(LA77_0>=37 && LA77_0<=40)||LA77_0==54||LA77_0==57||LA77_0==72||LA77_0==75||(LA77_0>=79 && LA77_0<=80)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalIvml.g:4849:1: (lv_declEx_3_0= ruleActualParameterList )
                    {
                    // InternalIvml.g:4849:1: (lv_declEx_3_0= ruleActualParameterList )
                    // InternalIvml.g:4850:3: lv_declEx_3_0= ruleActualParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclExActualParameterListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_28);
                    lv_declEx_3_0=ruleActualParameterList();

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
                              		"de.uni_hildesheim.sse.Ivml.ActualParameterList");
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
    // InternalIvml.g:4878:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalIvml.g:4879:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalIvml.g:4880:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalIvml.g:4887:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4890:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalIvml.g:4891:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalIvml.g:4891:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalIvml.g:4891:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalIvml.g:4891:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalIvml.g:4892:1: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalIvml.g:4892:1: (lv_decl_0_0= ruleDeclaration )
            // InternalIvml.g:4893:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_55);
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

            // InternalIvml.g:4909:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==16) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalIvml.g:4909:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:4913:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalIvml.g:4914:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalIvml.g:4914:1: (lv_decl_2_0= ruleDeclaration )
            	    // InternalIvml.g:4915:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop78;
                }
            } while (true);

            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4943:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalIvml.g:4944:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalIvml.g:4945:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalIvml.g:4952:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
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
            // InternalIvml.g:4955:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:4956:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:4956:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // InternalIvml.g:4956:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:4956:2: ( (lv_type_0_0= ruleType ) )?
            int alt79=2;
            switch ( input.LA(1) ) {
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 41:
                case 42:
                case 43:
                    {
                    alt79=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA79_2 = input.LA(2);

                    if ( ((LA79_2>=RULE_VERSION && LA79_2<=RULE_EXPONENT)||LA79_2==35||LA79_2==54) ) {
                        alt79=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA79_3 = input.LA(2);

                    if ( ((LA79_3>=RULE_VERSION && LA79_3<=RULE_EXPONENT)||LA79_3==35||LA79_3==54) ) {
                        alt79=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA79_4 = input.LA(2);

                    if ( ((LA79_4>=RULE_VERSION && LA79_4<=RULE_EXPONENT)||LA79_4==35||LA79_4==54) ) {
                        alt79=1;
                    }
                    }
                    break;
                case 54:
                    {
                    int LA79_5 = input.LA(2);

                    if ( ((LA79_5>=RULE_VERSION && LA79_5<=RULE_EXPONENT)||LA79_5==35||LA79_5==54) ) {
                        alt79=1;
                    }
                    }
                    break;
            }

            switch (alt79) {
                case 1 :
                    // InternalIvml.g:4957:1: (lv_type_0_0= ruleType )
                    {
                    // InternalIvml.g:4957:1: (lv_type_0_0= ruleType )
                    // InternalIvml.g:4958:3: lv_type_0_0= ruleType
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

            // InternalIvml.g:4974:3: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:4975:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:4975:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:4976:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_56);
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

            // InternalIvml.g:4992:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==18) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalIvml.g:4992:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:4996:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // InternalIvml.g:4997:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:4997:1: (lv_id_3_0= ruleIdentifier )
            	    // InternalIvml.g:4998:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop80;
                }
            } while (true);

            // InternalIvml.g:5014:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==19) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalIvml.g:5014:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalIvml.g:5018:1: ( (lv_init_5_0= ruleExpression ) )
                    // InternalIvml.g:5019:1: (lv_init_5_0= ruleExpression )
                    {
                    // InternalIvml.g:5019:1: (lv_init_5_0= ruleExpression )
                    // InternalIvml.g:5020:3: lv_init_5_0= ruleExpression
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
    // InternalIvml.g:5044:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // InternalIvml.g:5045:2: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // InternalIvml.g:5046:2: iv_ruleActualParameterList= ruleActualParameterList EOF
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
    // InternalIvml.g:5053:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5056:28: ( ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* ) )
            // InternalIvml.g:5057:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            {
            // InternalIvml.g:5057:1: ( ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )* )
            // InternalIvml.g:5057:2: ( (lv_param_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            {
            // InternalIvml.g:5057:2: ( (lv_param_0_0= ruleExpression ) )
            // InternalIvml.g:5058:1: (lv_param_0_0= ruleExpression )
            {
            // InternalIvml.g:5058:1: (lv_param_0_0= ruleExpression )
            // InternalIvml.g:5059:3: lv_param_0_0= ruleExpression
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

            // InternalIvml.g:5075:2: (otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==18) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalIvml.g:5075:4: otherlv_1= ',' ( (lv_param_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5079:1: ( (lv_param_2_0= ruleExpression ) )
            	    // InternalIvml.g:5080:1: (lv_param_2_0= ruleExpression )
            	    {
            	    // InternalIvml.g:5080:1: (lv_param_2_0= ruleExpression )
            	    // InternalIvml.g:5081:3: lv_param_2_0= ruleExpression
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
            	    break loop82;
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
    // InternalIvml.g:5105:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // InternalIvml.g:5106:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // InternalIvml.g:5107:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
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
    // InternalIvml.g:5114:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5117:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5118:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5118:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5118:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // InternalIvml.g:5122:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:5123:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:5123:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:5124:3: lv_name_1_0= ruleIdentifier
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

            // InternalIvml.g:5140:2: ( (lv_calls_2_0= ruleCall ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==36) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA83_4 = input.LA(3);

                        if ( (LA83_4==24) ) {
                            alt83=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA83_5 = input.LA(3);

                        if ( (LA83_5==24) ) {
                            alt83=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA83_6 = input.LA(3);

                        if ( (LA83_6==24) ) {
                            alt83=1;
                        }


                        }
                        break;
                    case 54:
                        {
                        int LA83_7 = input.LA(3);

                        if ( (LA83_7==24) ) {
                            alt83=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA83_0>=76 && LA83_0<=77)) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalIvml.g:5141:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // InternalIvml.g:5141:1: (lv_calls_2_0= ruleCall )
            	    // InternalIvml.g:5142:3: lv_calls_2_0= ruleCall
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
            	    break loop83;
                }
            } while (true);

            // InternalIvml.g:5158:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==36) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalIvml.g:5159:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5159:1: (lv_access_3_0= ruleExpressionAccess )
                    // InternalIvml.g:5160:3: lv_access_3_0= ruleExpressionAccess
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
    // InternalIvml.g:5184:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalIvml.g:5185:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalIvml.g:5186:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalIvml.g:5193:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
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
            // InternalIvml.g:5196:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5197:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5197:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5197:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // InternalIvml.g:5197:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) )
            int alt85=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case RULE_STRING:
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 37:
            case 38:
            case 39:
            case 40:
            case 54:
                {
                alt85=1;
                }
                break;
            case 24:
                {
                alt85=2;
                }
                break;
            case 80:
                {
                alt85=3;
                }
                break;
            case 79:
                {
                alt85=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalIvml.g:5197:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // InternalIvml.g:5197:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // InternalIvml.g:5198:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // InternalIvml.g:5198:1: (lv_lit_0_0= ruleLiteral )
                    // InternalIvml.g:5199:3: lv_lit_0_0= ruleLiteral
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
                    // InternalIvml.g:5216:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalIvml.g:5216:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalIvml.g:5216:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // InternalIvml.g:5220:1: ( (lv_ex_2_0= ruleExpression ) )
                    // InternalIvml.g:5221:1: (lv_ex_2_0= ruleExpression )
                    {
                    // InternalIvml.g:5221:1: (lv_ex_2_0= ruleExpression )
                    // InternalIvml.g:5222:3: lv_ex_2_0= ruleExpression
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
                    // InternalIvml.g:5243:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // InternalIvml.g:5243:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // InternalIvml.g:5244:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // InternalIvml.g:5244:1: (lv_ifEx_4_0= ruleIfExpression )
                    // InternalIvml.g:5245:3: lv_ifEx_4_0= ruleIfExpression
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
                    // InternalIvml.g:5262:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalIvml.g:5262:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalIvml.g:5262:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,79,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // InternalIvml.g:5270:1: ( (lv_refEx_7_0= ruleExpression ) )
                    // InternalIvml.g:5271:1: (lv_refEx_7_0= ruleExpression )
                    {
                    // InternalIvml.g:5271:1: (lv_refEx_7_0= ruleExpression )
                    // InternalIvml.g:5272:3: lv_refEx_7_0= ruleExpression
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

            // InternalIvml.g:5292:3: ( (lv_calls_9_0= ruleCall ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==36) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA86_4 = input.LA(3);

                        if ( (LA86_4==24) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA86_5 = input.LA(3);

                        if ( (LA86_5==24) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA86_6 = input.LA(3);

                        if ( (LA86_6==24) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case 54:
                        {
                        int LA86_7 = input.LA(3);

                        if ( (LA86_7==24) ) {
                            alt86=1;
                        }


                        }
                        break;

                    }

                }
                else if ( ((LA86_0>=76 && LA86_0<=77)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalIvml.g:5293:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // InternalIvml.g:5293:1: (lv_calls_9_0= ruleCall )
            	    // InternalIvml.g:5294:3: lv_calls_9_0= ruleCall
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
            	    break loop86;
                }
            } while (true);

            // InternalIvml.g:5310:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==36) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalIvml.g:5311:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5311:1: (lv_access_10_0= ruleExpressionAccess )
                    // InternalIvml.g:5312:3: lv_access_10_0= ruleExpressionAccess
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
    // InternalIvml.g:5336:1: entryRuleCollectionInitializer returns [EObject current=null] : iv_ruleCollectionInitializer= ruleCollectionInitializer EOF ;
    public final EObject entryRuleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionInitializer = null;


        try {
            // InternalIvml.g:5337:2: (iv_ruleCollectionInitializer= ruleCollectionInitializer EOF )
            // InternalIvml.g:5338:2: iv_ruleCollectionInitializer= ruleCollectionInitializer EOF
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
    // InternalIvml.g:5345:1: ruleCollectionInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleCollectionInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5348:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // InternalIvml.g:5349:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // InternalIvml.g:5349:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // InternalIvml.g:5349:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // InternalIvml.g:5349:2: ()
            // InternalIvml.g:5350:2: 
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

            // InternalIvml.g:5358:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=RULE_VERSION && LA88_0<=RULE_EXPONENT)||LA88_0==54) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalIvml.g:5359:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:5359:1: (lv_type_1_0= ruleQualifiedName )
                    // InternalIvml.g:5360:3: lv_type_1_0= ruleQualifiedName
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
            // InternalIvml.g:5380:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=RULE_NUMBER && LA89_0<=RULE_EXPONENT)||LA89_0==14||LA89_0==24||(LA89_0>=37 && LA89_0<=40)||LA89_0==54||LA89_0==72||LA89_0==75||(LA89_0>=79 && LA89_0<=80)) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalIvml.g:5381:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // InternalIvml.g:5381:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // InternalIvml.g:5382:3: lv_init_3_0= ruleExpressionListOrRange
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
    // InternalIvml.g:5410:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // InternalIvml.g:5411:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // InternalIvml.g:5412:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
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
    // InternalIvml.g:5419:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5422:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // InternalIvml.g:5423:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // InternalIvml.g:5423:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // InternalIvml.g:5423:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // InternalIvml.g:5423:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // InternalIvml.g:5424:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // InternalIvml.g:5424:1: (lv_list_0_0= ruleExpressionListEntry )
            // InternalIvml.g:5425:3: lv_list_0_0= ruleExpressionListEntry
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

            // InternalIvml.g:5441:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==18) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalIvml.g:5441:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5445:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // InternalIvml.g:5446:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // InternalIvml.g:5446:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // InternalIvml.g:5447:3: lv_list_2_0= ruleExpressionListEntry
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
            	    break loop90;
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
    // InternalIvml.g:5471:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // InternalIvml.g:5472:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // InternalIvml.g:5473:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
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
    // InternalIvml.g:5480:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) ;
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
            // InternalIvml.g:5483:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) ) )
            // InternalIvml.g:5484:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            {
            // InternalIvml.g:5484:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) ) )
            // InternalIvml.g:5484:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            {
            // InternalIvml.g:5484:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt92=2;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // InternalIvml.g:5484:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // InternalIvml.g:5484:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5485:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5485:1: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5486:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_57);
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

                    // InternalIvml.g:5502:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==36) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalIvml.g:5502:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // InternalIvml.g:5506:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // InternalIvml.g:5507:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // InternalIvml.g:5507:1: (lv_attrib_2_0= ruleIdentifier )
                            // InternalIvml.g:5508:3: lv_attrib_2_0= ruleIdentifier
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

            // InternalIvml.g:5528:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )
            int alt93=2;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // InternalIvml.g:5528:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:5528:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    // InternalIvml.g:5529:1: (lv_value_4_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:5529:1: (lv_value_4_0= ruleImplicationExpression )
                    // InternalIvml.g:5530:3: lv_value_4_0= ruleImplicationExpression
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
                    // InternalIvml.g:5547:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    {
                    // InternalIvml.g:5547:6: ( (lv_collection_5_0= ruleCollectionInitializer ) )
                    // InternalIvml.g:5548:1: (lv_collection_5_0= ruleCollectionInitializer )
                    {
                    // InternalIvml.g:5548:1: (lv_collection_5_0= ruleCollectionInitializer )
                    // InternalIvml.g:5549:3: lv_collection_5_0= ruleCollectionInitializer
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
    // InternalIvml.g:5573:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalIvml.g:5574:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalIvml.g:5575:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalIvml.g:5582:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5585:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // InternalIvml.g:5586:1: ( (lv_val_0_0= ruleValue ) )
            {
            // InternalIvml.g:5586:1: ( (lv_val_0_0= ruleValue ) )
            // InternalIvml.g:5587:1: (lv_val_0_0= ruleValue )
            {
            // InternalIvml.g:5587:1: (lv_val_0_0= ruleValue )
            // InternalIvml.g:5588:3: lv_val_0_0= ruleValue
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
    // InternalIvml.g:5612:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalIvml.g:5613:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalIvml.g:5614:2: iv_ruleIfExpression= ruleIfExpression EOF
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
    // InternalIvml.g:5621:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) ;
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
            // InternalIvml.g:5624:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) )
            // InternalIvml.g:5625:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            {
            // InternalIvml.g:5625:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            // InternalIvml.g:5625:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // InternalIvml.g:5629:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // InternalIvml.g:5630:1: (lv_ifEx_1_0= ruleExpression )
            {
            // InternalIvml.g:5630:1: (lv_ifEx_1_0= ruleExpression )
            // InternalIvml.g:5631:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_58);
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

            otherlv_2=(Token)match(input,81,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // InternalIvml.g:5651:1: ( (lv_thenEx_3_0= ruleOptBlockExpression ) )
            // InternalIvml.g:5652:1: (lv_thenEx_3_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:5652:1: (lv_thenEx_3_0= ruleOptBlockExpression )
            // InternalIvml.g:5653:3: lv_thenEx_3_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExOptBlockExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
            lv_thenEx_3_0=ruleOptBlockExpression();

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
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,82,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // InternalIvml.g:5673:1: ( (lv_elseEx_5_0= ruleOptBlockExpression ) )
            // InternalIvml.g:5674:1: (lv_elseEx_5_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:5674:1: (lv_elseEx_5_0= ruleOptBlockExpression )
            // InternalIvml.g:5675:3: lv_elseEx_5_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExOptBlockExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_60);
            lv_elseEx_5_0=ruleOptBlockExpression();

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
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:5703:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalIvml.g:5704:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalIvml.g:5705:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalIvml.g:5712:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:5715:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalIvml.g:5716:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalIvml.g:5716:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt94=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt94=1;
                }
                break;
            case RULE_VERSION:
                {
                alt94=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt94=3;
                }
                break;
            case 54:
                {
                alt94=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // InternalIvml.g:5716:6: this_ID_0= RULE_ID
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
                    // InternalIvml.g:5724:10: this_VERSION_1= RULE_VERSION
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
                    // InternalIvml.g:5732:10: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalIvml.g:5741:2: kw= 'version'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred47_InternalIvml
    public final void synpred47_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalIvml.g:1790:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalIvml.g:1790:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalIvml.g:1790:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalIvml.g:1791:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalIvml.g:1791:1: (lv_qValue_2_0= ruleQualifiedName )
        // InternalIvml.g:1792:3: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred47_InternalIvml

    // $ANTLR start synpred52_InternalIvml
    public final void synpred52_InternalIvml_fragment() throws RecognitionException {   
        // InternalIvml.g:1872:7: ( ( RULE_VERSION ) )
        // InternalIvml.g:1873:1: ( RULE_VERSION )
        {
        // InternalIvml.g:1873:1: ( RULE_VERSION )
        // InternalIvml.g:1874:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred52_InternalIvml

    // $ANTLR start synpred71_InternalIvml
    public final void synpred71_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        EObject lv_impl_8_0 = null;


        // InternalIvml.g:2829:2: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // InternalIvml.g:2829:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        // InternalIvml.g:2829:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
        // InternalIvml.g:2829:3: ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        // InternalIvml.g:2829:3: ( (lv_impl_8_0= ruleExpression ) )
        // InternalIvml.g:2830:1: (lv_impl_8_0= ruleExpression )
        {
        // InternalIvml.g:2830:1: (lv_impl_8_0= ruleExpression )
        // InternalIvml.g:2831:3: lv_impl_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_8_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_14);
        lv_impl_8_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred71_InternalIvml

    // $ANTLR start synpred77_InternalIvml
    public final void synpred77_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_expr_0_0 = null;


        // InternalIvml.g:3265:2: ( ( (lv_expr_0_0= ruleExpression ) ) )
        // InternalIvml.g:3265:2: ( (lv_expr_0_0= ruleExpression ) )
        {
        // InternalIvml.g:3265:2: ( (lv_expr_0_0= ruleExpression ) )
        // InternalIvml.g:3266:1: (lv_expr_0_0= ruleExpression )
        {
        // InternalIvml.g:3266:1: (lv_expr_0_0= ruleExpression )
        // InternalIvml.g:3267:3: lv_expr_0_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getExprExpressionParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_expr_0_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred77_InternalIvml

    // $ANTLR start synpred106_InternalIvml
    public final void synpred106_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalIvml.g:4831:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalIvml.g:4831:1: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalIvml.g:4831:1: (lv_decl_2_0= ruleDeclarator )
        // InternalIvml.g:4832:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getSetOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred106_InternalIvml

    // $ANTLR start synpred124_InternalIvml
    public final void synpred124_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;


        // InternalIvml.g:5484:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )
        // InternalIvml.g:5484:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
        {
        // InternalIvml.g:5484:3: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5485:1: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5485:1: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5486:3: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_57);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalIvml.g:5502:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( (LA100_0==36) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // InternalIvml.g:5502:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                {
                otherlv_1=(Token)match(input,36,FOLLOW_4); if (state.failed) return ;
                // InternalIvml.g:5506:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                // InternalIvml.g:5507:1: (lv_attrib_2_0= ruleIdentifier )
                {
                // InternalIvml.g:5507:1: (lv_attrib_2_0= ruleIdentifier )
                // InternalIvml.g:5508:3: lv_attrib_2_0= ruleIdentifier
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
    // $ANTLR end synpred124_InternalIvml

    // Delegated rules

    public final boolean synpred71_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalIvml_fragment(); // can never throw exception
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
    public final boolean synpred77_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_InternalIvml_fragment(); // can never throw exception
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
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA93 dfa93 = new DFA93(this);
    static final String dfa_1s = "\24\uffff";
    static final String dfa_2s = "\1\1\23\uffff";
    static final String dfa_3s = "\1\4\3\uffff\4\6\6\uffff\6\6";
    static final String dfa_4s = "\1\120\3\uffff\4\115\6\uffff\1\66\4\115\1\66";
    static final String dfa_5s = "\1\uffff\1\11\1\1\1\2\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\6\uffff";
    static final String dfa_6s = "\24\uffff}>";
    static final String[] dfa_7s = {
            "\2\12\1\5\1\4\1\6\5\uffff\1\12\1\1\1\uffff\1\2\2\uffff\2\2\1\uffff\1\15\1\12\2\uffff\1\2\1\uffff\6\3\2\uffff\4\12\3\3\2\13\1\10\2\uffff\1\11\4\uffff\1\7\1\14\1\uffff\1\12\16\uffff\1\12\2\uffff\1\12\3\uffff\2\12",
            "",
            "",
            "",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\12\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\12\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\12\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\12\uffff\1\16\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\17\1\21\55\uffff\1\22",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\17\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\17\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\17\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\3\3\5\uffff\1\12\1\uffff\1\12\2\uffff\1\12\17\uffff\1\23\1\12\21\uffff\1\3\4\uffff\20\12\1\uffff\2\12",
            "\1\20\1\17\1\21\55\uffff\1\22"
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
    static final String dfa_10s = "\1\120\2\uffff\4\115\3\uffff\1\66\4\115\1\66";
    static final String dfa_11s = "\1\uffff\1\5\1\1\4\uffff\1\2\1\3\1\4\6\uffff";
    static final String dfa_12s = "\20\uffff}>";
    static final String[] dfa_13s = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\6\2\2\uffff\4\7\3\2\5\uffff\1\11\4\uffff\1\6\2\uffff\1\7\16\uffff\1\7\2\uffff\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\12\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "",
            "\1\14\1\13\1\15\55\uffff\1\16",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\17\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\1\14\1\13\1\15\55\uffff\1\16"
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
    static final String dfa_16s = "\1\120\2\uffff\4\115\2\uffff\1\66\4\115\1\66";
    static final String dfa_17s = "\1\uffff\1\4\1\1\4\uffff\1\2\1\3\6\uffff";
    static final String dfa_18s = "\17\uffff}>";
    static final String[] dfa_19s = {
            "\2\7\1\4\1\3\1\5\5\uffff\1\7\1\1\7\uffff\1\10\1\7\4\uffff\6\2\2\uffff\4\7\3\2\12\uffff\1\6\2\uffff\1\7\16\uffff\1\7\2\uffff\1\7\3\uffff\2\7",
            "",
            "",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\4\uffff\1\7\12\uffff\1\11\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "",
            "",
            "\1\13\1\12\1\14\55\uffff\1\15",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\3\2\5\uffff\1\7\1\uffff\1\7\2\uffff\1\7\17\uffff\1\16\1\7\21\uffff\1\2\4\uffff\20\7\1\uffff\2\7",
            "\1\13\1\12\1\14\55\uffff\1\15"
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
    static final String dfa_20s = "\23\uffff";
    static final String dfa_21s = "\1\4\20\uffff\1\0\1\uffff";
    static final String dfa_22s = "\1\120\20\uffff\1\0\1\uffff";
    static final String dfa_23s = "\1\uffff\1\1\20\uffff\1\2";
    static final String dfa_24s = "\21\uffff\1\0\1\uffff}>";
    static final String[] dfa_25s = {
            "\5\1\5\uffff\1\21\11\uffff\1\1\14\uffff\4\1\15\uffff\1\1\2\uffff\1\1\16\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
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
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "2829:1: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_17 = input.LA(1);

                         
                        int index47_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index47_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_26s = "\16\uffff";
    static final String dfa_27s = "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String dfa_28s = "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_29s = "\1\120\2\uffff\4\123\1\uffff\1\66\4\123\1\66";
    static final String dfa_30s = "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String dfa_31s = "\16\uffff}>";
    static final String[] dfa_32s = {
            "\2\2\1\4\1\3\1\5\5\uffff\1\7\11\uffff\1\2\14\uffff\4\2\15\uffff\1\6\2\uffff\1\1\16\uffff\1\2\2\uffff\1\2\3\uffff\2\2",
            "",
            "",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\10\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\10\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\10\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\10\uffff\1\10\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "",
            "\1\12\1\11\1\13\55\uffff\1\14",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\10\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\10\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\10\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\10\uffff\1\15\1\2\13\uffff\1\2\11\uffff\21\2\1\uffff\3\2\2\uffff\3\2",
            "\1\12\1\11\1\13\55\uffff\1\14"
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_26;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "3083:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "3265:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_17 = input.LA(1);

                         
                        int index52_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index52_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_33s = "\15\uffff";
    static final String dfa_34s = "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String dfa_35s = "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_36s = "\1\120\1\uffff\4\123\1\uffff\1\66\4\123\1\66";
    static final String dfa_37s = "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String dfa_38s = "\15\uffff}>";
    static final String[] dfa_39s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\14\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\55\uffff\1\13",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\21\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\55\uffff\1\13"
    };

    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_33;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "3445:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String[] dfa_40s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\14\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\10\uffff\1\7\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\55\uffff\1\13",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\10\uffff\1\14\1\1\13\uffff\1\1\11\uffff\6\1\3\uffff\10\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\55\uffff\1\13"
    };
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_33;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "3908:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_collection_2_0= ruleCollectionInitializer ) ) )";
        }
    }
    static final String dfa_41s = "\33\uffff";
    static final String dfa_42s = "\1\4\5\uffff\4\0\21\uffff";
    static final String dfa_43s = "\1\120\5\uffff\4\0\21\uffff";
    static final String dfa_44s = "\1\uffff\1\1\13\uffff\1\2\15\uffff";
    static final String dfa_45s = "\6\uffff\1\0\1\1\1\2\1\3\21\uffff}>";
    static final String[] dfa_46s = {
            "\2\15\1\7\1\6\1\10\5\uffff\1\15\11\uffff\2\15\4\uffff\5\1\2\uffff\4\15\3\1\12\uffff\1\11\2\uffff\1\15\16\uffff\1\15\2\uffff\1\15\3\uffff\2\15",
            "",
            "",
            "",
            "",
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
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_41;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "4830:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_6 = input.LA(1);

                         
                        int index76_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index76_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA76_7 = input.LA(1);

                         
                        int index76_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index76_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA76_8 = input.LA(1);

                         
                        int index76_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index76_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA76_9 = input.LA(1);

                         
                        int index76_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index76_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_47s = "\22\uffff";
    static final String dfa_48s = "\1\4\4\0\15\uffff";
    static final String dfa_49s = "\1\120\4\0\15\uffff";
    static final String dfa_50s = "\5\uffff\1\2\13\uffff\1\1";
    static final String dfa_51s = "\1\uffff\1\0\1\1\1\2\1\3\15\uffff}>";
    static final String[] dfa_52s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\14\uffff\4\5\15\uffff\1\4\21\uffff\1\5\2\uffff\1\5\3\uffff\2\5",
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

    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = dfa_47;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "5484:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA92_1 = input.LA(1);

                         
                        int index92_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_2 = input.LA(1);

                         
                        int index92_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_3 = input.LA(1);

                         
                        int index92_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_4 = input.LA(1);

                         
                        int index92_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 17;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 92, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_53s = "\1\120\1\uffff\4\115\1\uffff\1\66\4\115\1\66";
    static final String[] dfa_54s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\14\uffff\4\1\15\uffff\1\5\21\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\12\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\12\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\12\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\12\uffff\1\7\1\1\26\uffff\20\1\1\uffff\2\1",
            "",
            "\1\11\1\10\1\12\55\uffff\1\13",
            "\1\6\1\1\2\uffff\2\1\17\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\17\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\17\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\17\uffff\1\14\1\1\26\uffff\20\1\1\uffff\2\1",
            "\1\11\1\10\1\12\55\uffff\1\13"
    };
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[][] dfa_54 = unpackEncodedStringArray(dfa_54s);

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = dfa_33;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_53;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_54;
        }
        public String getDescription() {
            return "5528:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_collection_5_0= ruleCollectionInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00400000000001C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x02F67FE7E9B2C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x02E67FE7E9B2C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x02C67FE7E9B2C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x02C27FE7E9B241F2L,0x0000000000018900L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x02C27FE7E9B2C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x02C27FE7E9B241F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x004001E0010001F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00400E07E00001C0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x024001E0010041F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00400000000081C0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000800000010002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x024201E00100C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x024001E00100C1F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0008000000008000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000810010000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x01400E07E00001C0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00400E07E20001C0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0xE000000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000078L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000001000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x024001E0030041F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x02400FE7E30041F0L,0x0000000000018900L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0001000000010000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});

}