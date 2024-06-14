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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'abstract'", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'const'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'Any'", "'::'", "'.'", "'true'", "'false'", "'self'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'attribute'", "'annotate'", "'freeze'", "'but'", "'|'", "'eval'", "'interface'", "'export'", "'import'", "'insert'", "'*'", "'conflicts'", "'version'", "'def'", "'static'", "'@'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'->'", "'['", "']'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
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
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
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
    // InternalIvml.g:70:1: entryRuleVariabilityUnit returns [EObject current=null] : iv_ruleVariabilityUnit= ruleVariabilityUnit EOF ;
    public final EObject entryRuleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariabilityUnit = null;


        try {
            // InternalIvml.g:70:56: (iv_ruleVariabilityUnit= ruleVariabilityUnit EOF )
            // InternalIvml.g:71:2: iv_ruleVariabilityUnit= ruleVariabilityUnit EOF
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
    // InternalIvml.g:77:1: ruleVariabilityUnit returns [EObject current=null] : ( () ( (lv_projects_1_0= ruleProject ) )* ) ;
    public final EObject ruleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_projects_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:83:2: ( ( () ( (lv_projects_1_0= ruleProject ) )* ) )
            // InternalIvml.g:84:2: ( () ( (lv_projects_1_0= ruleProject ) )* )
            {
            // InternalIvml.g:84:2: ( () ( (lv_projects_1_0= ruleProject ) )* )
            // InternalIvml.g:85:3: () ( (lv_projects_1_0= ruleProject ) )*
            {
            // InternalIvml.g:85:3: ()
            // InternalIvml.g:86:4: 
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

            // InternalIvml.g:95:3: ( (lv_projects_1_0= ruleProject ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIvml.g:96:4: (lv_projects_1_0= ruleProject )
            	    {
            	    // InternalIvml.g:96:4: (lv_projects_1_0= ruleProject )
            	    // InternalIvml.g:97:5: lv_projects_1_0= ruleProject
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
    // InternalIvml.g:118:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalIvml.g:118:48: (iv_ruleProject= ruleProject EOF )
            // InternalIvml.g:119:2: iv_ruleProject= ruleProject EOF
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
    // InternalIvml.g:125:1: ruleProject returns [EObject current=null] : (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) ;
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
            // InternalIvml.g:131:2: ( (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) )
            // InternalIvml.g:132:2: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            {
            // InternalIvml.g:132:2: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            // InternalIvml.g:133:3: otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
              		
            }
            // InternalIvml.g:137:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:138:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:138:4: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:139:5: lv_name_1_0= ruleIdentifier
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
            // InternalIvml.g:160:3: ( (lv_version_3_0= ruleVersionStmt ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==57) ) {
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
                    // InternalIvml.g:161:4: (lv_version_3_0= ruleVersionStmt )
                    {
                    // InternalIvml.g:161:4: (lv_version_3_0= ruleVersionStmt )
                    // InternalIvml.g:162:5: lv_version_3_0= ruleVersionStmt
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

            // InternalIvml.g:179:3: ( (lv_imports_4_0= ruleImportStmt ) )*
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalIvml.g:180:4: (lv_imports_4_0= ruleImportStmt )
            	    {
            	    // InternalIvml.g:180:4: (lv_imports_4_0= ruleImportStmt )
            	    // InternalIvml.g:181:5: lv_imports_4_0= ruleImportStmt
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

            // InternalIvml.g:198:3: ( (lv_conflicts_5_0= ruleConflictStmt ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==56) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIvml.g:199:4: (lv_conflicts_5_0= ruleConflictStmt )
            	    {
            	    // InternalIvml.g:199:4: (lv_conflicts_5_0= ruleConflictStmt )
            	    // InternalIvml.g:200:5: lv_conflicts_5_0= ruleConflictStmt
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

            // InternalIvml.g:217:3: ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==51) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIvml.g:218:4: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    {
            	    // InternalIvml.g:218:4: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    // InternalIvml.g:219:5: lv_interfaces_6_0= ruleInterfaceDeclaration
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

            // InternalIvml.g:236:3: ( (lv_contents_7_0= ruleProjectContents ) )
            // InternalIvml.g:237:4: (lv_contents_7_0= ruleProjectContents )
            {
            // InternalIvml.g:237:4: (lv_contents_7_0= ruleProjectContents )
            // InternalIvml.g:238:5: lv_contents_7_0= ruleProjectContents
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
            // InternalIvml.g:259:3: (otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalIvml.g:260:4: otherlv_9= ';'
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
    // InternalIvml.g:269:1: entryRuleProjectContents returns [EObject current=null] : iv_ruleProjectContents= ruleProjectContents EOF ;
    public final EObject entryRuleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectContents = null;


        try {
            // InternalIvml.g:269:56: (iv_ruleProjectContents= ruleProjectContents EOF )
            // InternalIvml.g:270:2: iv_ruleProjectContents= ruleProjectContents EOF
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
    // InternalIvml.g:276:1: ruleProjectContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) ;
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
            // InternalIvml.g:282:2: ( ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) )
            // InternalIvml.g:283:2: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            {
            // InternalIvml.g:283:2: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            // InternalIvml.g:284:3: () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            {
            // InternalIvml.g:284:3: ()
            // InternalIvml.g:285:4: 
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

            // InternalIvml.g:294:3: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            loop7:
            do {
                int alt7=9;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalIvml.g:295:4: ( (lv_elements_1_0= ruleTypedef ) )
            	    {
            	    // InternalIvml.g:295:4: ( (lv_elements_1_0= ruleTypedef ) )
            	    // InternalIvml.g:296:5: (lv_elements_1_0= ruleTypedef )
            	    {
            	    // InternalIvml.g:296:5: (lv_elements_1_0= ruleTypedef )
            	    // InternalIvml.g:297:6: lv_elements_1_0= ruleTypedef
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
            	    // InternalIvml.g:315:4: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:315:4: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:316:5: (lv_elements_2_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:316:5: (lv_elements_2_0= ruleVariableDeclaration )
            	    // InternalIvml.g:317:6: lv_elements_2_0= ruleVariableDeclaration
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
            	    // InternalIvml.g:335:4: ( (lv_elements_3_0= ruleFreeze ) )
            	    {
            	    // InternalIvml.g:335:4: ( (lv_elements_3_0= ruleFreeze ) )
            	    // InternalIvml.g:336:5: (lv_elements_3_0= ruleFreeze )
            	    {
            	    // InternalIvml.g:336:5: (lv_elements_3_0= ruleFreeze )
            	    // InternalIvml.g:337:6: lv_elements_3_0= ruleFreeze
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
            	    // InternalIvml.g:355:4: ( (lv_elements_4_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:355:4: ( (lv_elements_4_0= ruleEval ) )
            	    // InternalIvml.g:356:5: (lv_elements_4_0= ruleEval )
            	    {
            	    // InternalIvml.g:356:5: (lv_elements_4_0= ruleEval )
            	    // InternalIvml.g:357:6: lv_elements_4_0= ruleEval
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
            	    // InternalIvml.g:375:4: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:375:4: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:376:5: (lv_elements_5_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:376:5: (lv_elements_5_0= ruleExpressionStatement )
            	    // InternalIvml.g:377:6: lv_elements_5_0= ruleExpressionStatement
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
            	    // InternalIvml.g:395:4: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    {
            	    // InternalIvml.g:395:4: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    // InternalIvml.g:396:5: (lv_elements_6_0= ruleAnnotateTo )
            	    {
            	    // InternalIvml.g:396:5: (lv_elements_6_0= ruleAnnotateTo )
            	    // InternalIvml.g:397:6: lv_elements_6_0= ruleAnnotateTo
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
            	    // InternalIvml.g:415:4: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    {
            	    // InternalIvml.g:415:4: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    // InternalIvml.g:416:5: (lv_elements_7_0= ruleOpDefStatement )
            	    {
            	    // InternalIvml.g:416:5: (lv_elements_7_0= ruleOpDefStatement )
            	    // InternalIvml.g:417:6: lv_elements_7_0= ruleOpDefStatement
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
            	    // InternalIvml.g:435:4: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:435:4: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:436:5: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:436:5: (lv_elements_8_0= ruleAttrAssignment )
            	    // InternalIvml.g:437:6: lv_elements_8_0= ruleAttrAssignment
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
    // InternalIvml.g:459:1: entryRuleTypedef returns [EObject current=null] : iv_ruleTypedef= ruleTypedef EOF ;
    public final EObject entryRuleTypedef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedef = null;


        try {
            // InternalIvml.g:459:48: (iv_ruleTypedef= ruleTypedef EOF )
            // InternalIvml.g:460:2: iv_ruleTypedef= ruleTypedef EOF
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
    // InternalIvml.g:466:1: ruleTypedef returns [EObject current=null] : ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) ;
    public final EObject ruleTypedef() throws RecognitionException {
        EObject current = null;

        EObject lv_tEnum_0_0 = null;

        EObject lv_tCompound_1_0 = null;

        EObject lv_tMapping_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:472:2: ( ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) )
            // InternalIvml.g:473:2: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            {
            // InternalIvml.g:473:2: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
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
                    // InternalIvml.g:474:3: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    {
                    // InternalIvml.g:474:3: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    // InternalIvml.g:475:4: (lv_tEnum_0_0= ruleTypedefEnum )
                    {
                    // InternalIvml.g:475:4: (lv_tEnum_0_0= ruleTypedefEnum )
                    // InternalIvml.g:476:5: lv_tEnum_0_0= ruleTypedefEnum
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
                    // InternalIvml.g:494:3: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    {
                    // InternalIvml.g:494:3: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    // InternalIvml.g:495:4: (lv_tCompound_1_0= ruleTypedefCompound )
                    {
                    // InternalIvml.g:495:4: (lv_tCompound_1_0= ruleTypedefCompound )
                    // InternalIvml.g:496:5: lv_tCompound_1_0= ruleTypedefCompound
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
                    // InternalIvml.g:514:3: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    {
                    // InternalIvml.g:514:3: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    // InternalIvml.g:515:4: (lv_tMapping_2_0= ruleTypedefMapping )
                    {
                    // InternalIvml.g:515:4: (lv_tMapping_2_0= ruleTypedefMapping )
                    // InternalIvml.g:516:5: lv_tMapping_2_0= ruleTypedefMapping
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
    // InternalIvml.g:537:1: entryRuleTypedefEnum returns [EObject current=null] : iv_ruleTypedefEnum= ruleTypedefEnum EOF ;
    public final EObject entryRuleTypedefEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnum = null;


        try {
            // InternalIvml.g:537:52: (iv_ruleTypedefEnum= ruleTypedefEnum EOF )
            // InternalIvml.g:538:2: iv_ruleTypedefEnum= ruleTypedefEnum EOF
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
    // InternalIvml.g:544:1: ruleTypedefEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) ;
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
            // InternalIvml.g:550:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) )
            // InternalIvml.g:551:2: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            {
            // InternalIvml.g:551:2: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            // InternalIvml.g:552:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalIvml.g:556:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:557:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:557:4: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:558:5: lv_name_1_0= ruleIdentifier
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
            // InternalIvml.g:579:3: ( (lv_literals_3_0= ruleTypedefEnumLiteral ) )
            // InternalIvml.g:580:4: (lv_literals_3_0= ruleTypedefEnumLiteral )
            {
            // InternalIvml.g:580:4: (lv_literals_3_0= ruleTypedefEnumLiteral )
            // InternalIvml.g:581:5: lv_literals_3_0= ruleTypedefEnumLiteral
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

            // InternalIvml.g:598:3: (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIvml.g:599:4: otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getTypedefEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalIvml.g:603:4: ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    // InternalIvml.g:604:5: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    {
            	    // InternalIvml.g:604:5: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    // InternalIvml.g:605:6: lv_literals_5_0= ruleTypedefEnumLiteral
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
            // InternalIvml.g:627:3: ( (lv_constraint_7_0= ruleTypedefConstraint ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIvml.g:628:4: (lv_constraint_7_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:628:4: (lv_constraint_7_0= ruleTypedefConstraint )
                    // InternalIvml.g:629:5: lv_constraint_7_0= ruleTypedefConstraint
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
    // InternalIvml.g:654:1: entryRuleTypedefEnumLiteral returns [EObject current=null] : iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF ;
    public final EObject entryRuleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnumLiteral = null;


        try {
            // InternalIvml.g:654:59: (iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF )
            // InternalIvml.g:655:2: iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF
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
    // InternalIvml.g:661:1: ruleTypedefEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) ;
    public final EObject ruleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:667:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) )
            // InternalIvml.g:668:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            {
            // InternalIvml.g:668:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            // InternalIvml.g:669:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            {
            // InternalIvml.g:669:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:670:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:670:4: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:671:5: lv_name_0_0= ruleIdentifier
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

            // InternalIvml.g:688:3: (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalIvml.g:689:4: otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypedefEnumLiteralAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalIvml.g:693:4: ( (lv_value_2_0= ruleNumValue ) )
                    // InternalIvml.g:694:5: (lv_value_2_0= ruleNumValue )
                    {
                    // InternalIvml.g:694:5: (lv_value_2_0= ruleNumValue )
                    // InternalIvml.g:695:6: lv_value_2_0= ruleNumValue
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
    // InternalIvml.g:717:1: entryRuleTypedefCompound returns [EObject current=null] : iv_ruleTypedefCompound= ruleTypedefCompound EOF ;
    public final EObject entryRuleTypedefCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefCompound = null;


        try {
            // InternalIvml.g:717:56: (iv_ruleTypedefCompound= ruleTypedefCompound EOF )
            // InternalIvml.g:718:2: iv_ruleTypedefCompound= ruleTypedefCompound EOF
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
    // InternalIvml.g:724:1: ruleTypedefCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? ) ;
    public final EObject ruleTypedefCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        AntlrDatatypeRuleToken lv_super_6_0 = null;

        EObject lv_elements_8_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_10_0 = null;

        EObject lv_elements_11_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:730:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? ) )
            // InternalIvml.g:731:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? )
            {
            // InternalIvml.g:731:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? )
            // InternalIvml.g:732:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )?
            {
            // InternalIvml.g:732:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalIvml.g:733:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalIvml.g:733:4: (lv_abstract_0_0= 'abstract' )
                    // InternalIvml.g:734:5: lv_abstract_0_0= 'abstract'
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
            // InternalIvml.g:750:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:751:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:751:4: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:752:5: lv_name_2_0= ruleIdentifier
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

            // InternalIvml.g:769:3: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalIvml.g:770:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )*
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTypedefCompoundAccess().getRefinesKeyword_3_0());
                      			
                    }
                    // InternalIvml.g:774:4: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalIvml.g:775:5: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalIvml.g:775:5: (lv_super_4_0= ruleIdentifier )
                    // InternalIvml.g:776:6: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_super_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                      						}
                      						add(
                      							current,
                      							"super",
                      							lv_super_4_0,
                      							"de.uni_hildesheim.sse.Ivml.Identifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalIvml.g:793:4: (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==18) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalIvml.g:794:5: otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getTypedefCompoundAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalIvml.g:798:5: ( (lv_super_6_0= ruleIdentifier ) )
                    	    // InternalIvml.g:799:6: (lv_super_6_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:799:6: (lv_super_6_0= ruleIdentifier )
                    	    // InternalIvml.g:800:7: lv_super_6_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_super_6_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"super",
                    	      								lv_super_6_0,
                    	      								"de.uni_hildesheim.sse.Ivml.Identifier");
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


                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getTypedefCompoundAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalIvml.g:823:3: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )*
            loop15:
            do {
                int alt15=5;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // InternalIvml.g:824:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:824:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:825:5: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:825:5: (lv_elements_8_0= ruleVariableDeclaration )
            	    // InternalIvml.g:826:6: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_8_0=ruleVariableDeclaration();

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
            	      							"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:844:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:844:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:845:5: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:845:5: (lv_elements_9_0= ruleExpressionStatement )
            	    // InternalIvml.g:846:6: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_9_0=ruleExpressionStatement();

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
            	      							"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:864:4: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:864:4: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:865:5: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:865:5: (lv_elements_10_0= ruleAttrAssignment )
            	    // InternalIvml.g:866:6: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsAttrAssignmentParserRuleCall_5_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_10_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
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
            	case 4 :
            	    // InternalIvml.g:884:4: ( (lv_elements_11_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:884:4: ( (lv_elements_11_0= ruleEval ) )
            	    // InternalIvml.g:885:5: (lv_elements_11_0= ruleEval )
            	    {
            	    // InternalIvml.g:885:5: (lv_elements_11_0= ruleEval )
            	    // InternalIvml.g:886:6: lv_elements_11_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsEvalParserRuleCall_5_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_11_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_11_0,
            	      							"de.uni_hildesheim.sse.Ivml.Eval");
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

            otherlv_12=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getTypedefCompoundAccess().getRightCurlyBracketKeyword_6());
              		
            }
            // InternalIvml.g:908:3: (otherlv_13= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalIvml.g:909:4: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_7());
                      			
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
    // InternalIvml.g:918:1: entryRuleAttrAssignment returns [EObject current=null] : iv_ruleAttrAssignment= ruleAttrAssignment EOF ;
    public final EObject entryRuleAttrAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignment = null;


        try {
            // InternalIvml.g:918:55: (iv_ruleAttrAssignment= ruleAttrAssignment EOF )
            // InternalIvml.g:919:2: iv_ruleAttrAssignment= ruleAttrAssignment EOF
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
    // InternalIvml.g:925:1: ruleAttrAssignment returns [EObject current=null] : (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) ;
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
            // InternalIvml.g:931:2: ( (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) )
            // InternalIvml.g:932:2: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // InternalIvml.g:932:2: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            // InternalIvml.g:933:3: otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAttrAssignmentAccess().getAssignKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIvml.g:941:3: ( (lv_parts_2_0= ruleAttrAssignmentPart ) )
            // InternalIvml.g:942:4: (lv_parts_2_0= ruleAttrAssignmentPart )
            {
            // InternalIvml.g:942:4: (lv_parts_2_0= ruleAttrAssignmentPart )
            // InternalIvml.g:943:5: lv_parts_2_0= ruleAttrAssignmentPart
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            // InternalIvml.g:960:3: (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalIvml.g:961:4: otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getAttrAssignmentAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalIvml.g:965:4: ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    // InternalIvml.g:966:5: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    {
            	    // InternalIvml.g:966:5: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    // InternalIvml.g:967:6: lv_parts_4_0= ruleAttrAssignmentPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop17;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAttrAssignmentAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_6=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getAttrAssignmentAccess().getToKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,14,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAttrAssignmentAccess().getLeftCurlyBracketKeyword_6());
              		
            }
            // InternalIvml.g:997:3: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=4;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // InternalIvml.g:998:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:998:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:999:5: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:999:5: (lv_elements_8_0= ruleVariableDeclaration )
            	    // InternalIvml.g:1000:6: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    // InternalIvml.g:1018:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:1018:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:1019:5: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:1019:5: (lv_elements_9_0= ruleExpressionStatement )
            	    // InternalIvml.g:1020:6: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    // InternalIvml.g:1038:4: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:1038:4: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:1039:5: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:1039:5: (lv_elements_10_0= ruleAttrAssignment )
            	    // InternalIvml.g:1040:6: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsAttrAssignmentParserRuleCall_7_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getAttrAssignmentAccess().getRightCurlyBracketKeyword_8());
              		
            }
            // InternalIvml.g:1062:3: (otherlv_12= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==16) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalIvml.g:1063:4: otherlv_12= ';'
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
    // InternalIvml.g:1072:1: entryRuleAttrAssignmentPart returns [EObject current=null] : iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF ;
    public final EObject entryRuleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignmentPart = null;


        try {
            // InternalIvml.g:1072:59: (iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF )
            // InternalIvml.g:1073:2: iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF
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
    // InternalIvml.g:1079:1: ruleAttrAssignmentPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) ;
    public final EObject ruleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1085:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) )
            // InternalIvml.g:1086:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            {
            // InternalIvml.g:1086:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            // InternalIvml.g:1087:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) )
            {
            // InternalIvml.g:1087:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1088:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1088:4: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1089:5: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            otherlv_1=(Token)match(input,19,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentPartAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalIvml.g:1110:3: ( (lv_value_2_0= ruleLogicalExpression ) )
            // InternalIvml.g:1111:4: (lv_value_2_0= ruleLogicalExpression )
            {
            // InternalIvml.g:1111:4: (lv_value_2_0= ruleLogicalExpression )
            // InternalIvml.g:1112:5: lv_value_2_0= ruleLogicalExpression
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
    // InternalIvml.g:1133:1: entryRuleTypedefMapping returns [EObject current=null] : iv_ruleTypedefMapping= ruleTypedefMapping EOF ;
    public final EObject entryRuleTypedefMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefMapping = null;


        try {
            // InternalIvml.g:1133:55: (iv_ruleTypedefMapping= ruleTypedefMapping EOF )
            // InternalIvml.g:1134:2: iv_ruleTypedefMapping= ruleTypedefMapping EOF
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
    // InternalIvml.g:1140:1: ruleTypedefMapping returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) ;
    public final EObject ruleTypedefMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newType_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_constraint_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1146:2: ( (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) )
            // InternalIvml.g:1147:2: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:1147:2: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            // InternalIvml.g:1148:3: otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefMappingAccess().getTypedefKeyword_0());
              		
            }
            // InternalIvml.g:1152:3: ( (lv_newType_1_0= ruleIdentifier ) )
            // InternalIvml.g:1153:4: (lv_newType_1_0= ruleIdentifier )
            {
            // InternalIvml.g:1153:4: (lv_newType_1_0= ruleIdentifier )
            // InternalIvml.g:1154:5: lv_newType_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedefMappingAccess().getNewTypeIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalIvml.g:1171:3: ( (lv_type_2_0= ruleType ) )
            // InternalIvml.g:1172:4: (lv_type_2_0= ruleType )
            {
            // InternalIvml.g:1172:4: (lv_type_2_0= ruleType )
            // InternalIvml.g:1173:5: lv_type_2_0= ruleType
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

            // InternalIvml.g:1190:3: ( (lv_constraint_3_0= ruleTypedefConstraint ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalIvml.g:1191:4: (lv_constraint_3_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:1191:4: (lv_constraint_3_0= ruleTypedefConstraint )
                    // InternalIvml.g:1192:5: lv_constraint_3_0= ruleTypedefConstraint
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
    // InternalIvml.g:1217:1: entryRuleTypedefConstraint returns [EObject current=null] : iv_ruleTypedefConstraint= ruleTypedefConstraint EOF ;
    public final EObject entryRuleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefConstraint = null;


        try {
            // InternalIvml.g:1217:58: (iv_ruleTypedefConstraint= ruleTypedefConstraint EOF )
            // InternalIvml.g:1218:2: iv_ruleTypedefConstraint= ruleTypedefConstraint EOF
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
    // InternalIvml.g:1224:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1230:2: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalIvml.g:1231:2: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalIvml.g:1231:2: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalIvml.g:1232:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefConstraintAccess().getWithKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTypedefConstraintAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIvml.g:1240:3: ( (lv_expressions_2_0= ruleExpression ) )
            // InternalIvml.g:1241:4: (lv_expressions_2_0= ruleExpression )
            {
            // InternalIvml.g:1241:4: (lv_expressions_2_0= ruleExpression )
            // InternalIvml.g:1242:5: lv_expressions_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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
    // InternalIvml.g:1267:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalIvml.g:1267:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalIvml.g:1268:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalIvml.g:1274:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) ;
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
            // InternalIvml.g:1280:2: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) )
            // InternalIvml.g:1281:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            {
            // InternalIvml.g:1281:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            // InternalIvml.g:1282:3: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';'
            {
            // InternalIvml.g:1282:3: ( (lv_const_0_0= 'const' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIvml.g:1283:4: (lv_const_0_0= 'const' )
                    {
                    // InternalIvml.g:1283:4: (lv_const_0_0= 'const' )
                    // InternalIvml.g:1284:5: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,29,FOLLOW_27); if (state.failed) return current;
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

            // InternalIvml.g:1296:3: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:1297:4: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:1297:4: (lv_type_1_0= ruleType )
            // InternalIvml.g:1298:5: lv_type_1_0= ruleType
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

            // InternalIvml.g:1315:3: ( (lv_decls_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:1316:4: (lv_decls_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:1316:4: (lv_decls_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:1317:5: lv_decls_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalIvml.g:1334:3: (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==18) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalIvml.g:1335:4: otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalIvml.g:1339:4: ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    // InternalIvml.g:1340:5: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    {
            	    // InternalIvml.g:1340:5: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    // InternalIvml.g:1341:6: lv_decls_4_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop22;
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
    // InternalIvml.g:1367:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // InternalIvml.g:1367:64: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // InternalIvml.g:1368:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
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
    // InternalIvml.g:1374:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1380:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:1381:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:1381:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // InternalIvml.g:1382:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:1382:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1383:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1383:4: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1384:5: lv_name_0_0= ruleIdentifier
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

            // InternalIvml.g:1401:3: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalIvml.g:1402:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalIvml.g:1406:4: ( (lv_default_2_0= ruleExpression ) )
                    // InternalIvml.g:1407:5: (lv_default_2_0= ruleExpression )
                    {
                    // InternalIvml.g:1407:5: (lv_default_2_0= ruleExpression )
                    // InternalIvml.g:1408:6: lv_default_2_0= ruleExpression
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
    // InternalIvml.g:1430:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalIvml.g:1430:50: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalIvml.g:1431:2: iv_ruleBasicType= ruleBasicType EOF
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
    // InternalIvml.g:1437:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;
        Token lv_type_5_0=null;


        	enterRule();

        try {
            // InternalIvml.g:1443:2: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) ) )
            // InternalIvml.g:1444:2: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) )
            {
            // InternalIvml.g:1444:2: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) )
            int alt24=6;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt24=1;
                }
                break;
            case 31:
                {
                alt24=2;
                }
                break;
            case 32:
                {
                alt24=3;
                }
                break;
            case 33:
                {
                alt24=4;
                }
                break;
            case 34:
                {
                alt24=5;
                }
                break;
            case 35:
                {
                alt24=6;
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
                    // InternalIvml.g:1445:3: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // InternalIvml.g:1445:3: ( (lv_type_0_0= 'Integer' ) )
                    // InternalIvml.g:1446:4: (lv_type_0_0= 'Integer' )
                    {
                    // InternalIvml.g:1446:4: (lv_type_0_0= 'Integer' )
                    // InternalIvml.g:1447:5: lv_type_0_0= 'Integer'
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
                    // InternalIvml.g:1460:3: ( (lv_type_1_0= 'Real' ) )
                    {
                    // InternalIvml.g:1460:3: ( (lv_type_1_0= 'Real' ) )
                    // InternalIvml.g:1461:4: (lv_type_1_0= 'Real' )
                    {
                    // InternalIvml.g:1461:4: (lv_type_1_0= 'Real' )
                    // InternalIvml.g:1462:5: lv_type_1_0= 'Real'
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
                    // InternalIvml.g:1475:3: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // InternalIvml.g:1475:3: ( (lv_type_2_0= 'Boolean' ) )
                    // InternalIvml.g:1476:4: (lv_type_2_0= 'Boolean' )
                    {
                    // InternalIvml.g:1476:4: (lv_type_2_0= 'Boolean' )
                    // InternalIvml.g:1477:5: lv_type_2_0= 'Boolean'
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
                    // InternalIvml.g:1490:3: ( (lv_type_3_0= 'String' ) )
                    {
                    // InternalIvml.g:1490:3: ( (lv_type_3_0= 'String' ) )
                    // InternalIvml.g:1491:4: (lv_type_3_0= 'String' )
                    {
                    // InternalIvml.g:1491:4: (lv_type_3_0= 'String' )
                    // InternalIvml.g:1492:5: lv_type_3_0= 'String'
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
                    // InternalIvml.g:1505:3: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // InternalIvml.g:1505:3: ( (lv_type_4_0= 'Constraint' ) )
                    // InternalIvml.g:1506:4: (lv_type_4_0= 'Constraint' )
                    {
                    // InternalIvml.g:1506:4: (lv_type_4_0= 'Constraint' )
                    // InternalIvml.g:1507:5: lv_type_4_0= 'Constraint'
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
                case 6 :
                    // InternalIvml.g:1520:3: ( (lv_type_5_0= 'Any' ) )
                    {
                    // InternalIvml.g:1520:3: ( (lv_type_5_0= 'Any' ) )
                    // InternalIvml.g:1521:4: (lv_type_5_0= 'Any' )
                    {
                    // InternalIvml.g:1521:4: (lv_type_5_0= 'Any' )
                    // InternalIvml.g:1522:5: lv_type_5_0= 'Any'
                    {
                    lv_type_5_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_type_5_0, grammarAccess.getBasicTypeAccess().getTypeAnyKeyword_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBasicTypeRule());
                      					}
                      					setWithLastConsumed(current, "type", lv_type_5_0, "Any");
                      				
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
    // InternalIvml.g:1538:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalIvml.g:1538:45: (iv_ruleType= ruleType EOF )
            // InternalIvml.g:1539:2: iv_ruleType= ruleType EOF
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
    // InternalIvml.g:1545:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1551:2: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // InternalIvml.g:1552:2: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // InternalIvml.g:1552:2: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                {
                alt25=1;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 57:
                {
                alt25=2;
                }
                break;
            case 42:
            case 43:
            case 44:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalIvml.g:1553:3: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // InternalIvml.g:1553:3: ( (lv_type_0_0= ruleBasicType ) )
                    // InternalIvml.g:1554:4: (lv_type_0_0= ruleBasicType )
                    {
                    // InternalIvml.g:1554:4: (lv_type_0_0= ruleBasicType )
                    // InternalIvml.g:1555:5: lv_type_0_0= ruleBasicType
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
                    // InternalIvml.g:1573:3: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1573:3: ( (lv_id_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:1574:4: (lv_id_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1574:4: (lv_id_1_0= ruleQualifiedName )
                    // InternalIvml.g:1575:5: lv_id_1_0= ruleQualifiedName
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
                    // InternalIvml.g:1593:3: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // InternalIvml.g:1593:3: ( (lv_derived_2_0= ruleDerivedType ) )
                    // InternalIvml.g:1594:4: (lv_derived_2_0= ruleDerivedType )
                    {
                    // InternalIvml.g:1594:4: (lv_derived_2_0= ruleDerivedType )
                    // InternalIvml.g:1595:5: lv_derived_2_0= ruleDerivedType
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
    // InternalIvml.g:1616:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalIvml.g:1616:49: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalIvml.g:1617:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalIvml.g:1623:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalIvml.g:1629:2: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalIvml.g:1630:2: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalIvml.g:1630:2: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalIvml.g:1631:3: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalIvml.g:1631:3: (lv_val_0_0= RULE_NUMBER )
            // InternalIvml.g:1632:4: lv_val_0_0= RULE_NUMBER
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
    // InternalIvml.g:1651:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalIvml.g:1651:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalIvml.g:1652:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalIvml.g:1658:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1664:2: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // InternalIvml.g:1665:2: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // InternalIvml.g:1665:2: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // InternalIvml.g:1666:3: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // InternalIvml.g:1666:3: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (LA27_3==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (LA27_4==36) ) {
                        alt27=1;
                    }
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // InternalIvml.g:1667:4: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // InternalIvml.g:1667:4: ( (lv_qName_0_0= ruleIdentifier ) )
                    // InternalIvml.g:1668:5: (lv_qName_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:1668:5: (lv_qName_0_0= ruleIdentifier )
                    // InternalIvml.g:1669:6: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalIvml.g:1686:4: ( (lv_qName_1_0= '::' ) )
                    // InternalIvml.g:1687:5: (lv_qName_1_0= '::' )
                    {
                    // InternalIvml.g:1687:5: (lv_qName_1_0= '::' )
                    // InternalIvml.g:1688:6: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
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

                    // InternalIvml.g:1700:4: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA26_2 = input.LA(2);

                            if ( (LA26_2==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA26_3 = input.LA(2);

                            if ( (LA26_3==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case 57:
                            {
                            int LA26_4 = input.LA(2);

                            if ( (LA26_4==36) ) {
                                alt26=1;
                            }


                            }
                            break;

                        }

                        switch (alt26) {
                    	case 1 :
                    	    // InternalIvml.g:1701:5: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // InternalIvml.g:1701:5: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // InternalIvml.g:1702:6: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:1702:6: (lv_qName_2_0= ruleIdentifier )
                    	    // InternalIvml.g:1703:7: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
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

                    	    // InternalIvml.g:1720:5: ( (lv_qName_3_0= '::' ) )
                    	    // InternalIvml.g:1721:6: (lv_qName_3_0= '::' )
                    	    {
                    	    // InternalIvml.g:1721:6: (lv_qName_3_0= '::' )
                    	    // InternalIvml.g:1722:7: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
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
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalIvml.g:1736:3: ( (lv_qName_4_0= ruleIdentifier ) )
            // InternalIvml.g:1737:4: (lv_qName_4_0= ruleIdentifier )
            {
            // InternalIvml.g:1737:4: (lv_qName_4_0= ruleIdentifier )
            // InternalIvml.g:1738:5: lv_qName_4_0= ruleIdentifier
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
    // InternalIvml.g:1759:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // InternalIvml.g:1759:51: (iv_ruleAccessName= ruleAccessName EOF )
            // InternalIvml.g:1760:2: iv_ruleAccessName= ruleAccessName EOF
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
    // InternalIvml.g:1766:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1772:2: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // InternalIvml.g:1773:2: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // InternalIvml.g:1773:2: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==37) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalIvml.g:1774:3: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // InternalIvml.g:1774:3: ( (lv_aName_0_0= '.' ) )
            	    // InternalIvml.g:1775:4: (lv_aName_0_0= '.' )
            	    {
            	    // InternalIvml.g:1775:4: (lv_aName_0_0= '.' )
            	    // InternalIvml.g:1776:5: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
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

            	    // InternalIvml.g:1788:3: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // InternalIvml.g:1789:4: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:1789:4: (lv_aName_1_0= ruleIdentifier )
            	    // InternalIvml.g:1790:5: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
    // InternalIvml.g:1811:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalIvml.g:1811:46: (iv_ruleValue= ruleValue EOF )
            // InternalIvml.g:1812:2: iv_ruleValue= ruleValue EOF
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
    // InternalIvml.g:1818:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token lv_self_4_0=null;
        Token lv_nullValue_5_0=null;
        Token lv_version_7_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;

        EObject lv_tValue_6_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:1824:2: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) ) )
            // InternalIvml.g:1825:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )
            {
            // InternalIvml.g:1825:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )
            int alt30=8;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalIvml.g:1826:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalIvml.g:1826:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalIvml.g:1827:4: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalIvml.g:1827:4: (lv_nValue_0_0= ruleNumValue )
                    // InternalIvml.g:1828:5: lv_nValue_0_0= ruleNumValue
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
                    // InternalIvml.g:1846:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalIvml.g:1846:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalIvml.g:1847:4: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalIvml.g:1847:4: (lv_sValue_1_0= RULE_STRING )
                    // InternalIvml.g:1848:5: lv_sValue_1_0= RULE_STRING
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
                    // InternalIvml.g:1865:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1865:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalIvml.g:1866:4: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1866:4: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalIvml.g:1867:5: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalIvml.g:1885:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalIvml.g:1885:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalIvml.g:1886:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalIvml.g:1886:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalIvml.g:1887:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalIvml.g:1887:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==38) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==39) ) {
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
                            // InternalIvml.g:1888:6: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                            // InternalIvml.g:1899:6: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1913:3: ( (lv_self_4_0= 'self' ) )
                    {
                    // InternalIvml.g:1913:3: ( (lv_self_4_0= 'self' ) )
                    // InternalIvml.g:1914:4: (lv_self_4_0= 'self' )
                    {
                    // InternalIvml.g:1914:4: (lv_self_4_0= 'self' )
                    // InternalIvml.g:1915:5: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1928:3: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // InternalIvml.g:1928:3: ( (lv_nullValue_5_0= 'null' ) )
                    // InternalIvml.g:1929:4: (lv_nullValue_5_0= 'null' )
                    {
                    // InternalIvml.g:1929:4: (lv_nullValue_5_0= 'null' )
                    // InternalIvml.g:1930:5: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
                    // InternalIvml.g:1943:3: ( (lv_tValue_6_0= ruleType ) )
                    {
                    // InternalIvml.g:1943:3: ( (lv_tValue_6_0= ruleType ) )
                    // InternalIvml.g:1944:4: (lv_tValue_6_0= ruleType )
                    {
                    // InternalIvml.g:1944:4: (lv_tValue_6_0= ruleType )
                    // InternalIvml.g:1945:5: lv_tValue_6_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getValueAccess().getTValueTypeParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_tValue_6_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getValueRule());
                      					}
                      					set(
                      						current,
                      						"tValue",
                      						lv_tValue_6_0,
                      						"de.uni_hildesheim.sse.Ivml.Type");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalIvml.g:1963:3: ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) )
                    {
                    // InternalIvml.g:1963:3: ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) )
                    // InternalIvml.g:1964:4: ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION )
                    {
                    // InternalIvml.g:1968:4: (lv_version_7_0= RULE_VERSION )
                    // InternalIvml.g:1969:5: lv_version_7_0= RULE_VERSION
                    {
                    lv_version_7_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_version_7_0, grammarAccess.getValueAccess().getVersionVERSIONTerminalRuleCall_7_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getValueRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"version",
                      						lv_version_7_0,
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
    // InternalIvml.g:1989:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // InternalIvml.g:1989:52: (iv_ruleDerivedType= ruleDerivedType EOF )
            // InternalIvml.g:1990:2: iv_ruleDerivedType= ruleDerivedType EOF
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
    // InternalIvml.g:1996:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
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
            // InternalIvml.g:2002:2: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // InternalIvml.g:2003:2: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // InternalIvml.g:2003:2: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // InternalIvml.g:2004:3: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // InternalIvml.g:2004:3: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt31=1;
                }
                break;
            case 43:
                {
                alt31=2;
                }
                break;
            case 44:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalIvml.g:2005:4: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // InternalIvml.g:2005:4: ( (lv_op_0_0= 'setOf' ) )
                    // InternalIvml.g:2006:5: (lv_op_0_0= 'setOf' )
                    {
                    // InternalIvml.g:2006:5: (lv_op_0_0= 'setOf' )
                    // InternalIvml.g:2007:6: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,42,FOLLOW_21); if (state.failed) return current;
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
                    // InternalIvml.g:2020:4: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // InternalIvml.g:2020:4: ( (lv_op_1_0= 'sequenceOf' ) )
                    // InternalIvml.g:2021:5: (lv_op_1_0= 'sequenceOf' )
                    {
                    // InternalIvml.g:2021:5: (lv_op_1_0= 'sequenceOf' )
                    // InternalIvml.g:2022:6: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,43,FOLLOW_21); if (state.failed) return current;
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
                    // InternalIvml.g:2035:4: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // InternalIvml.g:2035:4: ( (lv_op_2_0= 'refTo' ) )
                    // InternalIvml.g:2036:5: (lv_op_2_0= 'refTo' )
                    {
                    // InternalIvml.g:2036:5: (lv_op_2_0= 'refTo' )
                    // InternalIvml.g:2037:6: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIvml.g:2054:3: ( (lv_type_4_0= ruleType ) )
            // InternalIvml.g:2055:4: (lv_type_4_0= ruleType )
            {
            // InternalIvml.g:2055:4: (lv_type_4_0= ruleType )
            // InternalIvml.g:2056:5: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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
    // InternalIvml.g:2081:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // InternalIvml.g:2081:51: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // InternalIvml.g:2082:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
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
    // InternalIvml.g:2088:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' ) ;
    public final EObject ruleAnnotateTo() throws RecognitionException {
        EObject current = null;

        Token lv_sname_0_1=null;
        Token lv_sname_0_2=null;
        Token otherlv_3=null;
        Token lv_names_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_annotationType_1_0 = null;

        EObject lv_annotationDecl_2_0 = null;

        AntlrDatatypeRuleToken lv_names_5_0 = null;

        AntlrDatatypeRuleToken lv_names_7_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2094:2: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' ) )
            // InternalIvml.g:2095:2: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' )
            {
            // InternalIvml.g:2095:2: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' )
            // InternalIvml.g:2096:3: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';'
            {
            // InternalIvml.g:2096:3: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // InternalIvml.g:2097:4: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // InternalIvml.g:2097:4: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // InternalIvml.g:2098:5: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // InternalIvml.g:2098:5: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            else if ( (LA32_0==46) ) {
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
                    // InternalIvml.g:2099:6: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,45,FOLLOW_27); if (state.failed) return current;
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
                    // InternalIvml.g:2110:6: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,46,FOLLOW_27); if (state.failed) return current;
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

            // InternalIvml.g:2123:3: ( (lv_annotationType_1_0= ruleType ) )
            // InternalIvml.g:2124:4: (lv_annotationType_1_0= ruleType )
            {
            // InternalIvml.g:2124:4: (lv_annotationType_1_0= ruleType )
            // InternalIvml.g:2125:5: lv_annotationType_1_0= ruleType
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

            // InternalIvml.g:2142:3: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:2143:4: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:2143:4: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:2144:5: lv_annotationDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationDeclVariableDeclarationPartParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            otherlv_3=(Token)match(input,26,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAnnotateToAccess().getToKeyword_3());
              		
            }
            // InternalIvml.g:2165:3: ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=RULE_VERSION && LA34_0<=RULE_EXPONENT)||LA34_0==57) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalIvml.g:2166:4: ( (lv_names_4_0= '.' ) )
                    {
                    // InternalIvml.g:2166:4: ( (lv_names_4_0= '.' ) )
                    // InternalIvml.g:2167:5: (lv_names_4_0= '.' )
                    {
                    // InternalIvml.g:2167:5: (lv_names_4_0= '.' )
                    // InternalIvml.g:2168:6: lv_names_4_0= '.'
                    {
                    lv_names_4_0=(Token)match(input,37,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_names_4_0, grammarAccess.getAnnotateToAccess().getNamesFullStopKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAnnotateToRule());
                      						}
                      						addWithLastConsumed(current, "names", lv_names_4_0, ".");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2181:4: ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* )
                    {
                    // InternalIvml.g:2181:4: ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* )
                    // InternalIvml.g:2182:5: ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )*
                    {
                    // InternalIvml.g:2182:5: ( (lv_names_5_0= ruleIdentifier ) )
                    // InternalIvml.g:2183:6: (lv_names_5_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2183:6: (lv_names_5_0= ruleIdentifier )
                    // InternalIvml.g:2184:7: lv_names_5_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_30);
                    lv_names_5_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getAnnotateToRule());
                      							}
                      							add(
                      								current,
                      								"names",
                      								lv_names_5_0,
                      								"de.uni_hildesheim.sse.Ivml.Identifier");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalIvml.g:2201:5: (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==18) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalIvml.g:2202:6: otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_6, grammarAccess.getAnnotateToAccess().getCommaKeyword_4_1_1_0());
                    	      					
                    	    }
                    	    // InternalIvml.g:2206:6: ( (lv_names_7_0= ruleIdentifier ) )
                    	    // InternalIvml.g:2207:7: (lv_names_7_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:2207:7: (lv_names_7_0= ruleIdentifier )
                    	    // InternalIvml.g:2208:8: lv_names_7_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_1_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_names_7_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getAnnotateToRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"names",
                    	      									lv_names_7_0,
                    	      									"de.uni_hildesheim.sse.Ivml.Identifier");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getAnnotateToAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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
    // InternalIvml.g:2236:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // InternalIvml.g:2236:47: (iv_ruleFreeze= ruleFreeze EOF )
            // InternalIvml.g:2237:2: iv_ruleFreeze= ruleFreeze EOF
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
    // InternalIvml.g:2243:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
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
            // InternalIvml.g:2249:2: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // InternalIvml.g:2250:2: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // InternalIvml.g:2250:2: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // InternalIvml.g:2251:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,47,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalIvml.g:2259:3: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_VERSION && LA35_0<=RULE_EXPONENT)||LA35_0==37||LA35_0==57) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalIvml.g:2260:4: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // InternalIvml.g:2260:4: (lv_names_2_0= ruleFreezeStatement )
            	    // InternalIvml.g:2261:5: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
              		
            }
            // InternalIvml.g:2282:3: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalIvml.g:2283:4: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,48,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalIvml.g:2291:4: ( (lv_id_6_0= ruleIdentifier ) )
                    // InternalIvml.g:2292:5: (lv_id_6_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2292:5: (lv_id_6_0= ruleIdentifier )
                    // InternalIvml.g:2293:6: lv_id_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFreezeAccess().getIdIdentifierParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
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

                    otherlv_7=(Token)match(input,49,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                      			
                    }
                    // InternalIvml.g:2314:4: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // InternalIvml.g:2315:5: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:2315:5: (lv_ex_8_0= ruleLogicalExpression )
                    // InternalIvml.g:2316:6: lv_ex_8_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFreezeAccess().getExLogicalExpressionParserRuleCall_4_4_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
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

            // InternalIvml.g:2338:3: (otherlv_10= ';' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==16) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalIvml.g:2339:4: otherlv_10= ';'
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
    // InternalIvml.g:2348:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // InternalIvml.g:2348:56: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // InternalIvml.g:2349:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
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
    // InternalIvml.g:2355:1: ruleFreezeStatement returns [EObject current=null] : ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token lv_dot_0_0=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;

        EObject lv_access_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2361:2: ( ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' ) )
            // InternalIvml.g:2362:2: ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' )
            {
            // InternalIvml.g:2362:2: ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' )
            // InternalIvml.g:2363:3: ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';'
            {
            // InternalIvml.g:2363:3: ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==37) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=RULE_VERSION && LA39_0<=RULE_EXPONENT)||LA39_0==57) ) {
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
                    // InternalIvml.g:2364:4: ( (lv_dot_0_0= '.' ) )
                    {
                    // InternalIvml.g:2364:4: ( (lv_dot_0_0= '.' ) )
                    // InternalIvml.g:2365:5: (lv_dot_0_0= '.' )
                    {
                    // InternalIvml.g:2365:5: (lv_dot_0_0= '.' )
                    // InternalIvml.g:2366:6: lv_dot_0_0= '.'
                    {
                    lv_dot_0_0=(Token)match(input,37,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_dot_0_0, grammarAccess.getFreezeStatementAccess().getDotFullStopKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFreezeStatementRule());
                      						}
                      						setWithLastConsumed(current, "dot", lv_dot_0_0, ".");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2379:4: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? )
                    {
                    // InternalIvml.g:2379:4: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? )
                    // InternalIvml.g:2380:5: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )?
                    {
                    // InternalIvml.g:2380:5: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:2381:6: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:2381:6: (lv_name_1_0= ruleQualifiedName )
                    // InternalIvml.g:2382:7: lv_name_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_37);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
                      							}
                      							set(
                      								current,
                      								"name",
                      								lv_name_1_0,
                      								"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalIvml.g:2399:5: ( (lv_access_2_0= ruleAccessName ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==37) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalIvml.g:2400:6: (lv_access_2_0= ruleAccessName )
                            {
                            // InternalIvml.g:2400:6: (lv_access_2_0= ruleAccessName )
                            // InternalIvml.g:2401:7: lv_access_2_0= ruleAccessName
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_14);
                            lv_access_2_0=ruleAccessName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
                              							}
                              							set(
                              								current,
                              								"access",
                              								lv_access_2_0,
                              								"de.uni_hildesheim.sse.Ivml.AccessName");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFreezeStatementAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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
    // InternalIvml.g:2428:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // InternalIvml.g:2428:45: (iv_ruleEval= ruleEval EOF )
            // InternalIvml.g:2429:2: iv_ruleEval= ruleEval EOF
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
    // InternalIvml.g:2435:1: ruleEval returns [EObject current=null] : ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) ;
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
            // InternalIvml.g:2441:2: ( ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) )
            // InternalIvml.g:2442:2: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            {
            // InternalIvml.g:2442:2: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            // InternalIvml.g:2443:3: () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )?
            {
            // InternalIvml.g:2443:3: ()
            // InternalIvml.g:2444:4: 
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

            otherlv_1=(Token)match(input,50,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getEvalKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,14,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalIvml.g:2461:3: ( (lv_nested_3_0= ruleEval ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalIvml.g:2462:4: (lv_nested_3_0= ruleEval )
            	    {
            	    // InternalIvml.g:2462:4: (lv_nested_3_0= ruleEval )
            	    // InternalIvml.g:2463:5: lv_nested_3_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_38);
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
            	    break loop40;
                }
            } while (true);

            // InternalIvml.g:2480:3: ( (lv_statements_4_0= ruleExpressionStatement ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_NUMBER && LA41_0<=RULE_EXPONENT)||LA41_0==14||LA41_0==24||(LA41_0>=30 && LA41_0<=35)||(LA41_0>=38 && LA41_0<=44)||LA41_0==55||LA41_0==57||LA41_0==61||(LA41_0>=63 && LA41_0<=78)||(LA41_0>=82 && LA41_0<=83)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalIvml.g:2481:4: (lv_statements_4_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:2481:4: (lv_statements_4_0= ruleExpressionStatement )
            	    // InternalIvml.g:2482:5: lv_statements_4_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_5());
              		
            }
            // InternalIvml.g:2503:3: (otherlv_6= ';' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==16) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalIvml.g:2504:4: otherlv_6= ';'
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
    // InternalIvml.g:2513:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // InternalIvml.g:2513:61: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // InternalIvml.g:2514:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
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
    // InternalIvml.g:2520:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
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
            // InternalIvml.g:2526:2: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // InternalIvml.g:2527:2: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // InternalIvml.g:2527:2: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // InternalIvml.g:2528:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
              		
            }
            // InternalIvml.g:2532:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2533:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2533:4: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2534:5: lv_name_1_0= ruleIdentifier
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

            otherlv_2=(Token)match(input,14,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalIvml.g:2555:3: ( (lv_exports_3_0= ruleExport ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==52) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalIvml.g:2556:4: (lv_exports_3_0= ruleExport )
            	    {
            	    // InternalIvml.g:2556:4: (lv_exports_3_0= ruleExport )
            	    // InternalIvml.g:2557:5: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
              		
            }
            // InternalIvml.g:2578:3: (otherlv_5= ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==16) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalIvml.g:2579:4: otherlv_5= ';'
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
    // InternalIvml.g:2588:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // InternalIvml.g:2588:47: (iv_ruleExport= ruleExport EOF )
            // InternalIvml.g:2589:2: iv_ruleExport= ruleExport EOF
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
    // InternalIvml.g:2595:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2601:2: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // InternalIvml.g:2602:2: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // InternalIvml.g:2602:2: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // InternalIvml.g:2603:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
              		
            }
            // InternalIvml.g:2607:3: ( (lv_names_1_0= ruleQualifiedName ) )
            // InternalIvml.g:2608:4: (lv_names_1_0= ruleQualifiedName )
            {
            // InternalIvml.g:2608:4: (lv_names_1_0= ruleQualifiedName )
            // InternalIvml.g:2609:5: lv_names_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalIvml.g:2626:3: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==18) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalIvml.g:2627:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalIvml.g:2631:4: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // InternalIvml.g:2632:5: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // InternalIvml.g:2632:5: (lv_names_3_0= ruleQualifiedName )
            	    // InternalIvml.g:2633:6: lv_names_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop45;
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
    // InternalIvml.g:2659:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // InternalIvml.g:2659:51: (iv_ruleImportStmt= ruleImportStmt EOF )
            // InternalIvml.g:2660:2: iv_ruleImportStmt= ruleImportStmt EOF
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
    // InternalIvml.g:2666:1: ruleImportStmt returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )? ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' ) ;
    public final EObject ruleImportStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_insert_1_0=null;
        Token otherlv_3=null;
        Token lv_wildcard_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_interface_4_0 = null;

        EObject lv_restriction_7_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2672:2: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )? ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' ) )
            // InternalIvml.g:2673:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )? ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' )
            {
            // InternalIvml.g:2673:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )? ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' )
            // InternalIvml.g:2674:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )? ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';'
            {
            // InternalIvml.g:2674:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            else if ( (LA46_0==54) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // InternalIvml.g:2675:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:2680:4: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalIvml.g:2680:4: ( (lv_insert_1_0= 'insert' ) )
                    // InternalIvml.g:2681:5: (lv_insert_1_0= 'insert' )
                    {
                    // InternalIvml.g:2681:5: (lv_insert_1_0= 'insert' )
                    // InternalIvml.g:2682:6: lv_insert_1_0= 'insert'
                    {
                    lv_insert_1_0=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_insert_1_0, grammarAccess.getImportStmtAccess().getInsertInsertKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getImportStmtRule());
                      						}
                      						setWithLastConsumed(current, "insert", lv_insert_1_0, "insert");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalIvml.g:2695:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:2696:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:2696:4: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:2697:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImportStmtRule());
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

            // InternalIvml.g:2714:3: (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==36) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalIvml.g:2715:4: otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                      			
                    }
                    // InternalIvml.g:2719:4: ( (lv_interface_4_0= ruleIdentifier ) )
                    // InternalIvml.g:2720:5: (lv_interface_4_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2720:5: (lv_interface_4_0= ruleIdentifier )
                    // InternalIvml.g:2721:6: lv_interface_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
                    lv_interface_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      						}
                      						set(
                      							current,
                      							"interface",
                      							lv_interface_4_0,
                      							"de.uni_hildesheim.sse.Ivml.Identifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalIvml.g:2739:3: ( (lv_wildcard_5_0= '*' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalIvml.g:2740:4: (lv_wildcard_5_0= '*' )
                    {
                    // InternalIvml.g:2740:4: (lv_wildcard_5_0= '*' )
                    // InternalIvml.g:2741:5: lv_wildcard_5_0= '*'
                    {
                    lv_wildcard_5_0=(Token)match(input,55,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_wildcard_5_0, grammarAccess.getImportStmtAccess().getWildcardAsteriskKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getImportStmtRule());
                      					}
                      					setWithLastConsumed(current, "wildcard", lv_wildcard_5_0, "*");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:2753:3: (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==28) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalIvml.g:2754:4: otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getImportStmtAccess().getWithKeyword_4_0());
                      			
                    }
                    // InternalIvml.g:2758:4: ( (lv_restriction_7_0= ruleExpression ) )
                    // InternalIvml.g:2759:5: (lv_restriction_7_0= ruleExpression )
                    {
                    // InternalIvml.g:2759:5: (lv_restriction_7_0= ruleExpression )
                    // InternalIvml.g:2760:6: lv_restriction_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getImportStmtAccess().getRestrictionExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_restriction_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      						}
                      						set(
                      							current,
                      							"restriction",
                      							lv_restriction_7_0,
                      							"de.uni_hildesheim.sse.Ivml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getImportStmtAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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
    // InternalIvml.g:2786:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // InternalIvml.g:2786:53: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // InternalIvml.g:2787:2: iv_ruleConflictStmt= ruleConflictStmt EOF
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
    // InternalIvml.g:2793:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2799:2: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // InternalIvml.g:2800:2: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:2800:2: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // InternalIvml.g:2801:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
              		
            }
            // InternalIvml.g:2805:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2806:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2806:4: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2807:5: lv_name_1_0= ruleIdentifier
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

            // InternalIvml.g:2824:3: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==28) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalIvml.g:2825:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                      			
                    }
                    // InternalIvml.g:2829:4: ( (lv_restriction_3_0= ruleExpression ) )
                    // InternalIvml.g:2830:5: (lv_restriction_3_0= ruleExpression )
                    {
                    // InternalIvml.g:2830:5: (lv_restriction_3_0= ruleExpression )
                    // InternalIvml.g:2831:6: lv_restriction_3_0= ruleExpression
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
    // InternalIvml.g:2857:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalIvml.g:2857:52: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalIvml.g:2858:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalIvml.g:2864:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalIvml.g:2870:2: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalIvml.g:2871:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalIvml.g:2871:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalIvml.g:2872:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
              		
            }
            // InternalIvml.g:2876:3: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalIvml.g:2877:4: (lv_version_1_0= RULE_VERSION )
            {
            // InternalIvml.g:2877:4: (lv_version_1_0= RULE_VERSION )
            // InternalIvml.g:2878:5: lv_version_1_0= RULE_VERSION
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
    // InternalIvml.g:2902:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // InternalIvml.g:2902:55: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // InternalIvml.g:2903:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
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
    // InternalIvml.g:2909:1: ruleOpDefStatement returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? otherlv_1= 'def' ( (lv_static_2_0= 'static' ) )? ( (lv_result_3_0= ruleType ) ) ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleOpDefParameterList ) ) otherlv_7= ')' otherlv_8= '=' ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleOpDefStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_static_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_result_3_0 = null;

        AntlrDatatypeRuleToken lv_id_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_impl_9_0 = null;

        EObject lv_block_11_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:2915:2: ( ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? otherlv_1= 'def' ( (lv_static_2_0= 'static' ) )? ( (lv_result_3_0= ruleType ) ) ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleOpDefParameterList ) ) otherlv_7= ')' otherlv_8= '=' ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) ) ) )
            // InternalIvml.g:2916:2: ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? otherlv_1= 'def' ( (lv_static_2_0= 'static' ) )? ( (lv_result_3_0= ruleType ) ) ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleOpDefParameterList ) ) otherlv_7= ')' otherlv_8= '=' ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) ) )
            {
            // InternalIvml.g:2916:2: ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? otherlv_1= 'def' ( (lv_static_2_0= 'static' ) )? ( (lv_result_3_0= ruleType ) ) ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleOpDefParameterList ) ) otherlv_7= ')' otherlv_8= '=' ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:2917:3: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? otherlv_1= 'def' ( (lv_static_2_0= 'static' ) )? ( (lv_result_3_0= ruleType ) ) ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleOpDefParameterList ) ) otherlv_7= ')' otherlv_8= '=' ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) )
            {
            // InternalIvml.g:2917:3: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==60) ) {
                alt51=1;
            }
            else if ( (LA51_0==58) ) {
                int LA51_2 = input.LA(2);

                if ( (synpred78_InternalIvml()) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // InternalIvml.g:2918:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
                    {
                    // InternalIvml.g:2918:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
                    // InternalIvml.g:2919:5: lv_annotations_0_0= ruleAnnotationDeclarations
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOpDefStatementAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_44);
                    lv_annotations_0_0=ruleAnnotationDeclarations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      					}
                      					set(
                      						current,
                      						"annotations",
                      						lv_annotations_0_0,
                      						"de.uni_hildesheim.sse.Ivml.AnnotationDeclarations");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,58,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getOpDefStatementAccess().getDefKeyword_1());
              		
            }
            // InternalIvml.g:2940:3: ( (lv_static_2_0= 'static' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==59) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalIvml.g:2941:4: (lv_static_2_0= 'static' )
                    {
                    // InternalIvml.g:2941:4: (lv_static_2_0= 'static' )
                    // InternalIvml.g:2942:5: lv_static_2_0= 'static'
                    {
                    lv_static_2_0=(Token)match(input,59,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_static_2_0, grammarAccess.getOpDefStatementAccess().getStaticStaticKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getOpDefStatementRule());
                      					}
                      					setWithLastConsumed(current, "static", lv_static_2_0, "static");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:2954:3: ( (lv_result_3_0= ruleType ) )
            // InternalIvml.g:2955:4: (lv_result_3_0= ruleType )
            {
            // InternalIvml.g:2955:4: (lv_result_3_0= ruleType )
            // InternalIvml.g:2956:5: lv_result_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_result_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              					}
              					set(
              						current,
              						"result",
              						lv_result_3_0,
              						"de.uni_hildesheim.sse.Ivml.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIvml.g:2973:3: ( (lv_id_4_0= ruleIdentifier ) )
            // InternalIvml.g:2974:4: (lv_id_4_0= ruleIdentifier )
            {
            // InternalIvml.g:2974:4: (lv_id_4_0= ruleIdentifier )
            // InternalIvml.g:2975:5: lv_id_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_id_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              					}
              					set(
              						current,
              						"id",
              						lv_id_4_0,
              						"de.uni_hildesheim.sse.Ivml.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_5());
              		
            }
            // InternalIvml.g:2996:3: ( (lv_param_6_0= ruleOpDefParameterList ) )
            // InternalIvml.g:2997:4: (lv_param_6_0= ruleOpDefParameterList )
            {
            // InternalIvml.g:2997:4: (lv_param_6_0= ruleOpDefParameterList )
            // InternalIvml.g:2998:5: lv_param_6_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_param_6_0=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              					}
              					set(
              						current,
              						"param",
              						lv_param_6_0,
              						"de.uni_hildesheim.sse.Ivml.OpDefParameterList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_7());
              		
            }
            otherlv_8=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_8());
              		
            }
            // InternalIvml.g:3023:3: ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) )
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // InternalIvml.g:3024:4: ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' )
                    {
                    // InternalIvml.g:3024:4: ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' )
                    // InternalIvml.g:3025:5: ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';'
                    {
                    // InternalIvml.g:3025:5: ( (lv_impl_9_0= ruleExpression ) )
                    // InternalIvml.g:3026:6: (lv_impl_9_0= ruleExpression )
                    {
                    // InternalIvml.g:3026:6: (lv_impl_9_0= ruleExpression )
                    // InternalIvml.g:3027:7: lv_impl_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_9_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_14);
                    lv_impl_9_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      							}
                      							set(
                      								current,
                      								"impl",
                      								lv_impl_9_0,
                      								"de.uni_hildesheim.sse.Ivml.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getOpDefStatementAccess().getSemicolonKeyword_9_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3050:4: ( (lv_block_11_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:3050:4: ( (lv_block_11_0= ruleBlockExpression ) )
                    // InternalIvml.g:3051:5: (lv_block_11_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:3051:5: (lv_block_11_0= ruleBlockExpression )
                    // InternalIvml.g:3052:6: lv_block_11_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOpDefStatementAccess().getBlockBlockExpressionParserRuleCall_9_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_11_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_11_0,
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


    // $ANTLR start "entryRuleAnnotationDeclarations"
    // InternalIvml.g:3074:1: entryRuleAnnotationDeclarations returns [EObject current=null] : iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF ;
    public final EObject entryRuleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationDeclarations = null;


        try {
            // InternalIvml.g:3074:63: (iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF )
            // InternalIvml.g:3075:2: iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF
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
    // InternalIvml.g:3081:1: ruleAnnotationDeclarations returns [EObject current=null] : ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3087:2: ( ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) )
            // InternalIvml.g:3088:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            {
            // InternalIvml.g:3088:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            // InternalIvml.g:3089:3: () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            {
            // InternalIvml.g:3089:3: ()
            // InternalIvml.g:3090:4: 
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

            // InternalIvml.g:3099:3: (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==60) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalIvml.g:3100:4: otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,60,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAnnotationDeclarationsAccess().getCommercialAtKeyword_1_0());
            	      			
            	    }
            	    // InternalIvml.g:3104:4: ( (lv_id_2_0= ruleIdentifier ) )
            	    // InternalIvml.g:3105:5: (lv_id_2_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:3105:5: (lv_id_2_0= ruleIdentifier )
            	    // InternalIvml.g:3106:6: lv_id_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAnnotationDeclarationsAccess().getIdIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
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
            	      							"de.uni_hildesheim.sse.Ivml.Identifier");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

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
    // $ANTLR end "ruleAnnotationDeclarations"


    // $ANTLR start "entryRuleOpDefParameterList"
    // InternalIvml.g:3128:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // InternalIvml.g:3128:59: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // InternalIvml.g:3129:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
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
    // InternalIvml.g:3135:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3141:2: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // InternalIvml.g:3142:2: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // InternalIvml.g:3142:2: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // InternalIvml.g:3143:3: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // InternalIvml.g:3143:3: ()
            // InternalIvml.g:3144:4: 
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

            // InternalIvml.g:3153:3: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_VERSION && LA56_0<=RULE_EXPONENT)||(LA56_0>=30 && LA56_0<=35)||(LA56_0>=42 && LA56_0<=44)||LA56_0==57) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalIvml.g:3154:4: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // InternalIvml.g:3154:4: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // InternalIvml.g:3155:5: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // InternalIvml.g:3155:5: (lv_list_1_0= ruleOpDefParameter )
                    // InternalIvml.g:3156:6: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_48);
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

                    // InternalIvml.g:3173:4: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==18) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalIvml.g:3174:5: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalIvml.g:3178:5: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // InternalIvml.g:3179:6: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // InternalIvml.g:3179:6: (lv_list_3_0= ruleOpDefParameter )
                    	    // InternalIvml.g:3180:7: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop55;
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
    // InternalIvml.g:3203:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // InternalIvml.g:3203:55: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // InternalIvml.g:3204:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
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
    // InternalIvml.g:3210:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3216:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:3217:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:3217:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // InternalIvml.g:3218:3: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:3218:3: ( (lv_type_0_0= ruleType ) )
            // InternalIvml.g:3219:4: (lv_type_0_0= ruleType )
            {
            // InternalIvml.g:3219:4: (lv_type_0_0= ruleType )
            // InternalIvml.g:3220:5: lv_type_0_0= ruleType
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

            // InternalIvml.g:3237:3: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:3238:4: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:3238:4: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:3239:5: lv_id_1_0= ruleIdentifier
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

            // InternalIvml.g:3256:3: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==19) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalIvml.g:3257:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalIvml.g:3261:4: ( (lv_val_3_0= ruleExpression ) )
                    // InternalIvml.g:3262:5: (lv_val_3_0= ruleExpression )
                    {
                    // InternalIvml.g:3262:5: (lv_val_3_0= ruleExpression )
                    // InternalIvml.g:3263:6: lv_val_3_0= ruleExpression
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
    // InternalIvml.g:3285:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalIvml.g:3285:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalIvml.g:3286:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalIvml.g:3292:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3298:2: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalIvml.g:3299:2: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalIvml.g:3299:2: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalIvml.g:3300:3: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalIvml.g:3300:3: ( (lv_expr_0_0= ruleExpression ) )
            // InternalIvml.g:3301:4: (lv_expr_0_0= ruleExpression )
            {
            // InternalIvml.g:3301:4: (lv_expr_0_0= ruleExpression )
            // InternalIvml.g:3302:5: lv_expr_0_0= ruleExpression
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
    // InternalIvml.g:3327:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalIvml.g:3327:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalIvml.g:3328:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalIvml.g:3334:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_container_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3340:2: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:3341:2: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:3341:2: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt58=3;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalIvml.g:3342:3: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // InternalIvml.g:3342:3: ( (lv_let_0_0= ruleLetExpression ) )
                    // InternalIvml.g:3343:4: (lv_let_0_0= ruleLetExpression )
                    {
                    // InternalIvml.g:3343:4: (lv_let_0_0= ruleLetExpression )
                    // InternalIvml.g:3344:5: lv_let_0_0= ruleLetExpression
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
                    // InternalIvml.g:3362:3: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:3362:3: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // InternalIvml.g:3363:4: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:3363:4: (lv_expr_1_0= ruleImplicationExpression )
                    // InternalIvml.g:3364:5: lv_expr_1_0= ruleImplicationExpression
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
                    // InternalIvml.g:3382:3: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:3382:3: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:3383:4: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:3383:4: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:3384:5: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionAccess().getContainerContainerInitializerParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExpressionRule());
                      					}
                      					set(
                      						current,
                      						"container",
                      						lv_container_2_0,
                      						"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
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
    // InternalIvml.g:3405:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // InternalIvml.g:3405:54: (iv_ruleLetExpression= ruleLetExpression EOF )
            // InternalIvml.g:3406:2: iv_ruleLetExpression= ruleLetExpression EOF
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
    // InternalIvml.g:3412:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) ;
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
            // InternalIvml.g:3418:2: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) )
            // InternalIvml.g:3419:2: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            {
            // InternalIvml.g:3419:2: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            // InternalIvml.g:3420:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
              		
            }
            // InternalIvml.g:3424:3: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:3425:4: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:3425:4: (lv_type_1_0= ruleType )
            // InternalIvml.g:3426:5: lv_type_1_0= ruleType
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

            // InternalIvml.g:3443:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:3444:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:3444:4: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:3445:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            otherlv_3=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalIvml.g:3466:3: ( (lv_valueExpr_4_0= ruleExpression ) )
            // InternalIvml.g:3467:4: (lv_valueExpr_4_0= ruleExpression )
            {
            // InternalIvml.g:3467:4: (lv_valueExpr_4_0= ruleExpression )
            // InternalIvml.g:3468:5: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            otherlv_5=(Token)match(input,62,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
              		
            }
            // InternalIvml.g:3489:3: ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            // InternalIvml.g:3490:4: (lv_subExpr_6_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:3490:4: (lv_subExpr_6_0= ruleOptBlockExpression )
            // InternalIvml.g:3491:5: lv_subExpr_6_0= ruleOptBlockExpression
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
    // InternalIvml.g:3512:1: entryRuleOptBlockExpression returns [EObject current=null] : iv_ruleOptBlockExpression= ruleOptBlockExpression EOF ;
    public final EObject entryRuleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptBlockExpression = null;


        try {
            // InternalIvml.g:3512:59: (iv_ruleOptBlockExpression= ruleOptBlockExpression EOF )
            // InternalIvml.g:3513:2: iv_ruleOptBlockExpression= ruleOptBlockExpression EOF
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
    // InternalIvml.g:3519:1: ruleOptBlockExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_block_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3525:2: ( ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:3526:2: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            {
            // InternalIvml.g:3526:2: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // InternalIvml.g:3527:3: ( (lv_expr_0_0= ruleExpression ) )
                    {
                    // InternalIvml.g:3527:3: ( (lv_expr_0_0= ruleExpression ) )
                    // InternalIvml.g:3528:4: (lv_expr_0_0= ruleExpression )
                    {
                    // InternalIvml.g:3528:4: (lv_expr_0_0= ruleExpression )
                    // InternalIvml.g:3529:5: lv_expr_0_0= ruleExpression
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
                    // InternalIvml.g:3547:3: ( (lv_block_1_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:3547:3: ( (lv_block_1_0= ruleBlockExpression ) )
                    // InternalIvml.g:3548:4: (lv_block_1_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:3548:4: (lv_block_1_0= ruleBlockExpression )
                    // InternalIvml.g:3549:5: lv_block_1_0= ruleBlockExpression
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
    // InternalIvml.g:3570:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalIvml.g:3570:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalIvml.g:3571:2: iv_ruleBlockExpression= ruleBlockExpression EOF
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
    // InternalIvml.g:3577:1: ruleBlockExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exprs_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3583:2: ( (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) )
            // InternalIvml.g:3584:2: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            {
            // InternalIvml.g:3584:2: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            // InternalIvml.g:3585:3: otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalIvml.g:3589:3: ( (lv_exprs_1_0= ruleExpressionStatement ) )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=RULE_NUMBER && LA60_0<=RULE_EXPONENT)||LA60_0==14||LA60_0==24||(LA60_0>=30 && LA60_0<=35)||(LA60_0>=38 && LA60_0<=44)||LA60_0==55||LA60_0==57||LA60_0==61||(LA60_0>=63 && LA60_0<=78)||(LA60_0>=82 && LA60_0<=83)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalIvml.g:3590:4: (lv_exprs_1_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:3590:4: (lv_exprs_1_0= ruleExpressionStatement )
            	    // InternalIvml.g:3591:5: lv_exprs_1_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockExpressionAccess().getExprsExpressionStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_39);
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
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // InternalIvml.g:3616:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalIvml.g:3616:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalIvml.g:3617:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalIvml.g:3623:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3629:2: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // InternalIvml.g:3630:2: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // InternalIvml.g:3630:2: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // InternalIvml.g:3631:3: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // InternalIvml.g:3631:3: ( (lv_left_0_0= ruleLogicalExpression ) )
            // InternalIvml.g:3632:4: (lv_left_0_0= ruleLogicalExpression )
            {
            // InternalIvml.g:3632:4: (lv_left_0_0= ruleLogicalExpression )
            // InternalIvml.g:3633:5: lv_left_0_0= ruleLogicalExpression
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

            // InternalIvml.g:3650:3: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==19) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalIvml.g:3651:4: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // InternalIvml.g:3651:4: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // InternalIvml.g:3652:5: lv_right_1_0= ruleAssignmentExpressionPart
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
    // InternalIvml.g:3673:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // InternalIvml.g:3673:65: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // InternalIvml.g:3674:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
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
    // InternalIvml.g:3680:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_container_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3686:2: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:3687:2: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:3687:2: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:3688:3: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:3688:3: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // InternalIvml.g:3689:4: (lv_op_0_0= ruleAssignmentOperator )
            {
            // InternalIvml.g:3689:4: (lv_op_0_0= ruleAssignmentOperator )
            // InternalIvml.g:3690:5: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalIvml.g:3707:3: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalIvml.g:3708:4: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // InternalIvml.g:3708:4: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // InternalIvml.g:3709:5: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:3709:5: (lv_ex_1_0= ruleLogicalExpression )
                    // InternalIvml.g:3710:6: lv_ex_1_0= ruleLogicalExpression
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
                    // InternalIvml.g:3728:4: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:3728:4: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:3729:5: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:3729:5: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:3730:6: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getContainerContainerInitializerParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
                      						}
                      						set(
                      							current,
                      							"container",
                      							lv_container_2_0,
                      							"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
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
    // InternalIvml.g:3752:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // InternalIvml.g:3752:58: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalIvml.g:3753:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
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
    // InternalIvml.g:3759:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:3765:2: (kw= '=' )
            // InternalIvml.g:3766:2: kw= '='
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
    // InternalIvml.g:3774:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // InternalIvml.g:3774:62: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // InternalIvml.g:3775:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
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
    // InternalIvml.g:3781:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3787:2: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // InternalIvml.g:3788:2: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // InternalIvml.g:3788:2: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // InternalIvml.g:3789:3: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // InternalIvml.g:3789:3: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3790:4: (lv_left_0_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3790:4: (lv_left_0_0= ruleAssignmentExpression )
            // InternalIvml.g:3791:5: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_50);
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

            // InternalIvml.g:3808:3: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=63 && LA63_0<=64)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalIvml.g:3809:4: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // InternalIvml.g:3809:4: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // InternalIvml.g:3810:5: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_50);
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
            	    break loop63;
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
    // InternalIvml.g:3831:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // InternalIvml.g:3831:66: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // InternalIvml.g:3832:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
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
    // InternalIvml.g:3838:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3844:2: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // InternalIvml.g:3845:2: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // InternalIvml.g:3845:2: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // InternalIvml.g:3846:3: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // InternalIvml.g:3846:3: ( (lv_op_0_0= ruleImplicationOperator ) )
            // InternalIvml.g:3847:4: (lv_op_0_0= ruleImplicationOperator )
            {
            // InternalIvml.g:3847:4: (lv_op_0_0= ruleImplicationOperator )
            // InternalIvml.g:3848:5: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalIvml.g:3865:3: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3866:4: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3866:4: (lv_ex_1_0= ruleAssignmentExpression )
            // InternalIvml.g:3867:5: lv_ex_1_0= ruleAssignmentExpression
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
    // InternalIvml.g:3888:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // InternalIvml.g:3888:59: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // InternalIvml.g:3889:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
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
    // InternalIvml.g:3895:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:3901:2: ( (kw= 'implies' | kw= 'iff' ) )
            // InternalIvml.g:3902:2: (kw= 'implies' | kw= 'iff' )
            {
            // InternalIvml.g:3902:2: (kw= 'implies' | kw= 'iff' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==63) ) {
                alt64=1;
            }
            else if ( (LA64_0==64) ) {
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
                    // InternalIvml.g:3903:3: kw= 'implies'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3909:3: kw= 'iff'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:3918:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalIvml.g:3918:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalIvml.g:3919:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalIvml.g:3925:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3931:2: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalIvml.g:3932:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalIvml.g:3932:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalIvml.g:3933:3: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalIvml.g:3933:3: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalIvml.g:3934:4: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3934:4: (lv_left_0_0= ruleEqualityExpression )
            // InternalIvml.g:3935:5: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_51);
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

            // InternalIvml.g:3952:3: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=65 && LA65_0<=67)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalIvml.g:3953:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalIvml.g:3953:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalIvml.g:3954:5: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_51);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // InternalIvml.g:3975:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalIvml.g:3975:62: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalIvml.g:3976:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalIvml.g:3982:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:3988:2: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalIvml.g:3989:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalIvml.g:3989:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalIvml.g:3990:3: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalIvml.g:3990:3: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalIvml.g:3991:4: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalIvml.g:3991:4: (lv_op_0_0= ruleLogicalOperator )
            // InternalIvml.g:3992:5: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalIvml.g:4009:3: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalIvml.g:4010:4: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalIvml.g:4010:4: (lv_ex_1_0= ruleEqualityExpression )
            // InternalIvml.g:4011:5: lv_ex_1_0= ruleEqualityExpression
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
    // InternalIvml.g:4032:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalIvml.g:4032:55: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalIvml.g:4033:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalIvml.g:4039:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4045:2: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // InternalIvml.g:4046:2: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // InternalIvml.g:4046:2: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt66=1;
                }
                break;
            case 66:
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
                    // InternalIvml.g:4047:3: kw= 'and'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4053:3: kw= 'or'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4059:3: kw= 'xor'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4068:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalIvml.g:4068:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalIvml.g:4069:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalIvml.g:4075:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4081:2: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalIvml.g:4082:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalIvml.g:4082:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalIvml.g:4083:3: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalIvml.g:4083:3: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalIvml.g:4084:4: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalIvml.g:4084:4: (lv_left_0_0= ruleRelationalExpression )
            // InternalIvml.g:4085:5: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_52);
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

            // InternalIvml.g:4102:3: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=68 && LA67_0<=70)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalIvml.g:4103:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalIvml.g:4103:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalIvml.g:4104:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalIvml.g:4125:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalIvml.g:4125:63: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalIvml.g:4126:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalIvml.g:4132:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_container_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4138:2: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:4139:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:4139:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:4140:3: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:4140:3: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalIvml.g:4141:4: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalIvml.g:4141:4: (lv_op_0_0= ruleEqualityOperator )
            // InternalIvml.g:4142:5: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalIvml.g:4159:3: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // InternalIvml.g:4160:4: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // InternalIvml.g:4160:4: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // InternalIvml.g:4161:5: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // InternalIvml.g:4161:5: (lv_ex_1_0= ruleRelationalExpression )
                    // InternalIvml.g:4162:6: lv_ex_1_0= ruleRelationalExpression
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
                    // InternalIvml.g:4180:4: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:4180:4: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:4181:5: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:4181:5: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:4182:6: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getContainerContainerInitializerParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEqualityExpressionPartRule());
                      						}
                      						set(
                      							current,
                      							"container",
                      							lv_container_2_0,
                      							"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
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
    // InternalIvml.g:4204:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalIvml.g:4204:56: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalIvml.g:4205:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalIvml.g:4211:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4217:2: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalIvml.g:4218:2: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalIvml.g:4218:2: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt69=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt69=1;
                }
                break;
            case 69:
                {
                alt69=2;
                }
                break;
            case 70:
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
                    // InternalIvml.g:4219:3: kw= '=='
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4225:3: kw= '<>'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4231:3: kw= '!='
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4240:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalIvml.g:4240:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalIvml.g:4241:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalIvml.g:4247:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4253:2: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalIvml.g:4254:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalIvml.g:4254:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalIvml.g:4255:3: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalIvml.g:4255:3: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4256:4: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4256:4: (lv_left_0_0= ruleAdditiveExpression )
            // InternalIvml.g:4257:5: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_53);
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

            // InternalIvml.g:4274:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=71 && LA71_0<=74)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalIvml.g:4275:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalIvml.g:4275:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalIvml.g:4276:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalIvml.g:4276:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalIvml.g:4277:6: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
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

                    // InternalIvml.g:4294:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=71 && LA70_0<=74)) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalIvml.g:4295:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalIvml.g:4295:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalIvml.g:4296:6: lv_right2_2_0= ruleRelationalExpressionPart
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
                              							"de.uni_hildesheim.sse.Ivml.RelationalExpressionPart");
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
    // InternalIvml.g:4318:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalIvml.g:4318:65: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalIvml.g:4319:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalIvml.g:4325:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4331:2: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalIvml.g:4332:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalIvml.g:4332:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalIvml.g:4333:3: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalIvml.g:4333:3: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalIvml.g:4334:4: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalIvml.g:4334:4: (lv_op_0_0= ruleRelationalOperator )
            // InternalIvml.g:4335:5: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalIvml.g:4352:3: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4353:4: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4353:4: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalIvml.g:4354:5: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalIvml.g:4375:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalIvml.g:4375:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalIvml.g:4376:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalIvml.g:4382:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4388:2: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalIvml.g:4389:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalIvml.g:4389:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt72=4;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt72=1;
                }
                break;
            case 72:
                {
                alt72=2;
                }
                break;
            case 73:
                {
                alt72=3;
                }
                break;
            case 74:
                {
                alt72=4;
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
                    // InternalIvml.g:4390:3: kw= '>'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4396:3: kw= '<'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4402:3: kw= '>='
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalIvml.g:4408:3: kw= '<='
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4417:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalIvml.g:4417:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalIvml.g:4418:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalIvml.g:4424:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4430:2: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalIvml.g:4431:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalIvml.g:4431:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalIvml.g:4432:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalIvml.g:4432:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4433:4: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4433:4: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4434:5: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_54);
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

            // InternalIvml.g:4451:3: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=75 && LA73_0<=76)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalIvml.g:4452:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalIvml.g:4452:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalIvml.g:4453:5: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_54);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // InternalIvml.g:4474:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalIvml.g:4474:63: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalIvml.g:4475:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalIvml.g:4481:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4487:2: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalIvml.g:4488:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalIvml.g:4488:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalIvml.g:4489:3: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalIvml.g:4489:3: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalIvml.g:4490:4: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalIvml.g:4490:4: (lv_op_0_0= ruleAdditiveOperator )
            // InternalIvml.g:4491:5: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalIvml.g:4508:3: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4509:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4509:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4510:5: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalIvml.g:4531:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalIvml.g:4531:56: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalIvml.g:4532:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalIvml.g:4538:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4544:2: ( (kw= '+' | kw= '-' ) )
            // InternalIvml.g:4545:2: (kw= '+' | kw= '-' )
            {
            // InternalIvml.g:4545:2: (kw= '+' | kw= '-' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==75) ) {
                alt74=1;
            }
            else if ( (LA74_0==76) ) {
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
                    // InternalIvml.g:4546:3: kw= '+'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4552:3: kw= '-'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4561:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalIvml.g:4561:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalIvml.g:4562:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalIvml.g:4568:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4574:2: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalIvml.g:4575:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalIvml.g:4575:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalIvml.g:4576:3: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalIvml.g:4576:3: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalIvml.g:4577:4: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4577:4: (lv_left_0_0= ruleUnaryExpression )
            // InternalIvml.g:4578:5: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_55);
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

            // InternalIvml.g:4595:3: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==55||LA75_0==77) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalIvml.g:4596:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalIvml.g:4596:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalIvml.g:4597:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalIvml.g:4618:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalIvml.g:4618:69: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalIvml.g:4619:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalIvml.g:4625:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4631:2: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalIvml.g:4632:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalIvml.g:4632:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalIvml.g:4633:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalIvml.g:4633:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalIvml.g:4634:4: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalIvml.g:4634:4: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalIvml.g:4635:5: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            // InternalIvml.g:4652:3: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalIvml.g:4653:4: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4653:4: (lv_expr_1_0= ruleUnaryExpression )
            // InternalIvml.g:4654:5: lv_expr_1_0= ruleUnaryExpression
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
    // InternalIvml.g:4675:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalIvml.g:4675:62: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalIvml.g:4676:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalIvml.g:4682:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4688:2: ( (kw= '*' | kw= '/' ) )
            // InternalIvml.g:4689:2: (kw= '*' | kw= '/' )
            {
            // InternalIvml.g:4689:2: (kw= '*' | kw= '/' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==55) ) {
                alt76=1;
            }
            else if ( (LA76_0==77) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalIvml.g:4690:3: kw= '*'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4696:3: kw= '/'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4705:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalIvml.g:4705:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalIvml.g:4706:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalIvml.g:4712:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4718:2: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalIvml.g:4719:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalIvml.g:4719:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalIvml.g:4720:3: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalIvml.g:4720:3: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalIvml.g:4721:4: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalIvml.g:4721:4: (lv_op_0_0= ruleUnaryOperator )
                    // InternalIvml.g:4722:5: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_26);
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

            // InternalIvml.g:4739:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalIvml.g:4740:4: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalIvml.g:4740:4: (lv_expr_1_0= rulePostfixExpression )
            // InternalIvml.g:4741:5: lv_expr_1_0= rulePostfixExpression
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
    // InternalIvml.g:4762:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalIvml.g:4762:53: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalIvml.g:4763:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalIvml.g:4769:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:4775:2: ( (kw= 'not' | kw= '-' ) )
            // InternalIvml.g:4776:2: (kw= 'not' | kw= '-' )
            {
            // InternalIvml.g:4776:2: (kw= 'not' | kw= '-' )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==78) ) {
                alt78=1;
            }
            else if ( (LA78_0==76) ) {
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
                    // InternalIvml.g:4777:3: kw= 'not'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4783:3: kw= '-'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4792:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalIvml.g:4792:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalIvml.g:4793:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalIvml.g:4799:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4805:2: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // InternalIvml.g:4806:2: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // InternalIvml.g:4806:2: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt81=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA81_1 = input.LA(2);

                if ( (LA81_1==EOF||(LA81_1>=15 && LA81_1<=16)||(LA81_1>=18 && LA81_1<=19)||(LA81_1>=25 && LA81_1<=26)||(LA81_1>=36 && LA81_1<=37)||LA81_1==49||LA81_1==55||(LA81_1>=62 && LA81_1<=77)||(LA81_1>=79 && LA81_1<=81)||(LA81_1>=84 && LA81_1<=86)) ) {
                    alt81=2;
                }
                else if ( (LA81_1==24) ) {
                    alt81=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA81_2 = input.LA(2);

                if ( (LA81_2==24) ) {
                    alt81=1;
                }
                else if ( (LA81_2==EOF||(LA81_2>=15 && LA81_2<=16)||(LA81_2>=18 && LA81_2<=19)||(LA81_2>=25 && LA81_2<=26)||(LA81_2>=36 && LA81_2<=37)||LA81_2==49||LA81_2==55||(LA81_2>=62 && LA81_2<=77)||(LA81_2>=79 && LA81_2<=81)||(LA81_2>=84 && LA81_2<=86)) ) {
                    alt81=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA81_3 = input.LA(2);

                if ( (LA81_3==EOF||(LA81_3>=15 && LA81_3<=16)||(LA81_3>=18 && LA81_3<=19)||(LA81_3>=25 && LA81_3<=26)||(LA81_3>=36 && LA81_3<=37)||LA81_3==49||LA81_3==55||(LA81_3>=62 && LA81_3<=77)||(LA81_3>=79 && LA81_3<=81)||(LA81_3>=84 && LA81_3<=86)) ) {
                    alt81=2;
                }
                else if ( (LA81_3==24) ) {
                    alt81=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 3, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA81_4 = input.LA(2);

                if ( (LA81_4==EOF||(LA81_4>=15 && LA81_4<=16)||(LA81_4>=18 && LA81_4<=19)||(LA81_4>=25 && LA81_4<=26)||(LA81_4>=36 && LA81_4<=37)||LA81_4==49||LA81_4==55||(LA81_4>=62 && LA81_4<=77)||(LA81_4>=79 && LA81_4<=81)||(LA81_4>=84 && LA81_4<=86)) ) {
                    alt81=2;
                }
                else if ( (LA81_4==24) ) {
                    alt81=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 4, input);

                    throw nvae;
                }
                }
                break;
            case 55:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                {
                alt81=1;
                }
                break;
            case RULE_NUMBER:
            case RULE_STRING:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 82:
            case 83:
                {
                alt81=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalIvml.g:4807:3: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // InternalIvml.g:4807:3: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // InternalIvml.g:4808:4: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // InternalIvml.g:4808:4: ( (lv_call_0_0= ruleFeatureCall ) )
                    // InternalIvml.g:4809:5: (lv_call_0_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4809:5: (lv_call_0_0= ruleFeatureCall )
                    // InternalIvml.g:4810:6: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
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

                    // InternalIvml.g:4827:4: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==37) ) {
                            switch ( input.LA(2) ) {
                            case RULE_ID:
                                {
                                int LA79_4 = input.LA(3);

                                if ( (LA79_4==24) ) {
                                    alt79=1;
                                }


                                }
                                break;
                            case RULE_VERSION:
                                {
                                int LA79_5 = input.LA(3);

                                if ( (LA79_5==24) ) {
                                    alt79=1;
                                }


                                }
                                break;
                            case RULE_EXPONENT:
                                {
                                int LA79_6 = input.LA(3);

                                if ( (LA79_6==24) ) {
                                    alt79=1;
                                }


                                }
                                break;
                            case 57:
                                {
                                int LA79_7 = input.LA(3);

                                if ( (LA79_7==24) ) {
                                    alt79=1;
                                }


                                }
                                break;
                            case 55:
                            case 63:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                            case 76:
                            case 77:
                            case 78:
                                {
                                alt79=1;
                                }
                                break;

                            }

                        }
                        else if ( ((LA79_0>=79 && LA79_0<=80)) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalIvml.g:4828:5: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // InternalIvml.g:4828:5: (lv_fCalls_1_0= ruleCall )
                    	    // InternalIvml.g:4829:6: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_56);
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
                    	    break loop79;
                        }
                    } while (true);

                    // InternalIvml.g:4846:4: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==37) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalIvml.g:4847:5: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // InternalIvml.g:4847:5: (lv_access_2_0= ruleExpressionAccess )
                            // InternalIvml.g:4848:6: lv_access_2_0= ruleExpressionAccess
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
                    // InternalIvml.g:4867:3: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // InternalIvml.g:4867:3: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // InternalIvml.g:4868:4: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // InternalIvml.g:4868:4: (lv_left_3_0= rulePrimaryExpression )
                    // InternalIvml.g:4869:5: lv_left_3_0= rulePrimaryExpression
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
    // InternalIvml.g:4890:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalIvml.g:4890:45: (iv_ruleCall= ruleCall EOF )
            // InternalIvml.g:4891:2: iv_ruleCall= ruleCall EOF
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
    // InternalIvml.g:4897:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_call_1_0 = null;

        EObject lv_containerOp_3_0 = null;

        EObject lv_arrayEx_5_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:4903:2: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // InternalIvml.g:4904:2: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // InternalIvml.g:4904:2: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt82=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt82=1;
                }
                break;
            case 79:
                {
                alt82=2;
                }
                break;
            case 80:
                {
                alt82=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalIvml.g:4905:3: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // InternalIvml.g:4905:3: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // InternalIvml.g:4906:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                      			
                    }
                    // InternalIvml.g:4910:4: ( (lv_call_1_0= ruleFeatureCall ) )
                    // InternalIvml.g:4911:5: (lv_call_1_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4911:5: (lv_call_1_0= ruleFeatureCall )
                    // InternalIvml.g:4912:6: lv_call_1_0= ruleFeatureCall
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
                    // InternalIvml.g:4931:3: (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) )
                    {
                    // InternalIvml.g:4931:3: (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) )
                    // InternalIvml.g:4932:4: otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) )
                    {
                    otherlv_2=(Token)match(input,79,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                      			
                    }
                    // InternalIvml.g:4936:4: ( (lv_containerOp_3_0= ruleContainerOp ) )
                    // InternalIvml.g:4937:5: (lv_containerOp_3_0= ruleContainerOp )
                    {
                    // InternalIvml.g:4937:5: (lv_containerOp_3_0= ruleContainerOp )
                    // InternalIvml.g:4938:6: lv_containerOp_3_0= ruleContainerOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallAccess().getContainerOpContainerOpParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_containerOp_3_0=ruleContainerOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCallRule());
                      						}
                      						set(
                      							current,
                      							"containerOp",
                      							lv_containerOp_3_0,
                      							"de.uni_hildesheim.sse.Ivml.ContainerOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:4957:3: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // InternalIvml.g:4957:3: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // InternalIvml.g:4958:4: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,80,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalIvml.g:4962:4: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // InternalIvml.g:4963:5: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // InternalIvml.g:4963:5: (lv_arrayEx_5_0= ruleExpression )
                    // InternalIvml.g:4964:6: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_58);
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

                    otherlv_6=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:4990:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalIvml.g:4990:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalIvml.g:4991:2: iv_ruleFeatureCall= ruleFeatureCall EOF
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
    // InternalIvml.g:4997:1: ruleFeatureCall returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject this_ActualArgumentList_9 = null;



        	enterRule();

        try {
            // InternalIvml.g:5003:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' ) )
            // InternalIvml.g:5004:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' )
            {
            // InternalIvml.g:5004:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' )
            // InternalIvml.g:5005:3: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')'
            {
            // InternalIvml.g:5005:3: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) )
            int alt83=8;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 57:
                {
                alt83=1;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt83=2;
                }
                break;
            case 75:
            case 76:
                {
                alt83=3;
                }
                break;
            case 55:
            case 77:
                {
                alt83=4;
                }
                break;
            case 68:
            case 69:
            case 70:
                {
                alt83=5;
                }
                break;
            case 63:
            case 64:
                {
                alt83=6;
                }
                break;
            case 65:
            case 66:
            case 67:
                {
                alt83=7;
                }
                break;
            case 78:
                {
                alt83=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalIvml.g:5006:4: ( (lv_name_0_0= ruleIdentifier ) )
                    {
                    // InternalIvml.g:5006:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5007:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5007:5: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5008:6: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
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


                    }
                    break;
                case 2 :
                    // InternalIvml.g:5026:4: ( (lv_name_1_0= ruleRelationalOperator ) )
                    {
                    // InternalIvml.g:5026:4: ( (lv_name_1_0= ruleRelationalOperator ) )
                    // InternalIvml.g:5027:5: (lv_name_1_0= ruleRelationalOperator )
                    {
                    // InternalIvml.g:5027:5: (lv_name_1_0= ruleRelationalOperator )
                    // InternalIvml.g:5028:6: lv_name_1_0= ruleRelationalOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameRelationalOperatorParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_1_0=ruleRelationalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_0,
                      							"de.uni_hildesheim.sse.Ivml.RelationalOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:5046:4: ( (lv_name_2_0= ruleAdditiveOperator ) )
                    {
                    // InternalIvml.g:5046:4: ( (lv_name_2_0= ruleAdditiveOperator ) )
                    // InternalIvml.g:5047:5: (lv_name_2_0= ruleAdditiveOperator )
                    {
                    // InternalIvml.g:5047:5: (lv_name_2_0= ruleAdditiveOperator )
                    // InternalIvml.g:5048:6: lv_name_2_0= ruleAdditiveOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameAdditiveOperatorParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_2_0=ruleAdditiveOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"de.uni_hildesheim.sse.Ivml.AdditiveOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:5066:4: ( (lv_name_3_0= ruleMultiplicativeOperator ) )
                    {
                    // InternalIvml.g:5066:4: ( (lv_name_3_0= ruleMultiplicativeOperator ) )
                    // InternalIvml.g:5067:5: (lv_name_3_0= ruleMultiplicativeOperator )
                    {
                    // InternalIvml.g:5067:5: (lv_name_3_0= ruleMultiplicativeOperator )
                    // InternalIvml.g:5068:6: lv_name_3_0= ruleMultiplicativeOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameMultiplicativeOperatorParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_3_0=ruleMultiplicativeOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.uni_hildesheim.sse.Ivml.MultiplicativeOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalIvml.g:5086:4: ( (lv_name_4_0= ruleEqualityOperator ) )
                    {
                    // InternalIvml.g:5086:4: ( (lv_name_4_0= ruleEqualityOperator ) )
                    // InternalIvml.g:5087:5: (lv_name_4_0= ruleEqualityOperator )
                    {
                    // InternalIvml.g:5087:5: (lv_name_4_0= ruleEqualityOperator )
                    // InternalIvml.g:5088:6: lv_name_4_0= ruleEqualityOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameEqualityOperatorParserRuleCall_0_4_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_4_0=ruleEqualityOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_4_0,
                      							"de.uni_hildesheim.sse.Ivml.EqualityOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalIvml.g:5106:4: ( (lv_name_5_0= ruleImplicationOperator ) )
                    {
                    // InternalIvml.g:5106:4: ( (lv_name_5_0= ruleImplicationOperator ) )
                    // InternalIvml.g:5107:5: (lv_name_5_0= ruleImplicationOperator )
                    {
                    // InternalIvml.g:5107:5: (lv_name_5_0= ruleImplicationOperator )
                    // InternalIvml.g:5108:6: lv_name_5_0= ruleImplicationOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameImplicationOperatorParserRuleCall_0_5_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_5_0=ruleImplicationOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_5_0,
                      							"de.uni_hildesheim.sse.Ivml.ImplicationOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalIvml.g:5126:4: ( (lv_name_6_0= ruleLogicalOperator ) )
                    {
                    // InternalIvml.g:5126:4: ( (lv_name_6_0= ruleLogicalOperator ) )
                    // InternalIvml.g:5127:5: (lv_name_6_0= ruleLogicalOperator )
                    {
                    // InternalIvml.g:5127:5: (lv_name_6_0= ruleLogicalOperator )
                    // InternalIvml.g:5128:6: lv_name_6_0= ruleLogicalOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeatureCallAccess().getNameLogicalOperatorParserRuleCall_0_6_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_6_0=ruleLogicalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_6_0,
                      							"de.uni_hildesheim.sse.Ivml.LogicalOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalIvml.g:5146:4: ( (lv_name_7_0= 'not' ) )
                    {
                    // InternalIvml.g:5146:4: ( (lv_name_7_0= 'not' ) )
                    // InternalIvml.g:5147:5: (lv_name_7_0= 'not' )
                    {
                    // InternalIvml.g:5147:5: (lv_name_7_0= 'not' )
                    // InternalIvml.g:5148:6: lv_name_7_0= 'not'
                    {
                    lv_name_7_0=(Token)match(input,78,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_7_0, grammarAccess.getFeatureCallAccess().getNameNotKeyword_0_7_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFeatureCallRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_7_0, "not");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,24,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIvml.g:5165:3: (this_ActualArgumentList_9= ruleActualArgumentList[$current] )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_NUMBER && LA84_0<=RULE_EXPONENT)||LA84_0==14||LA84_0==24||(LA84_0>=30 && LA84_0<=35)||(LA84_0>=38 && LA84_0<=44)||LA84_0==55||LA84_0==57||LA84_0==61||(LA84_0>=63 && LA84_0<=78)||(LA84_0>=82 && LA84_0<=83)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalIvml.g:5166:4: this_ActualArgumentList_9= ruleActualArgumentList[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getFeatureCallRule());
                      				}
                      				newCompositeNode(grammarAccess.getFeatureCallAccess().getActualArgumentListParserRuleCall_2());
                      			
                    }
                    pushFollow(FOLLOW_29);
                    this_ActualArgumentList_9=ruleActualArgumentList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ActualArgumentList_9;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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


    // $ANTLR start "entryRuleContainerOp"
    // InternalIvml.g:5189:1: entryRuleContainerOp returns [EObject current=null] : iv_ruleContainerOp= ruleContainerOp EOF ;
    public final EObject entryRuleContainerOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerOp = null;


        try {
            // InternalIvml.g:5189:52: (iv_ruleContainerOp= ruleContainerOp EOF )
            // InternalIvml.g:5190:2: iv_ruleContainerOp= ruleContainerOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainerOp=ruleContainerOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerOp; 
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
    // $ANTLR end "entryRuleContainerOp"


    // $ANTLR start "ruleContainerOp"
    // InternalIvml.g:5196:1: ruleContainerOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' ) ;
    public final EObject ruleContainerOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject this_ActualArgumentList_3 = null;



        	enterRule();

        try {
            // InternalIvml.g:5202:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' ) )
            // InternalIvml.g:5203:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' )
            {
            // InternalIvml.g:5203:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' )
            // InternalIvml.g:5204:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')'
            {
            // InternalIvml.g:5204:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:5205:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:5205:4: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:5206:5: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainerOpAccess().getNameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContainerOpRule());
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

            otherlv_1=(Token)match(input,24,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getContainerOpAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIvml.g:5227:3: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt85=2;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // InternalIvml.g:5228:4: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalIvml.g:5228:4: (lv_decl_2_0= ruleDeclarator )
                    // InternalIvml.g:5229:5: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContainerOpAccess().getDeclDeclaratorParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_59);
                    lv_decl_2_0=ruleDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContainerOpRule());
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

            // InternalIvml.g:5246:3: (this_ActualArgumentList_3= ruleActualArgumentList[$current] )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=RULE_NUMBER && LA86_0<=RULE_EXPONENT)||LA86_0==14||LA86_0==24||(LA86_0>=30 && LA86_0<=35)||(LA86_0>=38 && LA86_0<=44)||LA86_0==55||LA86_0==57||LA86_0==61||(LA86_0>=63 && LA86_0<=78)||(LA86_0>=82 && LA86_0<=83)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalIvml.g:5247:4: this_ActualArgumentList_3= ruleActualArgumentList[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getContainerOpRule());
                      				}
                      				newCompositeNode(grammarAccess.getContainerOpAccess().getActualArgumentListParserRuleCall_3());
                      			
                    }
                    pushFollow(FOLLOW_29);
                    this_ActualArgumentList_3=ruleActualArgumentList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ActualArgumentList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getContainerOpAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainerOp"


    // $ANTLR start "entryRuleDeclarator"
    // InternalIvml.g:5270:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalIvml.g:5270:51: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalIvml.g:5271:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalIvml.g:5277:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5283:2: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalIvml.g:5284:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalIvml.g:5284:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalIvml.g:5285:3: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalIvml.g:5285:3: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalIvml.g:5286:4: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalIvml.g:5286:4: (lv_decl_0_0= ruleDeclaration )
            // InternalIvml.g:5287:5: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_60);
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

            // InternalIvml.g:5304:3: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==16) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalIvml.g:5305:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalIvml.g:5309:4: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalIvml.g:5310:5: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalIvml.g:5310:5: (lv_decl_2_0= ruleDeclaration )
            	    // InternalIvml.g:5311:6: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
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
            	    break loop87;
                }
            } while (true);

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:5337:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalIvml.g:5337:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalIvml.g:5338:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalIvml.g:5344:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
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
            // InternalIvml.g:5350:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:5351:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:5351:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // InternalIvml.g:5352:3: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:5352:3: ( (lv_type_0_0= ruleType ) )?
            int alt88=2;
            switch ( input.LA(1) ) {
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 42:
                case 43:
                case 44:
                    {
                    alt88=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA88_2 = input.LA(2);

                    if ( ((LA88_2>=RULE_VERSION && LA88_2<=RULE_EXPONENT)||LA88_2==36||LA88_2==57) ) {
                        alt88=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA88_3 = input.LA(2);

                    if ( ((LA88_3>=RULE_VERSION && LA88_3<=RULE_EXPONENT)||LA88_3==36||LA88_3==57) ) {
                        alt88=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA88_4 = input.LA(2);

                    if ( ((LA88_4>=RULE_VERSION && LA88_4<=RULE_EXPONENT)||LA88_4==36||LA88_4==57) ) {
                        alt88=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA88_5 = input.LA(2);

                    if ( ((LA88_5>=RULE_VERSION && LA88_5<=RULE_EXPONENT)||LA88_5==36||LA88_5==57) ) {
                        alt88=1;
                    }
                    }
                    break;
            }

            switch (alt88) {
                case 1 :
                    // InternalIvml.g:5353:4: (lv_type_0_0= ruleType )
                    {
                    // InternalIvml.g:5353:4: (lv_type_0_0= ruleType )
                    // InternalIvml.g:5354:5: lv_type_0_0= ruleType
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

            // InternalIvml.g:5371:3: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:5372:4: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:5372:4: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:5373:5: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_61);
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

            // InternalIvml.g:5390:3: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==18) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalIvml.g:5391:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalIvml.g:5395:4: ( (lv_id_3_0= ruleIdentifier ) )
            	    // InternalIvml.g:5396:5: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:5396:5: (lv_id_3_0= ruleIdentifier )
            	    // InternalIvml.g:5397:6: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
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
            	    break loop89;
                }
            } while (true);

            // InternalIvml.g:5415:3: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==19) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalIvml.g:5416:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalIvml.g:5420:4: ( (lv_init_5_0= ruleExpression ) )
                    // InternalIvml.g:5421:5: (lv_init_5_0= ruleExpression )
                    {
                    // InternalIvml.g:5421:5: (lv_init_5_0= ruleExpression )
                    // InternalIvml.g:5422:6: lv_init_5_0= ruleExpression
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


    // $ANTLR start "ruleActualArgumentList"
    // InternalIvml.g:5445:1: ruleActualArgumentList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* ) ;
    public final EObject ruleActualArgumentList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_args_0_0 = null;

        EObject lv_args_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5451:2: ( ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* ) )
            // InternalIvml.g:5452:2: ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* )
            {
            // InternalIvml.g:5452:2: ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* )
            // InternalIvml.g:5453:3: ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )*
            {
            // InternalIvml.g:5453:3: ( (lv_args_0_0= ruleActualArgument ) )
            // InternalIvml.g:5454:4: (lv_args_0_0= ruleActualArgument )
            {
            // InternalIvml.g:5454:4: (lv_args_0_0= ruleActualArgument )
            // InternalIvml.g:5455:5: lv_args_0_0= ruleActualArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActualArgumentListAccess().getArgsActualArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_48);
            lv_args_0_0=ruleActualArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActualArgumentListRule());
              					}
              					add(
              						current,
              						"args",
              						lv_args_0_0,
              						"de.uni_hildesheim.sse.Ivml.ActualArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIvml.g:5472:3: (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==18) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalIvml.g:5473:4: otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getActualArgumentListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalIvml.g:5477:4: ( (lv_args_2_0= ruleActualArgument ) )
            	    // InternalIvml.g:5478:5: (lv_args_2_0= ruleActualArgument )
            	    {
            	    // InternalIvml.g:5478:5: (lv_args_2_0= ruleActualArgument )
            	    // InternalIvml.g:5479:6: lv_args_2_0= ruleActualArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActualArgumentListAccess().getArgsActualArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_args_2_0=ruleActualArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActualArgumentListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"args",
            	      							lv_args_2_0,
            	      							"de.uni_hildesheim.sse.Ivml.ActualArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
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
    // $ANTLR end "ruleActualArgumentList"


    // $ANTLR start "entryRuleActualArgument"
    // InternalIvml.g:5501:1: entryRuleActualArgument returns [EObject current=null] : iv_ruleActualArgument= ruleActualArgument EOF ;
    public final EObject entryRuleActualArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualArgument = null;


        try {
            // InternalIvml.g:5501:55: (iv_ruleActualArgument= ruleActualArgument EOF )
            // InternalIvml.g:5502:2: iv_ruleActualArgument= ruleActualArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActualArgument=ruleActualArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualArgument; 
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
    // $ANTLR end "entryRuleActualArgument"


    // $ANTLR start "ruleActualArgument"
    // InternalIvml.g:5508:1: ruleActualArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) ) ;
    public final EObject ruleActualArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_arg_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5514:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) ) )
            // InternalIvml.g:5515:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) )
            {
            // InternalIvml.g:5515:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) )
            // InternalIvml.g:5516:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) )
            {
            // InternalIvml.g:5516:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt92=2;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // InternalIvml.g:5517:4: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalIvml.g:5517:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5518:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5518:5: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5519:6: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getActualArgumentAccess().getNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getActualArgumentRule());
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

                    otherlv_1=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getActualArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalIvml.g:5541:3: ( (lv_arg_2_0= ruleExpression ) )
            // InternalIvml.g:5542:4: (lv_arg_2_0= ruleExpression )
            {
            // InternalIvml.g:5542:4: (lv_arg_2_0= ruleExpression )
            // InternalIvml.g:5543:5: lv_arg_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActualArgumentAccess().getArgExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_arg_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActualArgumentRule());
              					}
              					set(
              						current,
              						"arg",
              						lv_arg_2_0,
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
    // $ANTLR end "ruleActualArgument"


    // $ANTLR start "entryRuleExpressionAccess"
    // InternalIvml.g:5564:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // InternalIvml.g:5564:57: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // InternalIvml.g:5565:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
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
    // InternalIvml.g:5571:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5577:2: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5578:2: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5578:2: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5579:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
              		
            }
            // InternalIvml.g:5583:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:5584:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:5584:4: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:5585:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalIvml.g:5602:3: ( (lv_calls_2_0= ruleCall ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA93_4 = input.LA(3);

                        if ( (LA93_4==24) ) {
                            alt93=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA93_5 = input.LA(3);

                        if ( (LA93_5==24) ) {
                            alt93=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA93_6 = input.LA(3);

                        if ( (LA93_6==24) ) {
                            alt93=1;
                        }


                        }
                        break;
                    case 57:
                        {
                        int LA93_7 = input.LA(3);

                        if ( (LA93_7==24) ) {
                            alt93=1;
                        }


                        }
                        break;
                    case 55:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                        {
                        alt93=1;
                        }
                        break;

                    }

                }
                else if ( ((LA93_0>=79 && LA93_0<=80)) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalIvml.g:5603:4: (lv_calls_2_0= ruleCall )
            	    {
            	    // InternalIvml.g:5603:4: (lv_calls_2_0= ruleCall )
            	    // InternalIvml.g:5604:5: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop93;
                }
            } while (true);

            // InternalIvml.g:5621:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==37) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalIvml.g:5622:4: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5622:4: (lv_access_3_0= ruleExpressionAccess )
                    // InternalIvml.g:5623:5: lv_access_3_0= ruleExpressionAccess
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
    // InternalIvml.g:5644:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalIvml.g:5644:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalIvml.g:5645:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalIvml.g:5651:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
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
            // InternalIvml.g:5657:2: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5658:2: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5658:2: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5659:3: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // InternalIvml.g:5659:3: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) )
            int alt95=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case RULE_STRING:
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 57:
                {
                alt95=1;
                }
                break;
            case 24:
                {
                alt95=2;
                }
                break;
            case 83:
                {
                alt95=3;
                }
                break;
            case 82:
                {
                alt95=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // InternalIvml.g:5660:4: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // InternalIvml.g:5660:4: ( (lv_lit_0_0= ruleLiteral ) )
                    // InternalIvml.g:5661:5: (lv_lit_0_0= ruleLiteral )
                    {
                    // InternalIvml.g:5661:5: (lv_lit_0_0= ruleLiteral )
                    // InternalIvml.g:5662:6: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
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
                    // InternalIvml.g:5680:4: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalIvml.g:5680:4: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalIvml.g:5681:5: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                      				
                    }
                    // InternalIvml.g:5685:5: ( (lv_ex_2_0= ruleExpression ) )
                    // InternalIvml.g:5686:6: (lv_ex_2_0= ruleExpression )
                    {
                    // InternalIvml.g:5686:6: (lv_ex_2_0= ruleExpression )
                    // InternalIvml.g:5687:7: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
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

                    otherlv_3=(Token)match(input,25,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:5710:4: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // InternalIvml.g:5710:4: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // InternalIvml.g:5711:5: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // InternalIvml.g:5711:5: (lv_ifEx_4_0= ruleIfExpression )
                    // InternalIvml.g:5712:6: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
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
                    // InternalIvml.g:5730:4: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalIvml.g:5730:4: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalIvml.g:5731:5: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,82,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                      				
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                      				
                    }
                    // InternalIvml.g:5739:5: ( (lv_refEx_7_0= ruleExpression ) )
                    // InternalIvml.g:5740:6: (lv_refEx_7_0= ruleExpression )
                    {
                    // InternalIvml.g:5740:6: (lv_refEx_7_0= ruleExpression )
                    // InternalIvml.g:5741:7: lv_refEx_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefExExpressionParserRuleCall_0_3_2_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
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

                    otherlv_8=(Token)match(input,25,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:5764:3: ( (lv_calls_9_0= ruleCall ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA96_4 = input.LA(3);

                        if ( (LA96_4==24) ) {
                            alt96=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA96_5 = input.LA(3);

                        if ( (LA96_5==24) ) {
                            alt96=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA96_6 = input.LA(3);

                        if ( (LA96_6==24) ) {
                            alt96=1;
                        }


                        }
                        break;
                    case 57:
                        {
                        int LA96_7 = input.LA(3);

                        if ( (LA96_7==24) ) {
                            alt96=1;
                        }


                        }
                        break;
                    case 55:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                        {
                        alt96=1;
                        }
                        break;

                    }

                }
                else if ( ((LA96_0>=79 && LA96_0<=80)) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalIvml.g:5765:4: (lv_calls_9_0= ruleCall )
            	    {
            	    // InternalIvml.g:5765:4: (lv_calls_9_0= ruleCall )
            	    // InternalIvml.g:5766:5: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop96;
                }
            } while (true);

            // InternalIvml.g:5783:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==37) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalIvml.g:5784:4: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5784:4: (lv_access_10_0= ruleExpressionAccess )
                    // InternalIvml.g:5785:5: lv_access_10_0= ruleExpressionAccess
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


    // $ANTLR start "entryRuleContainerInitializer"
    // InternalIvml.g:5806:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalIvml.g:5806:61: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalIvml.g:5807:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalIvml.g:5813:1: ruleContainerInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5819:2: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // InternalIvml.g:5820:2: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // InternalIvml.g:5820:2: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // InternalIvml.g:5821:3: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // InternalIvml.g:5821:3: ()
            // InternalIvml.g:5822:4: 
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

            // InternalIvml.g:5831:3: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=RULE_VERSION && LA98_0<=RULE_EXPONENT)||LA98_0==57) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalIvml.g:5832:4: (lv_type_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:5832:4: (lv_type_1_0= ruleQualifiedName )
                    // InternalIvml.g:5833:5: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContainerInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_type_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
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

            otherlv_2=(Token)match(input,14,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalIvml.g:5854:3: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( ((LA99_0>=RULE_NUMBER && LA99_0<=RULE_EXPONENT)||LA99_0==14||LA99_0==24||(LA99_0>=30 && LA99_0<=35)||(LA99_0>=38 && LA99_0<=44)||LA99_0==55||LA99_0==57||(LA99_0>=63 && LA99_0<=78)||(LA99_0>=82 && LA99_0<=83)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalIvml.g:5855:4: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // InternalIvml.g:5855:4: (lv_init_3_0= ruleExpressionListOrRange )
                    // InternalIvml.g:5856:5: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContainerInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_9);
                    lv_init_3_0=ruleExpressionListOrRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
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

              			newLeafNode(otherlv_4, grammarAccess.getContainerInitializerAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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


    // $ANTLR start "entryRuleExpressionListOrRange"
    // InternalIvml.g:5881:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // InternalIvml.g:5881:62: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // InternalIvml.g:5882:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
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
    // InternalIvml.g:5888:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5894:2: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // InternalIvml.g:5895:2: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // InternalIvml.g:5895:2: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // InternalIvml.g:5896:3: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // InternalIvml.g:5896:3: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // InternalIvml.g:5897:4: (lv_list_0_0= ruleExpressionListEntry )
            {
            // InternalIvml.g:5897:4: (lv_list_0_0= ruleExpressionListEntry )
            // InternalIvml.g:5898:5: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_48);
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

            // InternalIvml.g:5915:3: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==18) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalIvml.g:5916:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalIvml.g:5920:4: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // InternalIvml.g:5921:5: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // InternalIvml.g:5921:5: (lv_list_2_0= ruleExpressionListEntry )
            	    // InternalIvml.g:5922:6: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
            	    break loop100;
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
    // InternalIvml.g:5944:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // InternalIvml.g:5944:60: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // InternalIvml.g:5945:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
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
    // InternalIvml.g:5951:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_container_5_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:5957:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:5958:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:5958:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:5959:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:5959:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt102=2;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // InternalIvml.g:5960:4: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // InternalIvml.g:5960:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5961:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5961:5: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5962:6: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
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

                    // InternalIvml.g:5979:4: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==37) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalIvml.g:5980:5: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                              				
                            }
                            // InternalIvml.g:5984:5: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // InternalIvml.g:5985:6: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // InternalIvml.g:5985:6: (lv_attrib_2_0= ruleIdentifier )
                            // InternalIvml.g:5986:7: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_25);
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

                    otherlv_3=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            // InternalIvml.g:6009:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // InternalIvml.g:6010:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:6010:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    // InternalIvml.g:6011:5: (lv_value_4_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:6011:5: (lv_value_4_0= ruleImplicationExpression )
                    // InternalIvml.g:6012:6: lv_value_4_0= ruleImplicationExpression
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
                    // InternalIvml.g:6030:4: ( (lv_container_5_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:6030:4: ( (lv_container_5_0= ruleContainerInitializer ) )
                    // InternalIvml.g:6031:5: (lv_container_5_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:6031:5: (lv_container_5_0= ruleContainerInitializer )
                    // InternalIvml.g:6032:6: lv_container_5_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionListEntryAccess().getContainerContainerInitializerParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_5_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      						}
                      						set(
                      							current,
                      							"container",
                      							lv_container_5_0,
                      							"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
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
    // InternalIvml.g:6054:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalIvml.g:6054:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalIvml.g:6055:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalIvml.g:6061:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalIvml.g:6067:2: ( ( (lv_val_0_0= ruleValue ) ) )
            // InternalIvml.g:6068:2: ( (lv_val_0_0= ruleValue ) )
            {
            // InternalIvml.g:6068:2: ( (lv_val_0_0= ruleValue ) )
            // InternalIvml.g:6069:3: (lv_val_0_0= ruleValue )
            {
            // InternalIvml.g:6069:3: (lv_val_0_0= ruleValue )
            // InternalIvml.g:6070:4: lv_val_0_0= ruleValue
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
    // InternalIvml.g:6090:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalIvml.g:6090:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalIvml.g:6091:2: iv_ruleIfExpression= ruleIfExpression EOF
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
    // InternalIvml.g:6097:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) ;
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
            // InternalIvml.g:6103:2: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) )
            // InternalIvml.g:6104:2: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            {
            // InternalIvml.g:6104:2: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            // InternalIvml.g:6105:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
              		
            }
            // InternalIvml.g:6109:3: ( (lv_ifEx_1_0= ruleExpression ) )
            // InternalIvml.g:6110:4: (lv_ifEx_1_0= ruleExpression )
            {
            // InternalIvml.g:6110:4: (lv_ifEx_1_0= ruleExpression )
            // InternalIvml.g:6111:5: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_63);
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

            otherlv_2=(Token)match(input,84,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
              		
            }
            // InternalIvml.g:6132:3: ( (lv_thenEx_3_0= ruleOptBlockExpression ) )
            // InternalIvml.g:6133:4: (lv_thenEx_3_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:6133:4: (lv_thenEx_3_0= ruleOptBlockExpression )
            // InternalIvml.g:6134:5: lv_thenEx_3_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExOptBlockExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_64);
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

            otherlv_4=(Token)match(input,85,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
              		
            }
            // InternalIvml.g:6155:3: ( (lv_elseEx_5_0= ruleOptBlockExpression ) )
            // InternalIvml.g:6156:4: (lv_elseEx_5_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:6156:4: (lv_elseEx_5_0= ruleOptBlockExpression )
            // InternalIvml.g:6157:5: lv_elseEx_5_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExOptBlockExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_65);
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

            otherlv_6=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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
    // InternalIvml.g:6182:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalIvml.g:6182:50: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalIvml.g:6183:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalIvml.g:6189:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalIvml.g:6195:2: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalIvml.g:6196:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalIvml.g:6196:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt104=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt104=1;
                }
                break;
            case RULE_VERSION:
                {
                alt104=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt104=3;
                }
                break;
            case 57:
                {
                alt104=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalIvml.g:6197:3: this_ID_0= RULE_ID
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
                    // InternalIvml.g:6205:3: this_VERSION_1= RULE_VERSION
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
                    // InternalIvml.g:6213:3: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalIvml.g:6221:3: kw= 'version'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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


        // InternalIvml.g:161:4: ( (lv_version_3_0= ruleVersionStmt ) )
        // InternalIvml.g:161:4: (lv_version_3_0= ruleVersionStmt )
        {
        // InternalIvml.g:161:4: (lv_version_3_0= ruleVersionStmt )
        // InternalIvml.g:162:5: lv_version_3_0= ruleVersionStmt
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

    // $ANTLR start synpred3_InternalIvml
    public final void synpred3_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_imports_4_0 = null;


        // InternalIvml.g:180:4: ( (lv_imports_4_0= ruleImportStmt ) )
        // InternalIvml.g:180:4: (lv_imports_4_0= ruleImportStmt )
        {
        // InternalIvml.g:180:4: (lv_imports_4_0= ruleImportStmt )
        // InternalIvml.g:181:5: lv_imports_4_0= ruleImportStmt
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getProjectAccess().getImportsImportStmtParserRuleCall_4_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_imports_4_0=ruleImportStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalIvml

    // $ANTLR start synpred8_InternalIvml
    public final void synpred8_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_2_0 = null;


        // InternalIvml.g:315:4: ( ( (lv_elements_2_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:315:4: ( (lv_elements_2_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:315:4: ( (lv_elements_2_0= ruleVariableDeclaration ) )
        // InternalIvml.g:316:5: (lv_elements_2_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:316:5: (lv_elements_2_0= ruleVariableDeclaration )
        // InternalIvml.g:317:6: lv_elements_2_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsVariableDeclarationParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_2_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalIvml

    // $ANTLR start synpred11_InternalIvml
    public final void synpred11_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_5_0 = null;


        // InternalIvml.g:375:4: ( ( (lv_elements_5_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:375:4: ( (lv_elements_5_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:375:4: ( (lv_elements_5_0= ruleExpressionStatement ) )
        // InternalIvml.g:376:5: (lv_elements_5_0= ruleExpressionStatement )
        {
        // InternalIvml.g:376:5: (lv_elements_5_0= ruleExpressionStatement )
        // InternalIvml.g:377:6: lv_elements_5_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsExpressionStatementParserRuleCall_1_4_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_5_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred11_InternalIvml

    // $ANTLR start synpred23_InternalIvml
    public final void synpred23_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_8_0 = null;


        // InternalIvml.g:824:4: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:824:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:824:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        // InternalIvml.g:825:5: (lv_elements_8_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:825:5: (lv_elements_8_0= ruleVariableDeclaration )
        // InternalIvml.g:826:6: lv_elements_8_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_8_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred23_InternalIvml

    // $ANTLR start synpred24_InternalIvml
    public final void synpred24_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_9_0 = null;


        // InternalIvml.g:844:4: ( ( (lv_elements_9_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:844:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:844:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
        // InternalIvml.g:845:5: (lv_elements_9_0= ruleExpressionStatement )
        {
        // InternalIvml.g:845:5: (lv_elements_9_0= ruleExpressionStatement )
        // InternalIvml.g:846:6: lv_elements_9_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_9_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalIvml

    // $ANTLR start synpred29_InternalIvml
    public final void synpred29_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_8_0 = null;


        // InternalIvml.g:998:4: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:998:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:998:4: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        // InternalIvml.g:999:5: (lv_elements_8_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:999:5: (lv_elements_8_0= ruleVariableDeclaration )
        // InternalIvml.g:1000:6: lv_elements_8_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_8_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred29_InternalIvml

    // $ANTLR start synpred30_InternalIvml
    public final void synpred30_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_9_0 = null;


        // InternalIvml.g:1018:4: ( ( (lv_elements_9_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:1018:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:1018:4: ( (lv_elements_9_0= ruleExpressionStatement ) )
        // InternalIvml.g:1019:5: (lv_elements_9_0= ruleExpressionStatement )
        {
        // InternalIvml.g:1019:5: (lv_elements_9_0= ruleExpressionStatement )
        // InternalIvml.g:1020:6: lv_elements_9_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_9_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred30_InternalIvml

    // $ANTLR start synpred49_InternalIvml
    public final void synpred49_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalIvml.g:1865:3: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalIvml.g:1865:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalIvml.g:1865:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalIvml.g:1866:4: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalIvml.g:1866:4: (lv_qValue_2_0= ruleQualifiedName )
        // InternalIvml.g:1867:5: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred49_InternalIvml

    // $ANTLR start synpred54_InternalIvml
    public final void synpred54_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_tValue_6_0 = null;


        // InternalIvml.g:1943:3: ( ( (lv_tValue_6_0= ruleType ) ) )
        // InternalIvml.g:1943:3: ( (lv_tValue_6_0= ruleType ) )
        {
        // InternalIvml.g:1943:3: ( (lv_tValue_6_0= ruleType ) )
        // InternalIvml.g:1944:4: (lv_tValue_6_0= ruleType )
        {
        // InternalIvml.g:1944:4: (lv_tValue_6_0= ruleType )
        // InternalIvml.g:1945:5: lv_tValue_6_0= ruleType
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getValueAccess().getTValueTypeParserRuleCall_6_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_tValue_6_0=ruleType();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred54_InternalIvml

    // $ANTLR start synpred55_InternalIvml
    public final void synpred55_InternalIvml_fragment() throws RecognitionException {   
        // InternalIvml.g:1964:4: ( ( RULE_VERSION ) )
        // InternalIvml.g:1964:5: ( RULE_VERSION )
        {
        // InternalIvml.g:1964:5: ( RULE_VERSION )
        // InternalIvml.g:1965:5: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred55_InternalIvml

    // $ANTLR start synpred78_InternalIvml
    public final void synpred78_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_annotations_0_0 = null;


        // InternalIvml.g:2918:4: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )
        // InternalIvml.g:2918:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
        {
        // InternalIvml.g:2918:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
        // InternalIvml.g:2919:5: lv_annotations_0_0= ruleAnnotationDeclarations
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getOpDefStatementAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_0_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_annotations_0_0=ruleAnnotationDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred78_InternalIvml

    // $ANTLR start synpred80_InternalIvml
    public final void synpred80_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_10=null;
        EObject lv_impl_9_0 = null;


        // InternalIvml.g:3024:4: ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // InternalIvml.g:3024:4: ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        // InternalIvml.g:3024:4: ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' )
        // InternalIvml.g:3025:5: ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        // InternalIvml.g:3025:5: ( (lv_impl_9_0= ruleExpression ) )
        // InternalIvml.g:3026:6: (lv_impl_9_0= ruleExpression )
        {
        // InternalIvml.g:3026:6: (lv_impl_9_0= ruleExpression )
        // InternalIvml.g:3027:7: lv_impl_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_9_0_0_0());
          						
        }
        pushFollow(FOLLOW_14);
        lv_impl_9_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred80_InternalIvml

    // $ANTLR start synpred87_InternalIvml
    public final void synpred87_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_expr_0_0 = null;


        // InternalIvml.g:3527:3: ( ( (lv_expr_0_0= ruleExpression ) ) )
        // InternalIvml.g:3527:3: ( (lv_expr_0_0= ruleExpression ) )
        {
        // InternalIvml.g:3527:3: ( (lv_expr_0_0= ruleExpression ) )
        // InternalIvml.g:3528:4: (lv_expr_0_0= ruleExpression )
        {
        // InternalIvml.g:3528:4: (lv_expr_0_0= ruleExpression )
        // InternalIvml.g:3529:5: lv_expr_0_0= ruleExpression
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
    // $ANTLR end synpred87_InternalIvml

    // $ANTLR start synpred109_InternalIvml
    public final void synpred109_InternalIvml_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_op_0_0 = null;


        // InternalIvml.g:4721:4: ( (lv_op_0_0= ruleUnaryOperator ) )
        // InternalIvml.g:4721:4: (lv_op_0_0= ruleUnaryOperator )
        {
        // InternalIvml.g:4721:4: (lv_op_0_0= ruleUnaryOperator )
        // InternalIvml.g:4722:5: lv_op_0_0= ruleUnaryOperator
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_op_0_0=ruleUnaryOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred109_InternalIvml

    // $ANTLR start synpred124_InternalIvml
    public final void synpred124_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalIvml.g:5228:4: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalIvml.g:5228:4: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalIvml.g:5228:4: (lv_decl_2_0= ruleDeclarator )
        // InternalIvml.g:5229:5: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getContainerOpAccess().getDeclDeclaratorParserRuleCall_2_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred124_InternalIvml

    // $ANTLR start synpred131_InternalIvml
    public final void synpred131_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


        // InternalIvml.g:5517:4: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )
        // InternalIvml.g:5517:4: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
        {
        // InternalIvml.g:5517:4: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5518:5: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5518:5: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5519:6: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getActualArgumentAccess().getNameIdentifierParserRuleCall_0_0_0());
          					
        }
        pushFollow(FOLLOW_25);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_1=(Token)match(input,19,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred131_InternalIvml

    // $ANTLR start synpred143_InternalIvml
    public final void synpred143_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;


        // InternalIvml.g:5960:4: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )
        // InternalIvml.g:5960:4: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
        {
        // InternalIvml.g:5960:4: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5961:5: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5961:5: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5962:6: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0());
          					
        }
        pushFollow(FOLLOW_62);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalIvml.g:5979:4: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( (LA112_0==37) ) {
            alt112=1;
        }
        switch (alt112) {
            case 1 :
                // InternalIvml.g:5980:5: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                {
                otherlv_1=(Token)match(input,37,FOLLOW_4); if (state.failed) return ;
                // InternalIvml.g:5984:5: ( (lv_attrib_2_0= ruleIdentifier ) )
                // InternalIvml.g:5985:6: (lv_attrib_2_0= ruleIdentifier )
                {
                // InternalIvml.g:5985:6: (lv_attrib_2_0= ruleIdentifier )
                // InternalIvml.g:5986:7: lv_attrib_2_0= ruleIdentifier
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0());
                  						
                }
                pushFollow(FOLLOW_25);
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
    // $ANTLR end synpred143_InternalIvml

    // Delegated rules

    public final boolean synpred11_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred131_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalIvml_fragment(); // can never throw exception
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
    public final boolean synpred109_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalIvml_fragment(); // can never throw exception
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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA103 dfa103 = new DFA103(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\4\1\uffff\4\6\1\uffff\1\6\1\4\1\0\4\6";
    static final String dfa_3s = "\1\123\1\uffff\4\120\1\uffff\1\71\1\123\1\0\4\120";
    static final String dfa_4s = "\1\uffff\1\2\4\uffff\1\1\7\uffff";
    static final String dfa_5s = "\11\uffff\1\0\4\uffff}>";
    static final String[] dfa_6s = {
            "\2\1\1\3\1\2\1\4\5\uffff\2\1\1\uffff\1\1\2\uffff\2\1\1\uffff\2\1\2\uffff\1\1\1\uffff\7\1\2\uffff\12\1\2\uffff\2\1\1\uffff\2\6\2\1\1\5\1\1\1\uffff\2\1\1\uffff\20\1\3\uffff\2\1",
            "",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\4\uffff\1\1\3\uffff\1\6\7\uffff\1\7\1\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\4\uffff\1\1\3\uffff\1\6\7\uffff\1\7\1\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\4\uffff\1\1\3\uffff\1\6\7\uffff\1\7\1\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\4\uffff\1\1\3\uffff\1\6\7\uffff\1\7\1\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "",
            "\1\13\1\12\1\14\60\uffff\1\15",
            "\5\1\7\uffff\1\6\7\uffff\1\1\3\uffff\1\6\1\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\1\5\uffff\20\1\3\uffff\2\1",
            "\1\uffff",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\10\uffff\1\6\7\uffff\2\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\10\uffff\1\6\7\uffff\2\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\10\uffff\1\6\7\uffff\2\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1",
            "\3\1\5\uffff\1\1\1\uffff\1\11\2\uffff\1\1\10\uffff\1\6\7\uffff\2\1\21\uffff\1\10\1\uffff\1\1\5\uffff\17\1\1\uffff\2\1"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 179:3: ( (lv_imports_4_0= ruleImportStmt ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_9 = input.LA(1);

                         
                        int index3_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalIvml()) ) {s = 6;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\70\uffff";
    static final String dfa_8s = "\1\1\67\uffff";
    static final String dfa_9s = "\1\4\7\uffff\15\0\43\uffff";
    static final String dfa_10s = "\1\123\7\uffff\15\0\43\uffff";
    static final String dfa_11s = "\1\uffff\1\11\1\uffff\1\1\3\uffff\1\2\15\uffff\1\3\1\4\1\5\33\uffff\1\6\1\uffff\1\7\1\uffff\1\10";
    static final String dfa_12s = "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\43\uffff}>";
    static final String[] dfa_13s = {
            "\2\27\1\17\1\16\1\20\5\uffff\1\27\1\1\1\uffff\1\3\2\uffff\2\3\1\uffff\1\67\1\27\2\uffff\1\3\1\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\2\uffff\4\27\1\22\1\23\1\24\2\63\1\25\2\uffff\1\26\4\uffff\1\27\1\uffff\1\21\1\65\1\uffff\1\65\1\27\1\uffff\20\27\3\uffff\2\27",
            "",
            "",
            "",
            "",
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

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 294:3: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_8 = input.LA(1);

                         
                        int index7_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_10 = input.LA(1);

                         
                        int index7_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_12 = input.LA(1);

                         
                        int index7_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_13 = input.LA(1);

                         
                        int index7_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA7_14 = input.LA(1);

                         
                        int index7_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA7_15 = input.LA(1);

                         
                        int index7_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA7_16 = input.LA(1);

                         
                        int index7_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA7_17 = input.LA(1);

                         
                        int index7_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_18);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA7_19 = input.LA(1);

                         
                        int index7_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_19);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA7_20 = input.LA(1);

                         
                        int index7_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\56\uffff";
    static final String dfa_15s = "\1\4\2\uffff\15\0\36\uffff";
    static final String dfa_16s = "\1\123\2\uffff\15\0\36\uffff";
    static final String dfa_17s = "\1\uffff\1\5\1\1\15\uffff\1\2\33\uffff\1\3\1\4";
    static final String dfa_18s = "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\36\uffff}>";
    static final String[] dfa_19s = {
            "\2\20\1\12\1\11\1\13\5\uffff\1\20\1\1\7\uffff\1\54\1\20\4\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\4\20\1\15\1\16\1\17\5\uffff\1\55\4\uffff\1\20\1\uffff\1\14\3\uffff\1\20\1\uffff\20\20\3\uffff\2\20",
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

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 823:3: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_6 = input.LA(1);

                         
                        int index15_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_7 = input.LA(1);

                         
                        int index15_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_8 = input.LA(1);

                         
                        int index15_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_9 = input.LA(1);

                         
                        int index15_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA15_10 = input.LA(1);

                         
                        int index15_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA15_11 = input.LA(1);

                         
                        int index15_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA15_12 = input.LA(1);

                         
                        int index15_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA15_13 = input.LA(1);

                         
                        int index15_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA15_14 = input.LA(1);

                         
                        int index15_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA15_15 = input.LA(1);

                         
                        int index15_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_20s = "\55\uffff";
    static final String dfa_21s = "\1\4\2\uffff\15\0\35\uffff";
    static final String dfa_22s = "\1\123\2\uffff\15\0\35\uffff";
    static final String dfa_23s = "\1\uffff\1\4\1\1\15\uffff\1\2\33\uffff\1\3";
    static final String dfa_24s = "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\35\uffff}>";
    static final String[] dfa_25s = {
            "\2\20\1\12\1\11\1\13\5\uffff\1\20\1\1\7\uffff\1\54\1\20\4\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\4\20\1\15\1\16\1\17\12\uffff\1\20\1\uffff\1\14\3\uffff\1\20\1\uffff\20\20\3\uffff\2\20",
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

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()+ loopback of 997:3: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_4 = input.LA(1);

                         
                        int index18_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_6 = input.LA(1);

                         
                        int index18_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_7 = input.LA(1);

                         
                        int index18_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_26s = "\15\uffff";
    static final String dfa_27s = "\1\4\2\uffff\4\0\6\uffff";
    static final String dfa_28s = "\1\71\2\uffff\4\0\6\uffff";
    static final String dfa_29s = "\1\uffff\1\1\1\2\4\uffff\1\4\1\5\1\6\1\7\1\3\1\10";
    static final String dfa_30s = "\3\uffff\1\1\1\3\1\2\1\0\6\uffff}>";
    static final String[] dfa_31s = {
            "\1\1\1\2\1\4\1\3\1\5\25\uffff\6\12\2\uffff\2\7\1\10\1\11\3\12\14\uffff\1\6",
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
            ""
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "1825:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                        else if ( (synpred55_InternalIvml()) ) {s = 12;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_32s = "\53\uffff";
    static final String dfa_33s = "\1\4\50\uffff\1\0\1\uffff";
    static final String dfa_34s = "\1\123\50\uffff\1\0\1\uffff";
    static final String dfa_35s = "\1\uffff\1\1\50\uffff\1\2";
    static final String dfa_36s = "\51\uffff\1\0\1\uffff}>";
    static final String[] dfa_37s = {
            "\5\1\5\uffff\1\51\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\20\1\3\uffff\2\1",
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

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "3023:3: ( ( ( (lv_impl_9_0= ruleExpression ) ) otherlv_10= ';' ) | ( (lv_block_11_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_41 = input.LA(1);

                         
                        int index53_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index53_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_38s = "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String dfa_39s = "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_40s = "\1\123\2\uffff\4\126\1\uffff\1\71\4\126\1\71";
    static final String dfa_41s = "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String dfa_42s = "\16\uffff}>";
    static final String[] dfa_43s = {
            "\2\2\1\4\1\3\1\5\5\uffff\1\7\11\uffff\1\2\5\uffff\6\2\2\uffff\7\2\12\uffff\1\2\1\uffff\1\6\3\uffff\1\1\1\uffff\20\2\3\uffff\2\2",
            "",
            "",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "",
            "\1\12\1\11\1\13\60\uffff\1\14",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\6\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\12\1\11\1\13\60\uffff\1\14"
    };
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[][] dfa_43 = unpackEncodedStringArray(dfa_43s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_1;
            this.eof = dfa_38;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_42;
            this.transition = dfa_43;
        }
        public String getDescription() {
            return "3341:2: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "3526:2: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_41 = input.LA(1);

                         
                        int index59_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index59_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_44s = "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String dfa_45s = "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_46s = "\1\123\1\uffff\4\126\1\uffff\1\71\4\126\1\71";
    static final String dfa_47s = "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String dfa_48s = "\15\uffff}>";
    static final String[] dfa_49s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\5\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_26;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "3707:3: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }
    static final String[] dfa_50s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\5\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\6\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final short[][] dfa_50 = unpackEncodedStringArray(dfa_50s);

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = dfa_26;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_50;
        }
        public String getDescription() {
            return "4159:3: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }
    static final String dfa_51s = "\51\uffff";
    static final String dfa_52s = "\1\4\2\0\46\uffff";
    static final String dfa_53s = "\1\123\2\0\46\uffff";
    static final String dfa_54s = "\3\uffff\1\2\44\uffff\1\1";
    static final String dfa_55s = "\1\uffff\1\0\1\1\46\uffff}>";
    static final String[] dfa_56s = {
            "\5\3\17\uffff\1\3\5\uffff\6\3\2\uffff\7\3\12\uffff\1\3\1\uffff\1\3\5\uffff\15\3\1\2\1\3\1\1\3\uffff\2\3",
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

    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_51;
            this.eof = dfa_51;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_55;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "4720:3: ( (lv_op_0_0= ruleUnaryOperator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_1 = input.LA(1);

                         
                        int index77_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_InternalIvml()) ) {s = 40;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index77_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_2 = input.LA(1);

                         
                        int index77_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_InternalIvml()) ) {s = 40;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index77_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_57s = "\54\uffff";
    static final String dfa_58s = "\1\4\15\0\36\uffff";
    static final String dfa_59s = "\1\123\15\0\36\uffff";
    static final String dfa_60s = "\16\uffff\1\2\34\uffff\1\1";
    static final String dfa_61s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\36\uffff}>";
    static final String[] dfa_62s = {
            "\2\16\1\10\1\7\1\11\5\uffff\1\16\11\uffff\2\16\4\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\4\16\1\13\1\14\1\15\12\uffff\1\16\1\uffff\1\12\3\uffff\1\16\1\uffff\20\16\3\uffff\2\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] dfa_57 = DFA.unpackEncodedString(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[][] dfa_62 = unpackEncodedStringArray(dfa_62s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_57;
            this.eof = dfa_57;
            this.min = dfa_58;
            this.max = dfa_59;
            this.accept = dfa_60;
            this.special = dfa_61;
            this.transition = dfa_62;
        }
        public String getDescription() {
            return "5227:3: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA85_1 = input.LA(1);

                         
                        int index85_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA85_2 = input.LA(1);

                         
                        int index85_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA85_3 = input.LA(1);

                         
                        int index85_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA85_4 = input.LA(1);

                         
                        int index85_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA85_5 = input.LA(1);

                         
                        int index85_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA85_6 = input.LA(1);

                         
                        int index85_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA85_7 = input.LA(1);

                         
                        int index85_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA85_8 = input.LA(1);

                         
                        int index85_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA85_9 = input.LA(1);

                         
                        int index85_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA85_10 = input.LA(1);

                         
                        int index85_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA85_11 = input.LA(1);

                         
                        int index85_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA85_12 = input.LA(1);

                         
                        int index85_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA85_13 = input.LA(1);

                         
                        int index85_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index85_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 85, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_63s = "\1\4\4\0\46\uffff";
    static final String dfa_64s = "\1\123\4\0\46\uffff";
    static final String dfa_65s = "\5\uffff\1\2\44\uffff\1\1";
    static final String dfa_66s = "\1\uffff\1\0\1\1\1\2\1\3\46\uffff}>";
    static final String[] dfa_67s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\5\uffff\6\5\2\uffff\7\5\12\uffff\1\5\1\uffff\1\4\3\uffff\1\5\1\uffff\20\5\3\uffff\2\5",
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
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final short[][] dfa_67 = unpackEncodedStringArray(dfa_67s);

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_63;
            this.max = dfa_64;
            this.accept = dfa_65;
            this.special = dfa_66;
            this.transition = dfa_67;
        }
        public String getDescription() {
            return "5516:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?";
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
                        if ( (synpred131_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_2 = input.LA(1);

                         
                        int index92_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred131_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_3 = input.LA(1);

                         
                        int index92_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred131_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index92_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_4 = input.LA(1);

                         
                        int index92_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred131_InternalIvml()) ) {s = 42;}

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
    static final String dfa_68s = "\52\uffff";
    static final String dfa_69s = "\1\4\4\0\45\uffff";
    static final String dfa_70s = "\1\123\4\0\45\uffff";
    static final String dfa_71s = "\5\uffff\1\2\43\uffff\1\1";
    static final String dfa_72s = "\1\uffff\1\0\1\1\1\2\1\3\45\uffff}>";
    static final String[] dfa_73s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\5\uffff\6\5\2\uffff\7\5\12\uffff\1\5\1\uffff\1\4\5\uffff\20\5\3\uffff\2\5",
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

    static final short[] dfa_68 = DFA.unpackEncodedString(dfa_68s);
    static final char[] dfa_69 = DFA.unpackEncodedStringToUnsignedChars(dfa_69s);
    static final char[] dfa_70 = DFA.unpackEncodedStringToUnsignedChars(dfa_70s);
    static final short[] dfa_71 = DFA.unpackEncodedString(dfa_71s);
    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[][] dfa_73 = unpackEncodedStringArray(dfa_73s);

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = dfa_68;
            this.eof = dfa_68;
            this.min = dfa_69;
            this.max = dfa_70;
            this.accept = dfa_71;
            this.special = dfa_72;
            this.transition = dfa_73;
        }
        public String getDescription() {
            return "5959:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA102_1 = input.LA(1);

                         
                        int index102_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index102_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA102_2 = input.LA(1);

                         
                        int index102_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index102_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA102_3 = input.LA(1);

                         
                        int index102_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index102_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA102_4 = input.LA(1);

                         
                        int index102_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index102_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 102, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_74s = "\1\123\1\uffff\4\120\1\uffff\1\71\4\120\1\71";
    static final String[] dfa_75s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\5\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\7\uffff\17\1\1\uffff\2\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final short[][] dfa_75 = unpackEncodedStringArray(dfa_75s);

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_26;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_74;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_75;
        }
        public String getDescription() {
            return "6009:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x02000000000001C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xB7ECFFCFE9B2C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xB78CFFCFE9B2C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xB68CFFCFE9B2C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xB684FFCFE9B241F2L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xB684FFCFE9B2C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xB684FFCFE9B241F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x82801FCFE10001F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x02001C0FE00001C0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xA2801FCFE10041F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x02000020000001C0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x02000020000081C0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001000000010002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xA2841FCFE100C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xA2801FCFE100C1F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000008000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0080001010010000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0080000010010000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0A001C0FE00001C0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x02001C0FE20001C0L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000070L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000780L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0080000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000002000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x82800000000001C0L,0x0000000000007FFFL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xA2801FCFE30041F0L,0x00000000000C7FFFL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000002000080000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});

}